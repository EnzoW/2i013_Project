/*
 * Copyright (c) 2008 Sun Microsystems, Inc. All Rights Reserved.
 * Copyright (c) 2010 JogAmp Community. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN
 * MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR
 * ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR
 * DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE
 * DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY,
 * ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF
 * SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 */

package jogamp.opengl.windows.wgl;

import javax.media.nativewindow.AbstractGraphicsConfiguration;
import javax.media.nativewindow.AbstractGraphicsDevice;
import javax.media.nativewindow.AbstractGraphicsScreen;
import javax.media.nativewindow.CapabilitiesChooser;
import javax.media.nativewindow.DefaultGraphicsScreen;
import javax.media.nativewindow.GraphicsConfigurationFactory;
import javax.media.nativewindow.CapabilitiesImmutable;
import javax.media.nativewindow.NativeSurface;
import javax.media.nativewindow.NativeWindowFactory;
import javax.media.nativewindow.VisualIDHolder;
import javax.media.opengl.GLCapabilitiesImmutable;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLException;
import javax.media.opengl.GLProfile;

import com.jogamp.common.nio.Buffers;

import jogamp.nativewindow.windows.GDI;
import jogamp.nativewindow.windows.PIXELFORMATDESCRIPTOR;
import jogamp.opengl.GLDrawableImpl;
import jogamp.opengl.GLGraphicsConfigurationFactory;
import jogamp.opengl.GLGraphicsConfigurationUtil;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Subclass of GraphicsConfigurationFactory used when non-AWT tookits
    are used on Windows platforms. Toolkits will likely need to delegate
    to this one to change the accepted and returned types of the
    GraphicsDevice and GraphicsConfiguration abstractions. */

public class WindowsWGLGraphicsConfigurationFactory extends GLGraphicsConfigurationFactory {
    static VisualIDHolder.VIDComparator PfdIDComparator = new VisualIDHolder.VIDComparator(VisualIDHolder.VIDType.WIN32_PFD);

    static void registerFactory() {
        GraphicsConfigurationFactory.registerFactory(com.jogamp.nativewindow.windows.WindowsGraphicsDevice.class, GLCapabilitiesImmutable.class, new WindowsWGLGraphicsConfigurationFactory());
    }
    private WindowsWGLGraphicsConfigurationFactory() {
    }

    protected AbstractGraphicsConfiguration chooseGraphicsConfigurationImpl(
            CapabilitiesImmutable capsChosen, CapabilitiesImmutable capsRequested, CapabilitiesChooser chooser, AbstractGraphicsScreen absScreen, int nativeVisualID) {

        if (! (capsChosen instanceof GLCapabilitiesImmutable) ) {
            throw new IllegalArgumentException("This NativeWindowFactory accepts only GLCapabilities objects - chosen");
        }

        if (! (capsRequested instanceof GLCapabilitiesImmutable) ) {
            throw new IllegalArgumentException("This NativeWindowFactory accepts only GLCapabilities objects - requested");
        }

        if (chooser != null && !(chooser instanceof GLCapabilitiesChooser)) {
            throw new IllegalArgumentException("This NativeWindowFactory accepts only GLCapabilitiesChooser objects");
        }
        
        return chooseGraphicsConfigurationStatic((GLCapabilitiesImmutable)capsChosen, (GLCapabilitiesImmutable)capsRequested, (GLCapabilitiesChooser)chooser, absScreen);
    }

    static WindowsWGLGraphicsConfiguration createDefaultGraphicsConfiguration(GLCapabilitiesImmutable caps,
                                                                              AbstractGraphicsScreen absScreen) {
        return chooseGraphicsConfigurationStatic(caps, caps, null, absScreen);
    }

