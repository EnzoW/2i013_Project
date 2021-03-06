/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Thu Nov 01 02:13:14 CET 2012 ----! */


package jogamp.nativewindow.jawt.macosx;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import java.security.*;
import jogamp.nativewindow.jawt.*;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;

public class JAWT_MacOSXDrawingSurfaceInfo implements JAWT_PlatformInfo {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] JAWT_MacOSXDrawingSurfaceInfo_size = new int[] { 4 /* ARMle_EABI */, 4 /* X86_32_UNIX */, 8 /* X86_64_UNIX */, 4 /* X86_32_MACOS */, 4 /* X86_32_WINDOWS */, 8 /* X86_64_WINDOWS */  };
  private static final int[] cocoaViewRef_offset = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */ };

  public static int size() {
    return JAWT_MacOSXDrawingSurfaceInfo_size[mdIdx];
  }

  public static JAWT_MacOSXDrawingSurfaceInfo create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static JAWT_MacOSXDrawingSurfaceInfo create(java.nio.ByteBuffer buf) {
      return new JAWT_MacOSXDrawingSurfaceInfo(buf);
  }

  JAWT_MacOSXDrawingSurfaceInfo(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  public JAWT_MacOSXDrawingSurfaceInfo setCocoaViewRef(long val) {
    accessor.setLongAt(cocoaViewRef_offset[mdIdx], val, MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
    return this;
  }

  public long getCocoaViewRef() {
    return accessor.getLongAt(cocoaViewRef_offset[mdIdx], MachineDescriptionRuntime.getStatic().md.pointerSizeInBytes());
  }
}
