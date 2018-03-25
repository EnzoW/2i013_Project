/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Thu Nov 01 02:13:14 CET 2012 ----! */

package jogamp.nativewindow.jawt;

import java.security.*;
import jogamp.nativewindow.jawt.*;
import com.jogamp.common.os.Platform;
import com.jogamp.common.util.VersionNumber;
import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import java.nio.*;

public class JAWTFactory {

  public static final int JNI_FALSE = 0;
  public static final int JNI_TRUE = 1;
  public static final int JNI_OK = 0;
  public static final int JNI_ERR = (-1);
  public static final int JNI_EDETACHED = (-2);
  public static final int JNI_EVERSION = (-3);
  public static final int JNI_ENOMEM = (-4);
  public static final int JNI_EEXIST = (-5);
  public static final int JNI_EINVAL = (-6);
  public static final int JNI_COMMIT = 1;
  public static final int JNI_ABORT = 2;
  public static final int JAWT_LOCK_ERROR = 0x00000001;
  public static final int JAWT_LOCK_CLIP_CHANGED = 0x00000002;
  public static final int JAWT_LOCK_BOUNDS_CHANGED = 0x00000004;
  public static final int JAWT_LOCK_SURFACE_CHANGED = 0x00000008;
  public static final int JAWT_VERSION_1_3 = 0x00010003;
  public static final int JAWT_VERSION_1_4 = 0x00010004;

  /** Interface to C language function: <br> <code> jboolean JAWT_GetAWT(JNIEnv *  env, JAWT *  awt); </code>    */
  public static boolean JAWT_GetAWT(JAWT awt)  {

        return JAWT_GetAWT1(((awt == null) ? null : awt.getBuffer()));
  }

  /** Entry point to C language function: <code> jboolean JAWT_GetAWT(JNIEnv *  env, JAWT *  awt); </code>    */
  private static native boolean JAWT_GetAWT1(ByteBuffer awt);


} // end of class JAWTFactory