    static WindowsWGLGraphicsConfiguration chooseGraphicsConfigurationStatic(GLCapabilitiesImmutable capsChosen,
                                                                             GLCapabilitiesImmutable capsReq,
                                                                             GLCapabilitiesChooser chooser,
                                                                             AbstractGraphicsScreen absScreen) {
        if(null==absScreen) {
            absScreen = DefaultGraphicsScreen.createDefault(NativeWindowFactory.TYPE_WINDOWS);
        }
        final AbstractGraphicsDevice absDevice = absScreen.getDevice();
        capsChosen = GLGraphicsConfigurationUtil.fixGLCapabilities( capsChosen, GLDrawableFactory.getDesktopFactory(), absDevice);
        return new WindowsWGLGraphicsConfiguration( absScreen, capsChosen, capsReq, (GLCapabilitiesChooser)chooser );
    }

    protected static List<GLCapabilitiesImmutable> getAvailableCapabilities(WindowsWGLDrawableFactory factory, AbstractGraphicsDevice device) {
        final WindowsWGLDrawableFactory.SharedResource sharedResource = factory.getOrCreateSharedResource(device);
        if(null == sharedResource) {
            throw new GLException("Shared resource for device n/a: "+device);
        }
        final GLDrawableImpl sharedDrawable = sharedResource.getDrawable();
        final GLContext sharedContext = sharedResource.getContext();
        final GLProfile glp = GLProfile.getDefault(device);

        List<GLCapabilitiesImmutable> availableCaps = null;
        
        if ( sharedResource.needsCurrentContext4ARBPFDQueries() ) {
            if(GLContext.CONTEXT_NOT_CURRENT == sharedContext.makeCurrent()) {
                throw new GLException("Could not make Shared Context current: "+device);
            }
        } else {
            sharedDrawable.lockSurface();
        }
        try {
            long hdc = sharedDrawable.getHandle();
            if (0 == hdc) {
                throw new GLException("Error: HDC is null");
            }
            if (sharedResource.hasARBPixelFormat()) {
                availableCaps = WindowsWGLGraphicsConfigurationFactory.getAvailableGLCapabilitiesARB(sharedResource, sharedResource.getDevice(), glp, hdc);
            }
            if( null == availableCaps || availableCaps.isEmpty() ) {
                availableCaps = getAvailableGLCapabilitiesGDI(device, glp, hdc);
            }
        } finally {
            if ( sharedResource.needsCurrentContext4ARBPFDQueries() ) {
                sharedContext.release();    
            } else {
                sharedDrawable.unlockSurface();
            }            
        }

        if( null != availableCaps && availableCaps.size() > 1 ) {
            Collections.sort(availableCaps, PfdIDComparator);
        }
        return availableCaps;
    }

    static List<GLCapabilitiesImmutable> getAvailableGLCapabilitiesARB(WindowsWGLDrawableFactory.SharedResource sharedResource, AbstractGraphicsDevice device, GLProfile glProfile, long hdc) {
        final int pfdIDCount = WindowsWGLGraphicsConfiguration.wglARBPFDIDCount((WindowsWGLContext)sharedResource.getContext(), hdc);
        final int[] pformats = WindowsWGLGraphicsConfiguration.wglAllARBPFDIDs(pfdIDCount);
        return WindowsWGLGraphicsConfiguration.wglARBPFIDs2GLCapabilities(sharedResource, device, glProfile, hdc, pformats, GLGraphicsConfigurationUtil.ALL_BITS);
    }

    static List<GLCapabilitiesImmutable> getAvailableGLCapabilitiesGDI(AbstractGraphicsDevice device, GLProfile glProfile, long hdc) {
        int[] pformats = WindowsWGLGraphicsConfiguration.wglAllGDIPFIDs(hdc);
        int numFormats = pformats.length;
        List<GLCapabilitiesImmutable> bucket = new ArrayList<GLCapabilitiesImmutable>(numFormats);
        for (int i = 0; i < numFormats; i++) {
            final GLCapabilitiesImmutable caps = WindowsWGLGraphicsConfiguration.PFD2GLCapabilities(device, glProfile, hdc, pformats[i], GLGraphicsConfigurationUtil.ALL_BITS);
            if(null != caps) {
                bucket.add(caps);
            }
        }
        return bucket;
    }

