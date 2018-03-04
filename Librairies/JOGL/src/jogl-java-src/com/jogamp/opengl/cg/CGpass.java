/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/procaddress/ProcAddressEmitter.java on Thu Nov 01 02:16:28 CET 2012 ----! */


package com.jogamp.opengl.cg;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDescriptionRuntime;

import jogamp.opengl.*;
import com.jogamp.common.os.DynamicLookupHelper;
import com.jogamp.common.os.DynamicLibraryBundle;
import com.jogamp.opengl.cg.CgDynamicLibraryBundleInfo;

public class CGpass {

  StructAccessor accessor;

  private static final int mdIdx = MachineDescriptionRuntime.getStatic().ordinal();

  private static final int[] CGpass_size = new int[] { 0 /* ARMle_EABI */, 0 /* X86_32_UNIX */, 0 /* X86_64_UNIX */, 0 /* X86_32_MACOS */, 0 /* X86_32_WINDOWS */, 0 /* X86_64_WINDOWS */  };

  public static int size() {
    return CGpass_size[mdIdx];
  }

  public static CGpass create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static CGpass create(java.nio.ByteBuffer buf) {
      return new CGpass(buf);
  }

  CGpass(java.nio.ByteBuffer buf) {
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }
}
