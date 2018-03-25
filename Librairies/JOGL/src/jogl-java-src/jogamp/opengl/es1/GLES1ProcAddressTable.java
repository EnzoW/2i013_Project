/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/opengl/GLEmitter.java on Thu Nov 01 02:15:16 CET 2012 ----! */

package jogamp.opengl.es1;

import java.util.*;
import javax.media.opengl.*;
import javax.media.opengl.fixedfunc.*;
import jogamp.opengl.*;
import javax.media.opengl.GLES1;
import javax.media.opengl.GLES2;
import javax.media.opengl.GL2;
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.util.GLBuffers;
import com.jogamp.gluegen.runtime.ProcAddressTable;

/**
 * This table is a cache of pointers to the dynamically-linkable C library.
 * @see ProcAddressTable
 */
public class GLES1ProcAddressTable extends ProcAddressTable {

  public long _addressof_glMapBuffer;

  public GLES1ProcAddressTable(){ super(); }

  public GLES1ProcAddressTable(com.jogamp.gluegen.runtime.FunctionAddressResolver resolver){ super(resolver); }

  public long _addressof_glActiveTexture;
  public long _addressof_glAlphaFunc;
  public long _addressof_glAlphaFuncx;
  public long _addressof_glBindBuffer;
  public long _addressof_glBindFramebuffer;
  public long _addressof_glBindRenderbuffer;
  public long _addressof_glBindTexture;
  public long _addressof_glBindVertexArrayOES;
  public long _addressof_glBlendEquation;
  public long _addressof_glBlendEquationSeparate;
  public long _addressof_glBlendFunc;
  public long _addressof_glBlendFuncSeparate;
  public long _addressof_glBufferData;
  public long _addressof_glBufferSubData;
  public long _addressof_glCheckFramebufferStatus;
  public long _addressof_glClear;
  public long _addressof_glClearColor;
  public long _addressof_glClearColorx;
  public long _addressof_glClearDepthf;
  public long _addressof_glClearDepthx;
  public long _addressof_glClearStencil;
  public long _addressof_glClientActiveTexture;
  public long _addressof_glClipPlanef;
  public long _addressof_glClipPlanefIMG;
  public long _addressof_glClipPlanex;
  public long _addressof_glClipPlanexIMG;
  public long _addressof_glColor4f;
  public long _addressof_glColor4ub;
  public long _addressof_glColor4x;
  public long _addressof_glColorMask;
  public long _addressof_glColorPointer;
  public long _addressof_glCompressedTexImage2D;
  public long _addressof_glCompressedTexSubImage2D;
  public long _addressof_glCopyTexImage2D;
  public long _addressof_glCopyTexSubImage2D;
  public long _addressof_glCullFace;
  public long _addressof_glCurrentPaletteMatrix;
  public long _addressof_glDeleteBuffers;
  public long _addressof_glDeleteFencesNV;
  public long _addressof_glDeleteFramebuffers;
  public long _addressof_glDeleteRenderbuffers;
  public long _addressof_glDeleteTextures;
  public long _addressof_glDeleteVertexArraysOES;
  public long _addressof_glDepthFunc;
  public long _addressof_glDepthMask;
  public long _addressof_glDepthRangef;
  public long _addressof_glDepthRangex;
  public long _addressof_glDisable;
  public long _addressof_glDisableClientState;
  public long _addressof_glDisableDriverControlQCOM;
  public long _addressof_glDiscardFramebufferEXT;
  public long _addressof_glDrawArrays;
  public long _addressof_glDrawElements;
  public long _addressof_glDrawTexfOES;
  public long _addressof_glDrawTexfvOES;
  public long _addressof_glDrawTexiOES;
  public long _addressof_glDrawTexivOES;
  public long _addressof_glDrawTexsOES;
  public long _addressof_glDrawTexsvOES;
  public long _addressof_glDrawTexxOES;
  public long _addressof_glDrawTexxvOES;
  public long _addressof_glEGLImageTargetRenderbufferStorageOES;
  public long _addressof_glEGLImageTargetTexture2DOES;
  public long _addressof_glEnable;
  public long _addressof_glEnableClientState;
  public long _addressof_glEnableDriverControlQCOM;
  public long _addressof_glEndTilingQCOM;
  public long _addressof_glExtGetBufferPointervQCOM;
  public long _addressof_glExtGetBuffersQCOM;
  public long _addressof_glExtGetFramebuffersQCOM;
  public long _addressof_glExtGetProgramBinarySourceQCOM;
  public long _addressof_glExtGetProgramsQCOM;
  public long _addressof_glExtGetRenderbuffersQCOM;
  public long _addressof_glExtGetShadersQCOM;
  public long _addressof_glExtGetTexLevelParameterivQCOM;
  public long _addressof_glExtGetTexSubImageQCOM;
  public long _addressof_glExtGetTexturesQCOM;
  public long _addressof_glExtIsProgramBinaryQCOM;
  public long _addressof_glExtTexObjectStateOverrideiQCOM;
  public long _addressof_glFinish;
  public long _addressof_glFinishFenceNV;
  public long _addressof_glFlush;
  public long _addressof_glFogf;
  public long _addressof_glFogfv;
  public long _addressof_glFogx;
  public long _addressof_glFogxv;
  public long _addressof_glFramebufferRenderbuffer;
  public long _addressof_glFramebufferTexture2DMultisampleEXT;
  public long _addressof_glFramebufferTexture2DMultisampleIMG;
  public long _addressof_glFramebufferTexture2D;
  public long _addressof_glFrontFace;
  public long _addressof_glFrustumf;
  public long _addressof_glFrustumx;
  public long _addressof_glGenBuffers;
  public long _addressof_glGenFencesNV;
  public long _addressof_glGenFramebuffers;
  public long _addressof_glGenRenderbuffers;
  public long _addressof_glGenTextures;
  public long _addressof_glGenVertexArraysOES;
  public long _addressof_glGenerateMipmap;
  public long _addressof_glGetBooleanv;
  public long _addressof_glGetBufferParameteriv;
  public long _addressof_glGetClipPlanef;
  public long _addressof_glGetClipPlanex;
  public long _addressof_glGetDriverControlStringQCOM;
  public long _addressof_glGetDriverControlsQCOM;
  public long _addressof_glGetError;
  public long _addressof_glGetFenceivNV;
  public long _addressof_glGetFixedv;
  public long _addressof_glGetFloatv;
  public long _addressof_glGetFramebufferAttachmentParameteriv;
  public long _addressof_glGetGraphicsResetStatus;
  public long _addressof_glGetIntegerv;
  public long _addressof_glGetLightfv;
  public long _addressof_glGetLightxv;
  public long _addressof_glGetMaterialfv;
  public long _addressof_glGetMaterialxv;
  public long _addressof_glGetRenderbufferParameteriv;
  public long _addressof_glGetString;
  public long _addressof_glGetTexEnvfv;
  public long _addressof_glGetTexEnviv;
  public long _addressof_glGetTexEnvxv;
  public long _addressof_glGetTexGenfv;
  public long _addressof_glGetTexGeniv;
  public long _addressof_glGetTexGenxv;
  public long _addressof_glGetTexParameterfv;
  public long _addressof_glGetTexParameteriv;
  public long _addressof_glGetTexParameterxv;
  public long _addressof_glGetnUniformfv;
  public long _addressof_glGetnUniformiv;
  public long _addressof_glHint;
  public long _addressof_glIsBuffer;
  public long _addressof_glIsEnabled;
  public long _addressof_glIsFenceNV;
  public long _addressof_glIsFramebuffer;
  public long _addressof_glIsRenderbuffer;
  public long _addressof_glIsTexture;
  public long _addressof_glIsVertexArrayOES;
  public long _addressof_glLightModelf;
  public long _addressof_glLightModelfv;
  public long _addressof_glLightModelx;
  public long _addressof_glLightModelxv;
  public long _addressof_glLightf;
  public long _addressof_glLightfv;
  public long _addressof_glLightx;
  public long _addressof_glLightxv;
  public long _addressof_glLineWidth;
  public long _addressof_glLineWidthx;
  public long _addressof_glLoadIdentity;
  public long _addressof_glLoadMatrixf;
  public long _addressof_glLoadMatrixx;
  public long _addressof_glLoadPaletteFromModelViewMatrixOES;
  public long _addressof_glLogicOp;
  public long _addressof_glMaterialf;
  public long _addressof_glMaterialfv;
  public long _addressof_glMaterialx;
  public long _addressof_glMaterialxv;
  public long _addressof_glMatrixIndexPointer;
  public long _addressof_glMatrixMode;
  public long _addressof_glMultMatrixf;
  public long _addressof_glMultMatrixx;
  public long _addressof_glMultiTexCoord4f;
  public long _addressof_glMultiTexCoord4x;
  public long _addressof_glNormal3f;
  public long _addressof_glNormal3x;
  public long _addressof_glNormalPointer;
  public long _addressof_glOrthof;
  public long _addressof_glOrthox;
  public long _addressof_glPixelStorei;
  public long _addressof_glPointParameterf;
  public long _addressof_glPointParameterfv;
  public long _addressof_glPointParameterx;
  public long _addressof_glPointParameterxv;
  public long _addressof_glPointSize;
  public long _addressof_glPointSizePointerOES;
  public long _addressof_glPointSizex;
  public long _addressof_glPolygonOffset;
  public long _addressof_glPolygonOffsetx;
  public long _addressof_glPopMatrix;
  public long _addressof_glPushMatrix;
  public long _addressof_glQueryMatrixxOES;
  public long _addressof_glReadPixels;
  public long _addressof_glReadnPixels;
  public long _addressof_glRenderbufferStorageMultisampleAPPLE;
  public long _addressof_glRenderbufferStorageMultisampleIMG;
  public long _addressof_glRenderbufferStorage;
  public long _addressof_glResolveMultisampleFramebufferAPPLE;
  public long _addressof_glRotatef;
  public long _addressof_glRotatex;
  public long _addressof_glSampleCoverage;
  public long _addressof_glSampleCoveragex;
  public long _addressof_glScalef;
  public long _addressof_glScalex;
  public long _addressof_glScissor;
  public long _addressof_glSetFenceNV;
  public long _addressof_glShadeModel;
  public long _addressof_glStartTilingQCOM;
  public long _addressof_glStencilFunc;
  public long _addressof_glStencilMask;
  public long _addressof_glStencilOp;
  public long _addressof_glTestFenceNV;
  public long _addressof_glTexCoordPointer;
  public long _addressof_glTexEnvf;
  public long _addressof_glTexEnvfv;
  public long _addressof_glTexEnvi;
  public long _addressof_glTexEnviv;
  public long _addressof_glTexEnvx;
  public long _addressof_glTexEnvxv;
  public long _addressof_glTexGenf;
  public long _addressof_glTexGenfv;
  public long _addressof_glTexGeni;
  public long _addressof_glTexGeniv;
  public long _addressof_glTexGenx;
  public long _addressof_glTexGenxv;
  public long _addressof_glTexImage2D;
  public long _addressof_glTexParameterf;
  public long _addressof_glTexParameterfv;
  public long _addressof_glTexParameteri;
  public long _addressof_glTexParameteriv;
  public long _addressof_glTexParameterx;
  public long _addressof_glTexParameterxv;
  public long _addressof_glTexStorage1D;
  public long _addressof_glTexStorage2D;
  public long _addressof_glTexStorage3D;
  public long _addressof_glTexSubImage2D;
  public long _addressof_glTextureStorage1DEXT;
  public long _addressof_glTextureStorage2DEXT;
  public long _addressof_glTextureStorage3DEXT;
  public long _addressof_glTranslatef;
  public long _addressof_glTranslatex;
  public long _addressof_glUnmapBuffer;
  public long _addressof_glVertexPointer;
  public long _addressof_glViewport;
  public long _addressof_glWeightPointer;
  /**
   * This is a convenience method to get (by name) the native function
   * pointer for a given function. It lets you avoid having to
   * manually compute the &quot;_addressof_ + 
   * &lt;functionName&gt;&quot; member variable name and look it up via
   * reflection; it also will throw an exception if you try to get the
   * address of an unknown function, or one that is statically linked
   * and therefore does not have a function pointer in this table.
   *
   * @throws RuntimeException if the function pointer was not found in
   *   this table, either because the function was unknown or because
   *   it was statically linked.
   */
  public long getAddressFor(String functionNameUsr) {
    String functionNameBase = com.jogamp.gluegen.runtime.opengl.GLNameResolver.normalizeVEN(com.jogamp.gluegen.runtime.opengl.GLNameResolver.normalizeARB(functionNameUsr, true), true);
    String addressFieldNameBase = PROCADDRESS_VAR_PREFIX + functionNameBase;
    java.lang.reflect.Field addressField = null;
    int  funcNamePermNum = com.jogamp.gluegen.runtime.opengl.GLNameResolver.getFuncNamePermutationNumber(functionNameBase);
    for(int i = 0; null==addressField && i < funcNamePermNum; i++) {
        String addressFieldName = com.jogamp.gluegen.runtime.opengl.GLNameResolver.getFuncNamePermutation(addressFieldNameBase, i);
        try {
          addressField = getClass().getField(addressFieldName);
        } catch (Exception e) { }
    }

    if(null==addressField) {
      // The user is calling a bogus function or one which is not
      // runtime linked
      throw new RuntimeException(
          "WARNING: Address field query failed for \"" + functionNameBase + "\"/\"" + functionNameUsr +
          "\"; it's either statically linked or address field is not a known " +
          "function");
    } 
    try {
      return addressField.getLong(this);
    } catch (Exception e) {
      throw new RuntimeException(
          "WARNING: Address query failed for \"" + functionNameBase + "\"/\"" + functionNameUsr +
          "\"; it's either statically linked or is not a known " +
          "function", e);
    }
  }
} // end of class GLES1ProcAddressTable