    /**
     *
     * @param chooser
     * @param _factory
     * @param ns
     * @param pfIDs optional pool of preselected PixelFormat IDs, maybe null for unrestricted selection
     */
    static void updateGraphicsConfiguration(CapabilitiesChooser chooser,
                                            GLDrawableFactory factory, NativeSurface ns, int[] pfdIDs) {
        if (chooser != null && !(chooser instanceof GLCapabilitiesChooser)) {
            throw new IllegalArgumentException("This NativeWindowFactory accepts only GLCapabilitiesChooser objects");
        }
        if (factory == null) {
            throw new IllegalArgumentException("GLDrawableFactory is null");
        }
        if (ns == null) {
            throw new IllegalArgumentException("NativeSurface is null");
        }

        if(NativeSurface.LOCK_SURFACE_NOT_READY >= ns.lockSurface()) {
            throw new GLException("Surface not ready (lockSurface)");
        }
        try {
            long hdc = ns.getSurfaceHandle();
            if (0 == hdc) {
                throw new GLException("Error: HDC is null");
            }
            WindowsWGLGraphicsConfiguration config = (WindowsWGLGraphicsConfiguration) ns.getGraphicsConfiguration();

            if( !config.isExternal() ) {
                if( !config.isDetermined() ) {
                    updateGraphicsConfiguration(config, chooser, factory, hdc, false, pfdIDs);
                } else {
                    // set PFD if not set yet
                    int pfdID = -1;
                    boolean set = false;
                    if ( 1 > ( pfdID = WGLUtil.GetPixelFormat(hdc) ) ) {
                        if (!WGLUtil.SetPixelFormat(hdc, config.getPixelFormatID(), config.getPixelFormat())) {
                            throw new GLException("Unable to set pixel format " + config.getPixelFormatID() +
                                                  " for device context " + toHexString(hdc) +
                                                  ": error code " + GDI.GetLastError());
                        }
                        set = true;                        
                    }
                    if (DEBUG) {
                        System.err.println("setPixelFormat (post): hdc "+toHexString(hdc) +", "+pfdID+" -> "+config.getPixelFormatID()+", set: "+set);
                    }
                }
            }
        } finally {
            ns.unlockSurface();
        }
    }

    static void preselectGraphicsConfiguration(CapabilitiesChooser chooser,
                                               GLDrawableFactory _factory, AbstractGraphicsDevice device,
                                               WindowsWGLGraphicsConfiguration config, int[] pfdIDs) {
        if (chooser != null && !(chooser instanceof GLCapabilitiesChooser)) {
            throw new IllegalArgumentException("This NativeWindowFactory accepts only GLCapabilitiesChooser objects");
        }
        if (_factory == null) {
            throw new IllegalArgumentException("GLDrawableFactory is null");
        }
        if (config == null) {
            throw new IllegalArgumentException("WindowsWGLGraphicsConfiguration is null");
        }
        if ( !(_factory instanceof WindowsWGLDrawableFactory) ) {
            throw new GLException("GLDrawableFactory is not a WindowsWGLDrawableFactory, but: "+_factory.getClass().getSimpleName());
        }
        WindowsWGLDrawableFactory factory = (WindowsWGLDrawableFactory) _factory;
        WindowsWGLDrawable sharedDrawable = factory.getOrCreateSharedDrawable(device);
        if(null == sharedDrawable) {
            throw new IllegalArgumentException("Shared Drawable is null");
        }

        if(NativeSurface.LOCK_SURFACE_NOT_READY >= sharedDrawable.lockSurface()) {
            throw new GLException("Shared Surface not ready (lockSurface): "+device+" -> "+sharedDrawable);
        }
        try {
            long hdc = sharedDrawable.getHandle();
            if (0 == hdc) {
                throw new GLException("Error: HDC is null");
            }
            updateGraphicsConfiguration(config, chooser, factory, hdc, true, pfdIDs);
        } finally {
            sharedDrawable.unlockSurface();
        }
    }

    private static void updateGraphicsConfiguration(WindowsWGLGraphicsConfiguration config, CapabilitiesChooser chooser,
                                                    GLDrawableFactory factory, long hdc, boolean extHDC, int[] pfdIDs) {
        if (DEBUG) {
            if(extHDC) {
                System.err.println("updateGraphicsConfiguration(using shared): hdc "+toHexString(hdc));
            } else {
                System.err.println("updateGraphicsConfiguration(using target): hdc "+toHexString(hdc));
            }
            System.err.println("user chosen caps " + config.getChosenCapabilities());
        }
        AbstractGraphicsDevice device = config.getScreen().getDevice();
        WindowsWGLDrawableFactory.SharedResource sharedResource = ((WindowsWGLDrawableFactory)factory).getOrCreateSharedResource(device);
        GLContext sharedContext = null;
        if (null != sharedResource && sharedResource.needsCurrentContext4ARBPFDQueries()) {
            sharedContext = sharedResource.getContext();
            if(GLContext.CONTEXT_NOT_CURRENT == sharedContext.makeCurrent()) {
                throw new GLException("Could not make Shared Context current: "+device);
            }
        }
        try {
            if( !updateGraphicsConfigurationARB((WindowsWGLDrawableFactory)factory, config, chooser, hdc, extHDC, pfdIDs) ) {
                updateGraphicsConfigurationGDI(config, chooser, hdc, extHDC, pfdIDs);
            }
        } finally {
            if (null != sharedContext) {
                sharedContext.release();
            }
        }
    }

    private static boolean updateGraphicsConfigurationARB(WindowsWGLDrawableFactory factory, WindowsWGLGraphicsConfiguration config, CapabilitiesChooser chooser,
                                                          long hdc, boolean extHDC, int[] pformats) {
        final AbstractGraphicsDevice device = config.getScreen().getDevice();
        final WindowsWGLDrawableFactory.SharedResource sharedResource = factory.getOrCreateSharedResource(device);

        if (null == sharedResource) {
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationARB: SharedResource is null: "+device);
            }
            return false;
        }
        if (!sharedResource.hasARBPixelFormat()) {
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationARB: "+WindowsWGLDrawableFactory.WGL_ARB_pixel_format+" not available");
            }
            return false;
        }

        final GLCapabilitiesImmutable capsChosen = (GLCapabilitiesImmutable) config.getChosenCapabilities();
        final boolean isOpaque = capsChosen.isBackgroundOpaque() && GDI.DwmIsCompositionEnabled();
        final int winattrbits = GLGraphicsConfigurationUtil.getExclusiveWinAttributeBits(capsChosen);
        final GLProfile glProfile = capsChosen.getGLProfile();
        
        final int pfdIDCount = WindowsWGLGraphicsConfiguration.wglARBPFDIDCount((WindowsWGLContext)sharedResource.getContext(), hdc);
        
        if(DEBUG) {
            System.err.println("updateGraphicsConfigurationARB: hdc "+toHexString(hdc)+", pfdIDCount(hdc) "+pfdIDCount+", capsChosen "+capsChosen+", "+GLGraphicsConfigurationUtil.winAttributeBits2String(null, winattrbits).toString());
            System.err.println("isOpaque "+isOpaque+" (translucency requested: "+(!capsChosen.isBackgroundOpaque())+", compositioning enabled: "+GDI.DwmIsCompositionEnabled()+")");
        }

        if(0 >= pfdIDCount) {
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationARB: failed due to 0 pfdIDs for hdc "+toHexString(hdc)+" - hdc incompatible w/ ARB ext.");
            }
            return false;
        }
        
        WGLGLCapabilities pixelFormatCaps = null; // chosen or preset PFD ID's caps
        boolean pixelFormatSet = false; // indicates a preset PFD ID [caps]
        final int presetPFDID = extHDC ? -1 : WGLUtil.GetPixelFormat(hdc) ;
        if ( 1 <= presetPFDID ) {
            // Pixelformat already set by either
            //  - a previous preselectGraphicsConfiguration() call on the same HDC,
            //  - the graphics driver, copying the HDC's pixelformat to the new one,
            //  - or the Java2D/OpenGL pipeline's configuration
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationARB: Pixel format already chosen for HDC: " + toHexString(hdc)
                        + ", pixelformat " + presetPFDID);
            }
            pixelFormatSet = true;
            pixelFormatCaps = WindowsWGLGraphicsConfiguration.wglARBPFID2GLCapabilities(sharedResource, device, glProfile, hdc, presetPFDID, winattrbits);
            pixelFormatCaps = (WGLGLCapabilities) GLGraphicsConfigurationUtil.fixOpaqueGLCapabilities(pixelFormatCaps, isOpaque);
        } else {
            int recommendedIndex = -1; // recommended index

            if(null == pformats) {
                // No given PFD IDs
                //
                // 1st choice: get GLCapabilities based on users GLCapabilities setting recommendedIndex as preferred choice
                final IntBuffer iattributes = Buffers.newDirectIntBuffer(2*WindowsWGLGraphicsConfiguration.MAX_ATTRIBS);
                final FloatBuffer fattributes = Buffers.newDirectFloatBuffer(1);
                int accelerationMode = WGLExt.WGL_FULL_ACCELERATION_ARB;
                pformats = WindowsWGLGraphicsConfiguration.wglChoosePixelFormatARB(sharedResource, device, capsChosen,
                                                                                   hdc, iattributes, accelerationMode, fattributes);
                if (null == pformats) {
                    accelerationMode = WGLExt.WGL_GENERIC_ACCELERATION_ARB;
                    pformats = WindowsWGLGraphicsConfiguration.wglChoosePixelFormatARB(sharedResource, device, capsChosen,
                                                                                       hdc, iattributes, accelerationMode, fattributes);
                }
                if (null == pformats) {
                    accelerationMode = -1; // use what we are offered ..
                    pformats = WindowsWGLGraphicsConfiguration.wglChoosePixelFormatARB(sharedResource, device, capsChosen,
                                                                                       hdc, iattributes, accelerationMode, fattributes);
                }
                if (null != pformats) {
                    recommendedIndex = 0;
                } else {
                    if(DEBUG) {
                        System.err.println("updateGraphicsConfigurationARB: wglChoosePixelFormatARB failed with: "+capsChosen);
                    }
                    // 2nd choice: get all GLCapabilities available, no preferred recommendedIndex available
                    pformats = WindowsWGLGraphicsConfiguration.wglAllARBPFDIDs(pfdIDCount);
                    if (DEBUG) {
                        final int len = ( null != pformats ) ? pformats.length : 0;
                        System.err.println("updateGraphicsConfigurationARB: NumFormats (wglAllARBPFIDs) " + len);
                    }
                }
                if (null == pformats) {
                    if (DEBUG) {
                        System.err.println("updateGraphicsConfigurationARB: failed, return false");
                        Thread.dumpStack();
                    }
                    return false;
                }
            }

            List<GLCapabilitiesImmutable> availableCaps = 
                    WindowsWGLGraphicsConfiguration.wglARBPFIDs2GLCapabilities(sharedResource, device, glProfile, hdc, pformats, winattrbits);
            
            if( null == availableCaps || 0 == availableCaps.size() ) {
                if (DEBUG) {
                    System.err.println("updateGraphicsConfigurationARB: wglARBPFIDs2GLCapabilities failed with " + pformats.length + " pfd ids");
                    Thread.dumpStack();
                }
                return false;
            }

            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationARB: " + pformats.length +
                                   " pfd ids, " + GLGraphicsConfigurationUtil.winAttributeBits2String(null, winattrbits).toString() + ", " + availableCaps.size() + " glcaps");
                if(0 <= recommendedIndex) {
                    System.err.println("updateGraphicsConfigurationARB: Used wglChoosePixelFormatARB to recommend pixel format " +
                                       pformats[recommendedIndex] + ", idx " + recommendedIndex +", "+availableCaps.get(recommendedIndex));
                }
            }

            int chosenIndex = chooseCapabilities(chooser, capsChosen, availableCaps, recommendedIndex);
            if ( 0 > chosenIndex ) {
                if (DEBUG) {
                    Thread.dumpStack();
                }
                return false;
            }
            pixelFormatCaps = (WGLGLCapabilities) availableCaps.get(chosenIndex);
            if( null == pixelFormatCaps) {
                throw new GLException("Null Capabilities with "+
                                      " chosen pfdID: native recommended "+ (recommendedIndex+1) +
                                      " chosen idx "+chosenIndex);
            }
            pixelFormatCaps = (WGLGLCapabilities) GLGraphicsConfigurationUtil.fixOpaqueGLCapabilities(pixelFormatCaps, isOpaque);
            if (DEBUG) {
                System.err.println("chosen pfdID (ARB): native recommended "+ (recommendedIndex+1) +
                                   " chosen "+pixelFormatCaps);
            }
        }

        if ( !extHDC && !pixelFormatSet ) {
            config.setPixelFormat(hdc, pixelFormatCaps);
        } else {
            config.setCapsPFD(pixelFormatCaps);
        }
        return true;
    }

    private static boolean updateGraphicsConfigurationGDI(WindowsWGLGraphicsConfiguration config, CapabilitiesChooser chooser, long hdc,
                                                          boolean extHDC, int[] pformats) {
        GLCapabilitiesImmutable capsChosen = (GLCapabilitiesImmutable) config.getChosenCapabilities();
        if( !capsChosen.isOnscreen() && capsChosen.isPBuffer() ) {
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationGDI: no pbuffer supported on GDI: " + capsChosen);
            }
            return false;
        }
        // final boolean onscreen = capsChosen.isOnscreen();
        // final boolean useFBO = capsChosen.isFBO();
        final GLProfile glProfile = capsChosen.getGLProfile();
        final int winattrmask = GLGraphicsConfigurationUtil.getExclusiveWinAttributeBits(capsChosen);
        
        if(DEBUG) {
            System.err.println("updateGraphicsConfigurationGDI: capsChosen "+capsChosen+", "+GLGraphicsConfigurationUtil.winAttributeBits2String(null, winattrmask).toString());
        }
        
        AbstractGraphicsDevice device = config.getScreen().getDevice();
        int pfdID; // chosen or preset PFD ID
        WGLGLCapabilities pixelFormatCaps = null; // chosen or preset PFD ID's caps
        boolean pixelFormatSet = false; // indicates a preset PFD ID [caps]

        if ( !extHDC && 1 <= ( pfdID = WGLUtil.GetPixelFormat(hdc) ) ) {
            // Pixelformat already set by either
            //  - a previous preselectGraphicsConfiguration() call on the same HDC,
            //  - the graphics driver, copying the HDC's pixelformat to the new one,
            //  - or the Java2D/OpenGL pipeline's configuration
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationGDI: NOTE: pixel format already chosen for HDC: " + toHexString(hdc)
                        + ", pixelformat " + pfdID);
            }
            pixelFormatSet = true;
            pixelFormatCaps = WindowsWGLGraphicsConfiguration.PFD2GLCapabilities(device, glProfile, hdc, pfdID, winattrmask);
            if(null == pixelFormatCaps) {
                throw new GLException("Could not map PFD2GLCaps w/ already chosen pfdID "+pfdID);
            }
        } else {
            final boolean givenPFormats = null != pformats;
            if( !givenPFormats ) {
                pformats = WindowsWGLGraphicsConfiguration.wglAllGDIPFIDs(hdc);
            }

            List<GLCapabilitiesImmutable> availableCaps = new ArrayList<GLCapabilitiesImmutable>();
            for (int i = 0; i < pformats.length; i++) {
                final GLCapabilitiesImmutable caps = WindowsWGLGraphicsConfiguration.PFD2GLCapabilities(device, glProfile, hdc, pformats[i], winattrmask);
                if(null != caps) {
                    availableCaps.add(caps);
                    if(DEBUG) {
                        final int j = availableCaps.size() - 1; 
                        System.err.println("updateGraphicsConfigurationGDI: availableCaps["+i+" -> "+j+"]: "+caps);
                    }
                } else if(DEBUG) {
                    GLCapabilitiesImmutable skipped = WindowsWGLGraphicsConfiguration.PFD2GLCapabilitiesNoCheck(device, glProfile, hdc, pformats[i]);
                    System.err.println("updateGraphicsConfigurationGDI: availableCaps["+i+" -> skip]: pfdID "+pformats[i]+", "+skipped);
                }
            }

            // 1st choice: get GLCapabilities based on users GLCapabilities setting recommendedIndex as preferred choice
            PIXELFORMATDESCRIPTOR pfd = WindowsWGLGraphicsConfiguration.createPixelFormatDescriptor();
            pfd = WindowsWGLGraphicsConfiguration.GLCapabilities2PFD(capsChosen, pfd);
            pfdID = WGLUtil.ChoosePixelFormat(hdc, pfd);
            int recommendedIndex = -1 ;
            if( 1 <= pfdID ) {
                // seek index .. in all formats _or_ in given formats!
                for (recommendedIndex = availableCaps.size() - 1 ;
                     0 <= recommendedIndex && pfdID != ((WGLGLCapabilities) availableCaps.get(recommendedIndex)).getPFDID();
                     recommendedIndex--)
                { /* nop */ }
                if(DEBUG && 0 > recommendedIndex) {
                    final GLCapabilitiesImmutable reqPFDCaps = WindowsWGLGraphicsConfiguration.PFD2GLCapabilitiesNoCheck(device, glProfile, pfd, pfdID);
                    final GLCapabilitiesImmutable chosenCaps = WindowsWGLGraphicsConfiguration.PFD2GLCapabilities(device, glProfile, hdc, pfdID, winattrmask);
                    System.err.println("Chosen PFDID "+pfdID+", but not found in available caps (use given pfdIDs "+givenPFormats+", reqPFDCaps "+reqPFDCaps+", chosenCaps: "+chosenCaps);
                }
            }
            if (DEBUG) {
                System.err.println("updateGraphicsConfigurationGDI: ChoosePixelFormat(HDC " + toHexString(hdc) + ") = pfdID " + pfdID + ", idx " + recommendedIndex + " (LastError: " + GDI.GetLastError() + ")");
            }
            // 2nd choice: if no preferred recommendedIndex available
            int chosenIndex = chooseCapabilities(chooser, capsChosen, availableCaps, recommendedIndex);
            if ( 0 > chosenIndex ) {
                if (DEBUG) {
                    System.err.println("updateGraphicsConfigurationGDI: failed, return false");
                    Thread.dumpStack();
                }
                return false;
            }
            pixelFormatCaps = (WGLGLCapabilities) availableCaps.get(chosenIndex);
            if (DEBUG) {
                System.err.println("chosen pfdID (GDI): chosenIndex "+ chosenIndex + ", caps " + pixelFormatCaps);
            }
        }

        if ( !extHDC && !pixelFormatSet ) {
            config.setPixelFormat(hdc, pixelFormatCaps);
        } else {
            config.setCapsPFD(pixelFormatCaps);
        }
        return true;
    }
}

