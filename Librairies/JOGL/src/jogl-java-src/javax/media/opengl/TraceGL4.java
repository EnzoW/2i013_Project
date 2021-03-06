package javax.media.opengl;

import java.io.*;
import javax.media.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import javax.media.opengl.GL4;
import javax.media.opengl.GL3;

/** <P> Composable pipeline which wraps an underlying {@link GL} implementation,
    providing tracing information to a user-specified {@link java.io.PrintStream}
    before and after each OpenGL method call. Sample code which installs this pipeline: </P>

<PRE>
     GL gl = drawable.setGL(new TraceGL(drawable.getGL(), System.err));
</PRE>
*/
public class TraceGL4 implements javax.media.opengl.GL3, javax.media.opengl.GL4{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("TraceGL4");
  public TraceGL4(GL4 downstreamGL4, PrintStream stream)
  {
    if (downstreamGL4 == null) {
      throw new IllegalArgumentException("null downstreamGL4");
    }
    this.downstreamGL4 = downstreamGL4;
    this.stream = stream;
  }

  public boolean isGL() {
    return true;
  }
  public boolean isGL4bc() {
    return false;
  }
  public boolean isGL4() {
    return true;
  }
  public boolean isGL3bc() {
    return false;
  }
  public boolean isGL3() {
    return true;
  }
  public boolean isGL2() {
    return false;
  }
  public boolean isGLES1() {
    return false;
  }
  public boolean isGLES2() {
    return false;
  }
  public boolean isGL2ES1() {
    return false;
  }
  public boolean isGL2ES2() {
    return true;
  }
  public boolean isGL2GL3() {
    return true;
  }
  public boolean isGLES() {
    return isGLES2() || isGLES1();
  }
  public boolean isGLES2Compatible() {
    return downstreamGL4.isGLES2Compatible();
  }
  public javax.media.opengl.GL getGL() {
    return this;
  }
  public javax.media.opengl.GL4bc getGL4bc() {
    throw new GLException("Not a GL4bc implementation");
  }
  public javax.media.opengl.GL4 getGL4() {
    return this;
  }
  public javax.media.opengl.GL3bc getGL3bc() {
    throw new GLException("Not a GL3bc implementation");
  }
  public javax.media.opengl.GL3 getGL3() {
    return this;
  }
  public javax.media.opengl.GL2 getGL2() {
    throw new GLException("Not a GL2 implementation");
  }
  public javax.media.opengl.GLES1 getGLES1() {
    throw new GLException("Not a GLES1 implementation");
  }
  public javax.media.opengl.GLES2 getGLES2() {
    throw new GLException("Not a GLES2 implementation");
  }
  public javax.media.opengl.GL2ES1 getGL2ES1() {
    throw new GLException("Not a GL2ES1 implementation");
  }
  public javax.media.opengl.GL2ES2 getGL2ES2() {
    return this;
  }
  public javax.media.opengl.GL2GL3 getGL2GL3() {
    return this;
  }
  public GLProfile getGLProfile() {
    return downstreamGL4.getGLProfile();
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnMinmax(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnMinmax("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL4.glGetnMinmax(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glMultiTexCoordP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawElementsIndirect(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glDrawElementsIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL4.glDrawElementsIndirect(arg0,arg1,arg2);
    println("");
  }
  public  void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSecondaryColorFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColorFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glSecondaryColorFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glShaderSource(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    printIndent();
    print(    "glColorMask("+"<boolean> "+arg0+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+")");
downstreamGL4.glColorMask(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDebugMessageInsertAMD(int arg0,int arg1,int arg2,int arg3,java.lang.String arg4)
  {
    printIndent();
    print(    "glDebugMessageInsertAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.lang.String> "+arg4+")");
downstreamGL4.glDebugMessageInsertAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetIntegeri_v(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetIntegeri_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetDoublev(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetDoublev("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetDoublev(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI2i(arg0,arg1,arg2);
    println("");
  }
  public  void glGenQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenQueries(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nbv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nbv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Nbv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribL2dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribL2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnCompressedTexImage(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetnCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL4.glGetnCompressedTexImage(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glUniform1ui(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.ByteBuffer> "+arg5+")");
downstreamGL4.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformSubroutineuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformSubroutineuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenSamplers(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glProgramUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glUniform2fv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiDrawArraysIndirectAMD(int arg0,java.nio.Buffer arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiDrawArraysIndirectAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiDrawArraysIndirectAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL4.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glStencilOp(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glStencilOp(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttribL3dv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glProgramUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL4.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteFramebuffers(arg0,arg1);
    println("");
  }
  public  boolean glIsSync(long arg0)
  {
    printIndent();
    print(    "glIsSync("+"<long> "+arg0+")");
    boolean _res = downstreamGL4.glIsSync(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetActiveAtomicCounterBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformui64NV(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glProgramUniformui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL4.glProgramUniformui64NV(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glMultiTexCoordP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glProgramUniform2ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  boolean hasGLSL()
  {
        return downstreamGL4.hasGLSL();
  }
  public  void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTextureStorage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glReleaseShaderCompiler()
  {
    printIndent();
    print(    "glReleaseShaderCompiler("+")");
downstreamGL4.glReleaseShaderCompiler();
    println("");
  }
  public  void glUniform2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glUniform2i(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL4.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL4.glUniform2f(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glUniform2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL4.glUniform2d(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoordP1uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glTexCoordP1uiv(arg0,arg1);
    println("");
  }
  public  void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
downstreamGL4.glColorMaski(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4ubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4ubv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoordP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glTexCoordP2uiv(arg0,arg1);
    println("");
  }
  public  void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
downstreamGL4.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform4d(int arg0,int arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glProgramUniform4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
downstreamGL4.glProgramUniform4d(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform3iv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribLPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL4.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexP4ui(arg0,arg1);
    println("");
  }
  public  void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glBlendFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI2iv(arg0,arg1,arg2);
    println("");
  }
  public  void glTransformFeedbackVaryings(int arg0,int arg1,java.lang.String[] arg2,int arg3)
  {
    printIndent();
    print(    "glTransformFeedbackVaryings("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL4.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glViewportArrayv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glViewportArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glViewportArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glVertexAttribP4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetUniformBlockIndex(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformBlockIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL4.glGetUniformBlockIndex(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4sv(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsVBOArrayEnabled()
  {
    printIndent();
    print(    "glIsVBOArrayEnabled("+")");
    boolean _res = downstreamGL4.glIsVBOArrayEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glDisablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glDisablei(arg0,arg1);
    println("");
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetnPixelMapuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPolygonStipple(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetnPolygonStipple("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glGetnPolygonStipple(arg0,arg1);
    println("");
  }
  public  void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
downstreamGL4.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glShaderBinary(int arg0,int[] arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glShaderBinary(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glUniform4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL4.glUniform4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPointSize(float arg0)
  {
    printIndent();
    print(    "glPointSize("+"<float> "+arg0+")");
downstreamGL4.glPointSize(arg0);
    println("");
  }
  public  java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glMapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL4.glMapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetNamedBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glClearBufferuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glBlendColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL4.glBlendColor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindFragDataLocationIndexed(int arg0,int arg1,int arg2,java.lang.String arg3)
  {
    printIndent();
    print(    "glBindFragDataLocationIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.lang.String> "+arg3+")");
downstreamGL4.glBindFragDataLocationIndexed(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2d(int arg0,int arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glProgramUniform2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL4.glProgramUniform2d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetQueryObjectui64v(arg0,arg1,arg2);
    println("");
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,boolean arg5)
  {
    printIndent();
    print(    "glDebugMessageControlARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<boolean> "+arg5+")");
downstreamGL4.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glSampleMaski(int arg0,int arg1)
  {
    printIndent();
    print(    "glSampleMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glSampleMaski(arg0,arg1);
    println("");
  }
  public  void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertexBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL4.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glProgramUniform2i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetProgramiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glProgramUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL4.glProgramUniform2f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL4.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetUniformiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,int[] arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glDebugMessageEnableAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
downstreamGL4.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  public  long glImportSyncEXT(int arg0,long arg1,int arg2)
  {
    printIndent();
    print(    "glImportSyncEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    long _res = downstreamGL4.glImportSyncEXT(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glGetCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL4.glGetCompressedTexImage(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib2sv(arg0,arg1,arg2);
    println("");
  }
  public  void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI1uiv(arg0,arg1);
    println("");
  }
  public  void glGetnColorTable(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetnColorTable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glGetnColorTable(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexCoordP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexCoordP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTexStorage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glHint(int arg0,int arg1)
  {
    printIndent();
    print(    "glHint("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glHint(arg0,arg1);
    println("");
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsBuffer(int arg0)
  {
    printIndent();
    print(    "glIsBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTextureStorage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMakeNamedBufferResidentNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glMakeNamedBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glMakeNamedBufferResidentNV(arg0,arg1);
    println("");
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL4.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glDeleteSync(long arg0)
  {
    printIndent();
    print(    "glDeleteSync("+"<long> "+arg0+")");
downstreamGL4.glDeleteSync(arg0);
    println("");
  }
  public  void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glScissorIndexed(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glScissorIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glScissorIndexed(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRenderbufferStorage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsSampler(int arg0)
  {
    printIndent();
    print(    "glIsSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsSampler(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glScissorIndexedv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glScissorIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glScissorIndexedv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nusv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Nusv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTexImage3DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL4.glTexImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glEndQueryIndexed(int arg0,int arg1)
  {
    printIndent();
    print(    "glEndQueryIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glEndQueryIndexed(arg0,arg1);
    println("");
  }
  public  void glGetInteger64v(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetInteger64v(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetnUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glUniform4fv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTexStorage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTexStorage1D(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP4ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribP4ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glViewportIndexedfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glViewportIndexedfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glViewportIndexedfv(arg0,arg1);
    println("");
  }
  public  void glDrawArrays(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDrawArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetMultisamplefv(arg0,arg1,arg2);
    println("");
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glDepthRangeArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glDepthRangeArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformui64NV(int arg0,long arg1)
  {
    printIndent();
    print(    "glUniformui64NV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
downstreamGL4.glUniformui64NV(arg0,arg1);
    println("");
  }
  public  void glVertexP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexP4uiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform2dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPointParameteriv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glPointParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glPointParameteriv(arg0,arg1);
    println("");
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib2fv(arg0,arg1);
    println("");
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegerui64i_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetIntegerui64i_vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glUniform2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glDisableClientState(int arg0)
  {
    printIndent();
    print(    "glDisableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDisableClientState(arg0);
    println("");
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib3sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib3sv(arg0,arg1);
    println("");
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL4.glGetShaderInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenFramebuffers(arg0,arg1);
    println("");
  }
  public  void glMultiDrawElements(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5)
  {
    printIndent();
    print(    "glMultiDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glBeginConditionalRender(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginConditionalRender("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBeginConditionalRender(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib2dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL4.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  java.nio.ByteBuffer glAllocateMemoryNV(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glAllocateMemoryNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    java.nio.ByteBuffer _res = downstreamGL4.glAllocateMemoryNV(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glPatchParameteri(int arg0,int arg1)
  {
    printIndent();
    print(    "glPatchParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glPatchParameteri(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4Nubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Nubv(arg0,arg1);
    println("");
  }
  public  boolean glIsQuery(int arg0)
  {
    printIndent();
    print(    "glIsQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsQuery(arg0);
    println(" = "+_res);
    return _res;
  }
  public  boolean glIsTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glIsTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsTransformFeedback(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib3s(int arg0,short arg1,short arg2,short arg3)
  {
    printIndent();
    print(    "glVertexAttrib3s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+")");
downstreamGL4.glVertexAttrib3s(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4iv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glColorP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilOpSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glStencilOpSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL4.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glClearBufferiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nsv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nsv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Nsv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI4sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4sv(arg0,arg1);
    println("");
  }
  public  void glUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform1iv(arg0,arg1,arg2);
    println("");
  }
  public  int glCheckFramebufferStatus(int arg0)
  {
    printIndent();
    print(    "glCheckFramebufferStatus("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL4.glCheckFramebufferStatus(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL4.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDrawElementsInstanced(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexP2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDeleteSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteSamplers(arg0,arg1);
    println("");
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.IntBuffer arg6,java.nio.ByteBuffer arg7)
  {
    printIndent();
    print(    "glGetDebugMessageLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.IntBuffer> "+arg6+", "+"<java.nio.ByteBuffer> "+arg7+")");
    int _res = downstreamGL4.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
downstreamGL4.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glVertexAttrib1s(int arg0,short arg1)
  {
    printIndent();
    print(    "glVertexAttrib1s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+")");
downstreamGL4.glVertexAttrib1s(arg0,arg1);
    println("");
  }
  public  void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenTextures(arg0,arg1,arg2);
    println("");
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL4.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVertexAttrib4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4dv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glUniformui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glFrontFace(int arg0)
  {
    printIndent();
    print(    "glFrontFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glFrontFace(arg0);
    println("");
  }
  public  void glTexCoordFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexCoordFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteTransformFeedbacks(arg0,arg1);
    println("");
  }
  public  void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glTextureStorage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glScissorArrayv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glScissorArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glScissorArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColorP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glColorP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glColorP3ui(arg0,arg1);
    println("");
  }
  public  void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL4.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glUniform3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTextureARB(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTextureARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glFramebufferTextureARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4fv(arg0,arg1);
    println("");
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL4.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glActiveTexture(int arg0)
  {
    printIndent();
    print(    "glActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glActiveTexture(arg0);
    println("");
  }
  public  void glDebugMessageControlARB(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glDebugMessageControlARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL4.glDebugMessageControlARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexP3uiv(arg0,arg1);
    println("");
  }
  public  void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetProgramiv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPatchParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glPatchParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glPatchParameterfv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib3dv(arg0,arg1);
    println("");
  }
  public  void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glClearColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL4.glClearColor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsFramebuffer(int arg0)
  {
    printIndent();
    print(    "glIsFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsFramebuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glFlushMappedBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
downstreamGL4.glFlushMappedBufferRange(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDepthRangef(float arg0,float arg1)
  {
    printIndent();
    print(    "glDepthRangef("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL4.glDepthRangef(arg0,arg1);
    println("");
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glCompressedTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL4.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetDebugMessageLogAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
    int _res = downstreamGL4.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println(" = "+_res);
    return _res;
  }
  public  void glUniform1dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glUniform1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetShaderSource(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL4.glGetShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribLdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribLdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glBlitFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
downstreamGL4.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glVertexAttribI2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glBindFragDataLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glBindFragDataLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
downstreamGL4.glBindFragDataLocation(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP2ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribP2ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glSetMultisamplefvAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glSetMultisamplefvAMD(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexCoordP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glTexCoordP4ui(arg0,arg1);
    println("");
  }
  public  void glSecondaryColorP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glSecondaryColorP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glSecondaryColorP3ui(arg0,arg1);
    println("");
  }
  public  void glGetnTexImage(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL4.glGetnTexImage(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDebugMessageEnableAMD(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,boolean arg4)
  {
    printIndent();
    print(    "glDebugMessageEnableAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<boolean> "+arg4+")");
downstreamGL4.glDebugMessageEnableAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib1dv(arg0,arg1);
    println("");
  }
  public  void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteRenderbuffers(arg0,arg1);
    println("");
  }
  public  void glTexCoordP1uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexCoordP1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendEquation(int arg0)
  {
    printIndent();
    print(    "glBlendEquation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glBlendEquation(arg0);
    println("");
  }
  public  void glVertexAttrib4bv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4bv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveSubroutineUniformiv(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetActiveSubroutineUniformiv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDepthRange(double arg0,double arg1)
  {
    printIndent();
    print(    "glDepthRange("+"<double> "+arg0+", "+"<double> "+arg1+")");
downstreamGL4.glDepthRange(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexAttribI1ui(arg0,arg1);
    println("");
  }
  public  void glMultiTexCoordP2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP2ui(arg0,arg1,arg2);
    println("");
  }
  public  void glDepthRangeIndexed(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glDepthRangeIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL4.glDepthRangeIndexed(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4s(int arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glVertexAttrib4s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
downstreamGL4.glVertexAttrib4s(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void setSwapInterval(int arg0)
  {
    downstreamGL4.setSwapInterval(arg0);
  }
  public  void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glTexImage2DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
downstreamGL4.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib1sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib1sv(arg0,arg1);
    println("");
  }
  public  void glTexCoordP2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexCoordP2uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glVertexAttrib4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL4.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetIntegerui64vNV(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetIntegerui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,java.nio.ShortBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg2+")");
downstreamGL4.glGetnPixelMapusv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glVertexAttrib4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL4.glVertexAttrib4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  java.lang.String glGetStringi(int arg0,int arg1)
  {
    printIndent();
    print(    "glGetStringi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.lang.String _res = downstreamGL4.glGetStringi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI2iv(arg0,arg1);
    println("");
  }
  public  void glNormalP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glNormalP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glNormalP3ui(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI3uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP4uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribP4uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnPixelMapuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetnPixelMapuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTextureImage3DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTextureImage3DMultisampleNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL4.glTextureImage3DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glGetnUniformdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearBufferuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glClearBufferuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glShaderBinary(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glShaderBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenSamplers(arg0,arg1);
    println("");
  }
  public  void glGetUniformfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4bv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4bv(arg0,arg1,arg2);
    println("");
  }
  public  void glBufferAddressRangeNV(int arg0,int arg1,long arg2,long arg3)
  {
    printIndent();
    print(    "glBufferAddressRangeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+")");
downstreamGL4.glBufferAddressRangeNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiDrawArrays(int arg0,int[] arg1,int arg2,int[] arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glMultiDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glMultiDrawArrays(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiDrawArrays(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2,int arg3)
  {
    printIndent();
    print(    "glMultiDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiDrawArrays(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,java.nio.LongBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg3+")");
downstreamGL4.glProgramUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int getDefaultReadFramebuffer()
  {
        return downstreamGL4.getDefaultReadFramebuffer();
  }
  public  void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glReadBuffer(int arg0)
  {
    printIndent();
    print(    "glReadBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glReadBuffer(arg0);
    println("");
  }
  public  void glSampleCoverage(float arg0,boolean arg1)
  {
    printIndent();
    print(    "glSampleCoverage("+"<float> "+arg0+", "+"<boolean> "+arg1+")");
downstreamGL4.glSampleCoverage(arg0,arg1);
    println("");
  }
  public  void glGetActiveAtomicCounterBufferiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetActiveAtomicCounterBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetActiveAtomicCounterBufferiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteFramebuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoordP3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4ubv(arg0,arg1);
    println("");
  }
  public  boolean isTextureFormatBGRA8888Available()
  {
        return downstreamGL4.isTextureFormatBGRA8888Available();
  }
  public  void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glFlush()
  {
    printIndent();
    print(    "glFlush("+")");
downstreamGL4.glFlush();
    println("");
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetInteger64i_v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetInteger64i_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glValidateProgram(int arg0)
  {
    printIndent();
    print(    "glValidateProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glValidateProgram(arg0);
    println("");
  }
  public  void glMultiTexCoordP2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEndTransformFeedback()
  {
    printIndent();
    print(    "glEndTransformFeedback("+")");
downstreamGL4.glEndTransformFeedback();
    println("");
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetProgramInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDrawTransformFeedbackStream(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawTransformFeedbackStream("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDrawTransformFeedbackStream(arg0,arg1,arg2);
    println("");
  }
  public  void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  long glCreateSyncFromCLeventARB(java.nio.Buffer arg0,java.nio.Buffer arg1,int arg2)
  {
    printIndent();
    print(    "glCreateSyncFromCLeventARB("+"<java.nio.Buffer> "+arg0+", "+"<java.nio.Buffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    long _res = downstreamGL4.glCreateSyncFromCLeventARB(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetQueryObjecti64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL4.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetIntegeri_v(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteShader(int arg0)
  {
    printIndent();
    print(    "glDeleteShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDeleteShader(arg0);
    println("");
  }
  public  void glEnable(int arg0)
  {
    printIndent();
    print(    "glEnable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glEnable(arg0);
    println("");
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenQueries(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertexAttribL2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL4.glVertexAttribL2d(arg0,arg1,arg2);
    println("");
  }
  public  void glGenerateMipmap(int arg0)
  {
    printIndent();
    print(    "glGenerateMipmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glGenerateMipmap(arg0);
    println("");
  }
  public  void glProgramUniform1uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform1uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUseProgram(int arg0)
  {
    printIndent();
    print(    "glUseProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glUseProgram(arg0);
    println("");
  }
  public  void glGetUniformSubroutineuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformSubroutineuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetUniformSubroutineuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetDoublei_v(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetDoublei_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glGetDoublei_v(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4uiv(arg0,arg1);
    println("");
  }
  public  void glTexCoordP2ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glTexCoordP2ui(arg0,arg1);
    println("");
  }
  public  void glVertexP2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexP2uiv(arg0,arg1);
    println("");
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribL4dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribL4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glProgramUniform3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL4.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glBeginQuery(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBeginQuery(arg0,arg1);
    println("");
  }
  public  void glDeleteSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteSamplers(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nub(int arg0,byte arg1,byte arg2,byte arg3,byte arg4)
  {
    printIndent();
    print(    "glVertexAttrib4Nub("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+", "+"<byte> "+arg4+")");
downstreamGL4.glVertexAttrib4Nub(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glCompressedTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL4.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenTextures(arg0,arg1);
    println("");
  }
  public  void glPauseTransformFeedback()
  {
    printIndent();
    print(    "glPauseTransformFeedback("+")");
downstreamGL4.glPauseTransformFeedback();
    println("");
  }
  public  void glMultiDrawElementsIndirectAMD(int arg0,int arg1,java.nio.Buffer arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glMultiDrawElementsIndirectAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glMultiDrawElementsIndirectAMD(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glFramebufferTexture(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDisableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glDisableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDisableVertexAttribArray(arg0);
    println("");
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glLinkProgram(int arg0)
  {
    printIndent();
    print(    "glLinkProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glLinkProgram(arg0);
    println("");
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glScissorArrayv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glScissorArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glScissorArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glProgramUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glGetnMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoordP4ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP4ui(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawBuffer(int arg0)
  {
    printIndent();
    print(    "glDrawBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDrawBuffer(arg0);
    println("");
  }
  public  void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glColorP3uiv(arg0,arg1);
    println("");
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL4.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenRenderbuffers(arg0,arg1);
    println("");
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetnPixelMapfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearBufferfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glClearBufferfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI3ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribI3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetBoundBuffer(int arg0)
  {
    printIndent();
    print(    "glGetBoundBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL4.glGetBoundBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4iv(arg0,arg1);
    println("");
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetBufferParameteri64v(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
downstreamGL4.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetBufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  int getBoundFramebuffer(int arg0)
  {
        return downstreamGL4.getBoundFramebuffer(arg0);
  }
  public  void glClearBufferiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glClearBufferiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glScissor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glScissor(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteNamedStringARB(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glDeleteNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
downstreamGL4.glDeleteNamedStringARB(arg0,arg1);
    println("");
  }
  public  void glGetnSeparableFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5,java.nio.Buffer arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glGetnSeparableFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL4.glGetnSeparableFilter(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glGetUniformdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glGetUniformdv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL1dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttribL1dv(arg0,arg1);
    println("");
  }
  public  boolean glIsShader(int arg0)
  {
    printIndent();
    print(    "glIsShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsShader(arg0);
    println(" = "+_res);
    return _res;
  }
  public  boolean glIsNamedBufferResidentNV(int arg0)
  {
    printIndent();
    print(    "glIsNamedBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsNamedBufferResidentNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glUniform1iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glIsProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsProgramPipeline(arg0);
    println(" = "+_res);
    return _res;
  }
  public  int glGetSubroutineUniformLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glGetSubroutineUniformLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
    int _res = downstreamGL4.glGetSubroutineUniformLocation(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glViewportIndexedf(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glViewportIndexedf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL4.glViewportIndexedf(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteBuffers(arg0,arg1);
    println("");
  }
  public  void glGetBooleani_v(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetBooleani_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glClearBufferfi(int arg0,int arg1,float arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glClearBufferfi(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glVertexAttrib2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
downstreamGL4.glVertexAttrib2f(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib2d(int arg0,double arg1,double arg2)
  {
    printIndent();
    print(    "glVertexAttrib2d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+")");
downstreamGL4.glVertexAttrib2d(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnUniformuiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnUniformuiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexP2ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexP2ui(arg0,arg1);
    println("");
  }
  public  void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexImage3DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL4.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glVertexAttrib2s(int arg0,short arg1,short arg2)
  {
    printIndent();
    print(    "glVertexAttrib2s("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<short> "+arg1+", "+"<short> "+arg2+")");
downstreamGL4.glVertexAttrib2s(arg0,arg1,arg2);
    println("");
  }
  public  void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glPointParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPointParameteriv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glPointParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFloati_v(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetFloati_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetFloati_v(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glValidateProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glValidateProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glValidateProgramPipeline(arg0);
    println("");
  }
  public  void glTexImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexImage2DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL4.glTexImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
downstreamGL4.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetActiveSubroutineName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL4.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
downstreamGL4.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform1dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean hasBasicFBOSupport()
  {
        return downstreamGL4.hasBasicFBOSupport();
  }
  public  void glVertexAttribI4usv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4usv(arg0,arg1);
    println("");
  }
  public  int glCreateShaderProgramv(int arg0,int arg1,com.jogamp.common.nio.PointerBuffer arg2)
  {
    printIndent();
    print(    "glCreateShaderProgramv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg2+")");
    int _res = downstreamGL4.glCreateShaderProgramv(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenFramebuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiDrawElements(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4)
  {
    printIndent();
    print(    "glMultiDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glMultiDrawElements(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilMaskSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilMaskSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glStencilMaskSeparate(arg0,arg1);
    println("");
  }
  public  void glFramebufferTextureFaceARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureFaceARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glFramebufferTextureFaceARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTessellationModeAMD(int arg0)
  {
    printIndent();
    print(    "glTessellationModeAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glTessellationModeAMD(arg0);
    println("");
  }
  public  void glSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL4.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glTexCoordP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glTexCoordP3uiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribdv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI1uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
downstreamGL4.glWaitSync(arg0,arg1,arg2);
    println("");
  }
  public  void glNormalFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glNormalFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glNormalFormatNV(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib1fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib1fv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnMapdv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4usv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4usv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib3fv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glGetBooleanv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL4.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetFloatv(arg0,arg1,arg2);
    println("");
  }
  public  void glScissorIndexedv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glScissorIndexedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glScissorIndexedv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL4.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  long glFenceSync(int arg0,int arg1)
  {
    printIndent();
    print(    "glFenceSync("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    long _res = downstreamGL4.glFenceSync(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glCopyBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL4.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glViewport("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glViewport(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform3fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribP1uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindTransformFeedback(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindTransformFeedback(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4iv(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsProgram(int arg0)
  {
    printIndent();
    print(    "glIsProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsProgram(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTexStorage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPatchParameterfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glPatchParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glPatchParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetNamedStringivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetNamedStringivARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1f(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glProgramUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL4.glProgramUniform1f(arg0,arg1,arg2);
    println("");
  }
  public  void glBlendEquationi(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBlendEquationi(arg0,arg1);
    println("");
  }
  public  void glUniform3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribIFormatNV(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribIFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribIFormatNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSetMultisamplefvAMD(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glSetMultisamplefvAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glSetMultisamplefvAMD(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4fv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL1dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribL1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetProgramStageiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetProgramStageiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI3iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI3iv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveUniform(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL4.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glPixelStoref(int arg0,float arg1)
  {
    printIndent();
    print(    "glPixelStoref("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL4.glPixelStoref(arg0,arg1);
    println("");
  }
  public  void glUniform1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  long glGetBufferSize(int arg0)
  {
    printIndent();
    print(    "glGetBufferSize("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    long _res = downstreamGL4.glGetBufferSize(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glTexParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexParameteri(arg0,arg1,arg2);
    println("");
  }
  public  int glGetDebugMessageLogAMD(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,byte[] arg10,int arg11)
  {
    printIndent();
    print(    "glGetDebugMessageLogAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+")");
    int _res = downstreamGL4.glGetDebugMessageLogAMD(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDeleteQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteQueries(arg0,arg1);
    println("");
  }
  public  void glVertexAttribI1iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI1iv(arg0,arg1,arg2);
    println("");
  }
  public  void glGenProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  public  void glColorP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glColorP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glColorP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetProgramPipelineiv(arg0,arg1,arg2);
    println("");
  }
  public  void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribL4dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttribL4dv(arg0,arg1);
    println("");
  }
  public  void glTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
downstreamGL4.glTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glColorFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glColorFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glColorFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetBufferParameteri64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean glIsTexture(int arg0)
  {
    printIndent();
    print(    "glIsTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsTexture(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform3dv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glSecondaryColorP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glSecondaryColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glSecondaryColorP3uiv(arg0,arg1);
    println("");
  }
  public  void glPrimitiveRestartIndex(int arg0)
  {
    printIndent();
    print(    "glPrimitiveRestartIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glPrimitiveRestartIndex(arg0);
    println("");
  }
  public  void glVertexAttrib4bv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4bv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib1sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib1sv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribDivisor(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribDivisor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexAttribDivisor(arg0,arg1);
    println("");
  }
  public  void glFramebufferTextureLayerARB(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayerARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glFramebufferTextureLayerARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBlendFunc(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBlendFunc(arg0,arg1);
    println("");
  }
  public  void glGetnPixelMapusv(int arg0,int arg1,short[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetnPixelMapusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetnPixelMapusv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI2uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI2uiv(arg0,arg1);
    println("");
  }
  public  void glProgramUniform1d(int arg0,int arg1,double arg2)
  {
    printIndent();
    print(    "glProgramUniform1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+")");
downstreamGL4.glProgramUniform1d(arg0,arg1,arg2);
    println("");
  }
  public  void glUseProgramStages(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUseProgramStages("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glUseProgramStages(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBlendEquationSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBlendEquationSeparate(arg0,arg1);
    println("");
  }
  public  void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnMapdv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glGetnMapdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL4.glUniform3f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindBuffer(arg0,arg1);
    println("");
  }
  public  void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL4.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glVertexAttribI4bv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4bv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI4bv(arg0,arg1);
    println("");
  }
  public  void glUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform2iv(arg0,arg1,arg2);
    println("");
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glCompileShaderIncludeARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetQueryObjectiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribdv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribdv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<long> "+arg9+")");
downstreamGL4.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  public  void glProgramUniformMatrix3x2dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteProgram(int arg0)
  {
    printIndent();
    print(    "glDeleteProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDeleteProgram(arg0);
    println("");
  }
  public  void glUniform1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glUniform1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL4.glUniform1d(arg0,arg1);
    println("");
  }
  public  void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetUniformfv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribFormatNV(int arg0,int arg1,int arg2,boolean arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribFormatNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI4ubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4ubv(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsBufferResidentNV(int arg0)
  {
    printIndent();
    print(    "glIsBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsBufferResidentNV(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform3d(int arg0,int arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glProgramUniform3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL4.glProgramUniform3d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribPointer(javax.media.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<javax.media.opengl.GLArrayData> "+arg0+")");
downstreamGL4.glVertexAttribPointer(arg0);
    println("");
  }
  public  void glProgramUniformMatrix3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL4.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  int glGetUniformLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL4.glGetUniformLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  int glGetFragDataLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetFragDataLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL4.glGetFragDataLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glProgramUniform3fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glProgramUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL4.glUniform1f(arg0,arg1);
    println("");
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnMapiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glProgramUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL4.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL4.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glMakeNamedBufferNonResidentNV(int arg0)
  {
    printIndent();
    print(    "glMakeNamedBufferNonResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glMakeNamedBufferNonResidentNV(arg0);
    println("");
  }
  public  void glVertexAttrib4Niv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Niv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Niv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL4.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexBuffer(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexBuffer(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveSubroutineUniformName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetActiveSubroutineUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL4.glGetActiveSubroutineUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glGetNamedStringARB(int arg0,java.lang.String arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
downstreamGL4.glGetNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glUniform3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL4.glUniform3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean isExtensionAvailable(java.lang.String arg0)
  {
        return downstreamGL4.isExtensionAvailable(arg0);
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glProgramUniform1dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDebugMessageInsertARB(int arg0,int arg1,int arg2,int arg3,int arg4,java.lang.String arg5)
  {
    printIndent();
    print(    "glDebugMessageInsertARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.lang.String> "+arg5+")");
downstreamGL4.glDebugMessageInsertARB(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glMultiTexCoordP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int glGetSubroutineIndex(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glGetSubroutineIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
    int _res = downstreamGL4.glGetSubroutineIndex(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  boolean glIsRenderbuffer(int arg0)
  {
    printIndent();
    print(    "glIsRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsRenderbuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  int glGetDebugMessageLogARB(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,int[] arg10,int arg11,byte[] arg12,int arg13)
  {
    printIndent();
    print(    "glGetDebugMessageLogARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg13).toUpperCase()+")");
    int _res = downstreamGL4.glGetDebugMessageLogARB(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramParameteriARB(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramParameteriARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glProgramParameteriARB(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform1fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCopyTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glCopyTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glCopyTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glLineWidth(float arg0)
  {
    printIndent();
    print(    "glLineWidth("+"<float> "+arg0+")");
downstreamGL4.glLineWidth(arg0);
    println("");
  }
  public  void glDrawBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDrawBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glGetActiveUniformName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glGetActiveUniformName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetnUniformdv(int arg0,int arg1,int arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnUniformdv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glGetnUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x3dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGenVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenVertexArrays(arg0,arg1);
    println("");
  }
  public  void glGetnConvolutionFilter(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetnConvolutionFilter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glGetnConvolutionFilter(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniformSubroutinesuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniformSubroutinesuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetAttachedShaders(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetAttachedShaders(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetAttachedShaders(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetAttachedShaders(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glClampColor(int arg0,int arg1)
  {
    printIndent();
    print(    "glClampColor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glClampColor(arg0,arg1);
    println("");
  }
  public  java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glMapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGL4.glMapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindSampler(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindSampler(arg0,arg1);
    println("");
  }
  public  void glBeginQueryIndexed(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBeginQueryIndexed("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glBeginQueryIndexed(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform4uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilMask(int arg0)
  {
    printIndent();
    print(    "glStencilMask("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glStencilMask(arg0);
    println("");
  }
  public  void glUniform3dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDrawTransformFeedbackStreamInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawTransformFeedbackStreamInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glDrawTransformFeedbackStreamInstanced(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMinSampleShading(float arg0)
  {
    printIndent();
    print(    "glMinSampleShading("+"<float> "+arg0+")");
downstreamGL4.glMinSampleShading(arg0);
    println("");
  }
  public  void glNormalP3uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glNormalP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glNormalP3uiv(arg0,arg1);
    println("");
  }
  public  void glGetQueryiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetQueryiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform1i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glProgramUniform1i(arg0,arg1,arg2);
    println("");
  }
  public  void glGetProgramBinary(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetProgramBinary(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL4.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetProgramPipelineInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttribL4d(int arg0,double arg1,double arg2,double arg3,double arg4)
  {
    printIndent();
    print(    "glVertexAttribL4d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+")");
downstreamGL4.glVertexAttribL4d(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPixelStorei(int arg0,int arg1)
  {
    printIndent();
    print(    "glPixelStorei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glPixelStorei(arg0,arg1);
    println("");
  }
  public  void glGetBufferParameterui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetBufferParameterui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetIntegerui64vNV(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL4.glGetIntegerui64vNV(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribP2uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetShaderiv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib1dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib1dv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribI3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribI3i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGetIntegerv(arg0,arg1);
    println("");
  }
  public  void glGetnMapfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnMapfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glClear(int arg0)
  {
    printIndent();
    print(    "glClear("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glClear(arg0);
    println("");
  }
  public  void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttrib3dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glGetSynciv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetSynciv(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL4.glGetSynciv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnPixelMapfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetnPixelMapfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetnPixelMapfv(arg0,arg1,arg2);
    println("");
  }
  public  void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glClearBufferfv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform1dv(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform1dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteTextures(arg0,arg1);
    println("");
  }
  public  void glGetVertexAttribLdv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribLdv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glGetVertexAttribLdv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetFloati_v(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFloati_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetFloati_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glUniform1i(arg0,arg1);
    println("");
  }
  public  void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glProvokingVertex(int arg0)
  {
    printIndent();
    print(    "glProvokingVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glProvokingVertex(arg0);
    println("");
  }
  public  void glVertexAttribI4usv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4usv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL4.glTexParameterf(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenBuffers(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nuiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Nuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
downstreamGL4.glGetBooleani_v(arg0,arg1,arg2);
    println("");
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetQueryObjectuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform4iv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCopyTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glCopyTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glCopyTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glResumeTransformFeedback()
  {
    printIndent();
    print(    "glResumeTransformFeedback("+")");
downstreamGL4.glResumeTransformFeedback();
    println("");
  }
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetQueryIndexediv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetQueryIndexediv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnHistogram(int arg0,boolean arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glGetnHistogram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL4.glGetnHistogram(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttribI1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribI1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexAttribI1i(arg0,arg1);
    println("");
  }
  public  void glGetShaderInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetShaderInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glProgramUniformui64vNV(int arg0,int arg1,int arg2,long[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniformui64vNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glStencilFunc(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glStencilFunc(arg0,arg1,arg2);
    println("");
  }
  public  void glGetDoublei_v(int arg0,int arg1,double[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetDoublei_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetDoublei_v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDrawArraysIndirect(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glDrawArraysIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
downstreamGL4.glDrawArraysIndirect(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetnUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  public  void glGetCompressedTexImage(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glGetCompressedTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
downstreamGL4.glGetCompressedTexImage(arg0,arg1,arg2);
    println("");
  }
  public  void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glPointParameterfv(arg0,arg1);
    println("");
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetUniformuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
downstreamGL4.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glTexCoordP4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glTexCoordP4uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform3i(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix4x3dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glNamedStringARB(int arg0,int arg1,java.lang.String arg2,int arg3,java.lang.String arg4)
  {
    printIndent();
    print(    "glNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.lang.String> "+arg4+")");
downstreamGL4.glNamedStringARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glVertexAttribP3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribLPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribLPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glVertexAttribLPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glUniform3fv(arg0,arg1,arg2);
    println("");
  }
  public  int glGetGraphicsResetStatus()
  {
    printIndent();
    print(    "glGetGraphicsResetStatus("+")");
    int _res = downstreamGL4.glGetGraphicsResetStatus();
    println(" = "+_res);
    return _res;
  }
  public  void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glGetFloatv(arg0,arg1);
    println("");
  }
  public  void glMakeBufferNonResidentNV(int arg0)
  {
    printIndent();
    print(    "glMakeBufferNonResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glMakeBufferNonResidentNV(arg0);
    println("");
  }
  public  void glBlendEquationSeparatei(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glBlendEquationSeparatei(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetQueryObjecti64v(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetUniformIndices(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib4usv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4usv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4usv(arg0,arg1,arg2);
    println("");
  }
  public  void glDeleteVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteVertexArrays(arg0,arg1);
    println("");
  }
  public  void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
downstreamGL4.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glPolygonOffset(float arg0,float arg1)
  {
    printIndent();
    print(    "glPolygonOffset("+"<float> "+arg0+", "+"<float> "+arg1+")");
downstreamGL4.glPolygonOffset(arg0,arg1);
    println("");
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glBindImageTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetBooleanv(arg0,arg1,arg2);
    println("");
  }
  public  void glEndConditionalRender()
  {
    printIndent();
    print(    "glEndConditionalRender("+")");
downstreamGL4.glEndConditionalRender();
    println("");
  }
  public  void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib1fv(arg0,arg1);
    println("");
  }
  public  void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetInteger64i_v(arg0,arg1,arg2);
    println("");
  }
  public  void glBindRenderbuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindRenderbuffer(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib3fv(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glUniform1fv(arg0,arg1,arg2);
    println("");
  }
  public  void glBindBufferBase(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBindBufferBase("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glBindBufferBase(arg0,arg1,arg2);
    println("");
  }
  public  void glDepthRangeArrayv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glDepthRangeArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glDepthRangeArrayv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform4dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glProgramUniform4dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glIndexFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glIndexFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glIndexFormatNV(arg0,arg1);
    println("");
  }
  public  void glUniform2dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glUniform2dv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetnMapiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnMapiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetnMapiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glTessellationFactorAMD(float arg0)
  {
    printIndent();
    print(    "glTessellationFactorAMD("+"<float> "+arg0+")");
downstreamGL4.glTessellationFactorAMD(arg0);
    println("");
  }
  public  void glGetProgramInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
downstreamGL4.glGetProgramInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
downstreamGL4.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glUniform4dv(int arg0,int arg1,java.nio.DoubleBuffer arg2)
  {
    printIndent();
    print(    "glUniform4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg2+")");
downstreamGL4.glUniform4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindTexture(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindTexture(arg0,arg1);
    println("");
  }
  public  void glPointParameteri(int arg0,int arg1)
  {
    printIndent();
    print(    "glPointParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glPointParameteri(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Niv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Niv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Niv(arg0,arg1);
    println("");
  }
  public  void glVertexFormatNV(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glVertexFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexFormatNV(arg0,arg1,arg2);
    println("");
  }
  public  void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glEnablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glEnablei(arg0,arg1);
    println("");
  }
  public  void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  int glCreateShader(int arg0)
  {
    printIndent();
    print(    "glCreateShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGL4.glCreateShader(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetUniformui64vNV(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
downstreamGL4.glGetUniformui64vNV(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL4.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib2dv(arg0,arg1);
    println("");
  }
  public  void glClearStencil(int arg0)
  {
    printIndent();
    print(    "glClearStencil("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glClearStencil(arg0);
    println("");
  }
  public  void glEnableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glEnableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glEnableVertexAttribArray(arg0);
    println("");
  }
  public  void glUniformMatrix3x2dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3x2dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  boolean glIsVBOElementArrayEnabled()
  {
    printIndent();
    print(    "glIsVBOElementArrayEnabled("+")");
    boolean _res = downstreamGL4.glIsVBOElementArrayEnabled();
    println(" = "+_res);
    return _res;
  }
  public  void glTexCoordP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glTexCoordP3ui(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nbv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nbv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Nbv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetVertexAttribIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glEnableClientState(int arg0)
  {
    printIndent();
    print(    "glEnableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glEnableClientState(arg0);
    println("");
  }
  public  void glTextureImage2DMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTextureImage2DMultisampleNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
downstreamGL4.glTextureImage2DMultisampleNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glMultiTexCoordP4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMultiTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoordP3ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP3ui(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsNamedStringARB(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glIsNamedStringARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    boolean _res = downstreamGL4.glIsNamedStringARB(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetIntegerui64i_vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegerui64i_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetIntegerui64i_vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform4iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform4iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetTexImage(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glGetTexImage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
downstreamGL4.glGetTexImage(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL4.glBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glMultiTexCoordP1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glMultiTexCoordP1uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glClearDepthf(float arg0)
  {
    printIndent();
    print(    "glClearDepthf("+"<float> "+arg0+")");
downstreamGL4.glClearDepthf(arg0);
    println("");
  }
  public  void glUniform2iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCompressedTexImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glCompressedTexImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
downstreamGL4.glCompressedTexImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glProgramUniform2iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform2iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
downstreamGL4.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glReadnPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
downstreamGL4.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  boolean glIsEnabled(int arg0)
  {
    printIndent();
    print(    "glIsEnabled("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsEnabled(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glCompileShaderIncludeARB(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glCompileShaderIncludeARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glCompileShaderIncludeARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetQueryObjectiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetQueryObjectiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCullFace(int arg0)
  {
    printIndent();
    print(    "glCullFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glCullFace(arg0);
    println("");
  }
  public  void glFogCoordFormatNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glFogCoordFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glFogCoordFormatNV(arg0,arg1);
    println("");
  }
  public  void glUniform2fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glFramebufferTexture1D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glFramebufferTexture1D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glBindFramebuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glBindFramebuffer(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetInteger64v(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
downstreamGL4.glGetInteger64v(arg0,arg1);
    println("");
  }
  public  void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL4.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glColorP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glColorP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glColorP4uiv(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4sv(arg0,arg1);
    println("");
  }
  public  void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetProgramPipelineiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenProgramPipelines(arg0,arg1);
    println("");
  }
  public  void glProgramBinary(int arg0,int arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glProgramBinary(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glClearDepth(double arg0)
  {
    printIndent();
    print(    "glClearDepth("+"<double> "+arg0+")");
downstreamGL4.glClearDepth(arg0);
    println("");
  }
  public  void glViewportArrayv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glViewportArrayv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glViewportArrayv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4dv(arg0,arg1,arg2);
    println("");
  }
  public  void glEndQuery(int arg0)
  {
    printIndent();
    print(    "glEndQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glEndQuery(arg0);
    println("");
  }
  public  void glVertexAttribL3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertexAttribL3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL4.glVertexAttribL3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform1iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform1iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  boolean glIsEnabledi(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnabledi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsEnabledi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  int glGetFragDataIndex(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetFragDataIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL4.glGetFragDataIndex(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4ubv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4ubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4ubv(arg0,arg1);
    println("");
  }
  public  void glBindProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glBindProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glBindProgramPipeline(arg0);
    println("");
  }
  public  void glProgramUniformMatrix4x2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4x2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glBufferData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glBufferData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  javax.media.opengl.GLContext getContext()
  {
        return downstreamGL4.getContext();
  }
  public  java.lang.Object getPlatformGLExtensions()
  {
        return downstreamGL4.getPlatformGLExtensions();
  }
  public  void glSecondaryColorP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glSecondaryColorP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glSecondaryColorP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glMakeBufferResidentNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glMakeBufferResidentNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glMakeBufferResidentNV(arg0,arg1);
    println("");
  }
  public  void glGetnPolygonStipple(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetnPolygonStipple("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetnPolygonStipple(arg0,arg1,arg2);
    println("");
  }
  public  void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
downstreamGL4.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glVertexAttribP1ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribP1ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribP3ui(int arg0,int arg1,boolean arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glVertexAttribP3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glSamplerParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSamplerParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glSamplerParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribI2uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI2uiv(arg0,arg1,arg2);
    println("");
  }
  public  boolean hasFullFBOSupport()
  {
        return downstreamGL4.hasFullFBOSupport();
  }
  public  void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL4.glTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
downstreamGL4.glGetTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttribP1uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glVertexAttribP1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4iv(arg0,arg1);
    println("");
  }
  public  boolean glUnmapBuffer(int arg0)
  {
    printIndent();
    print(    "glUnmapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glUnmapBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib2sv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib2sv(arg0,arg1);
    println("");
  }
  public  int getMaxRenderbufferSamples()
  {
        return downstreamGL4.getMaxRenderbufferSamples();
  }
  public  void glUniformMatrix3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glVertexAttribL1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL4.glVertexAttribL1d(arg0,arg1);
    println("");
  }
  public  void glUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniformui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniformui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetNamedStringivARB(int arg0,java.lang.String arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetNamedStringivARB("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetNamedStringivARB(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glColorP4ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glColorP4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glColorP4ui(arg0,arg1);
    println("");
  }
  public  void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glCreateProgram()
  {
    printIndent();
    print(    "glCreateProgram("+")");
    int _res = downstreamGL4.glCreateProgram();
    println(" = "+_res);
    return _res;
  }
  public  java.lang.Object getExtension(java.lang.String arg0)
  {
        return downstreamGL4.getExtension(arg0);
  }
  public  void glGetProgramStageiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramStageiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetProgramStageiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  int glGetAttribLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGL4.glGetAttribLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  public  void glUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniform1uiv(arg0,arg1,arg2);
    println("");
  }
  public  boolean glIsVertexArray(int arg0)
  {
    printIndent();
    print(    "glIsVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGL4.glIsVertexArray(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawArraysInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI3iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI3iv(arg0,arg1);
    println("");
  }
  public  void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
downstreamGL4.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glProgramUniform1ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glProgramUniform1ui(arg0,arg1,arg2);
    println("");
  }
  public  int glClientWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glClientWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    int _res = downstreamGL4.glClientWaitSync(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  public  void glGetShaderSource(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glGetShaderSource(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glDrawArraysInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttribI1iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttribI1iv(arg0,arg1);
    println("");
  }
  public  void glDeleteQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteQueries(arg0,arg1,arg2);
    println("");
  }
  public  void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glBindBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
downstreamGL4.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  int getSwapInterval()
  {
        return downstreamGL4.getSwapInterval();
  }
  public  int glGetError()
  {
    printIndent();
    print(    "glGetError("+")");
    int _res = downstreamGL4.glGetError();
    println(" = "+_res);
    return _res;
  }
  public  void glVertexAttrib4Nusv(int arg0,java.nio.ShortBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nusv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ShortBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Nusv(arg0,arg1);
    println("");
  }
  public  void glTexCoordP4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glTexCoordP4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glTexCoordP4uiv(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3x4dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL3dv(int arg0,double[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribL3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribL3dv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexCoordP1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glTexCoordP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glTexCoordP1ui(arg0,arg1);
    println("");
  }
  public  void glDisable(int arg0)
  {
    printIndent();
    print(    "glDisable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDisable(arg0);
    println("");
  }
  public  void glVertexAttribP3uiv(int arg0,int arg1,boolean arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glVertexAttribP3uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glTextureImage3DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,boolean arg8)
  {
    printIndent();
    print(    "glTextureImage3DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<boolean> "+arg8+")");
downstreamGL4.glTextureImage3DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2dv(int arg0,int arg1,int arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glProgramUniform2dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glDepthMask(boolean arg0)
  {
    printIndent();
    print(    "glDepthMask("+"<boolean> "+arg0+")");
downstreamGL4.glDepthMask(arg0);
    println("");
  }
  public  void glProgramParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glProgramParameteri(arg0,arg1,arg2);
    println("");
  }
  public  void glGetBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glGetBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
downstreamGL4.glGetBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glProgramUniform2uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform2uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteVertexArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glBeginTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glBeginTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glBeginTransformFeedback(arg0);
    println("");
  }
  public  void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetUniformIndices(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexP3ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexP3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glVertexP3ui(arg0,arg1);
    println("");
  }
  public  void glDetachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glDetachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glDetachShader(arg0,arg1);
    println("");
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
downstreamGL4.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetActiveUniformsiv(int arg0,int arg1,int[] arg2,int arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
downstreamGL4.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glFinish()
  {
    printIndent();
    print(    "glFinish("+")");
downstreamGL4.glFinish();
    println("");
  }
  public  void glProgramUniformMatrix2x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib2fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib2fv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniform3uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glProgramUniform3uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix2x3dv(int arg0,int arg1,boolean arg2,double[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix2x3dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
downstreamGL4.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  public  void glDrawTransformFeedback(int arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glDrawTransformFeedback(arg0,arg1);
    println("");
  }
  public  void glBindVertexArray(int arg0)
  {
    printIndent();
    print(    "glBindVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glBindVertexArray(arg0);
    println("");
  }
  public  void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
downstreamGL4.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib3sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib3sv(arg0,arg1,arg2);
    println("");
  }
  public  void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenBuffers(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib4Nuiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4Nuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glVertexAttrib4Nuiv(arg0,arg1);
    println("");
  }
  public  java.lang.String glGetString(int arg0)
  {
    printIndent();
    print(    "glGetString("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    java.lang.String _res = downstreamGL4.glGetString(arg0);
    println(" = "+_res);
    return _res;
  }
  public  void glDrawTransformFeedbackInstanced(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawTransformFeedbackInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDrawTransformFeedbackInstanced(arg0,arg1,arg2);
    println("");
  }
  public  void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetQueryObjectuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glPointParameterf(int arg0,float arg1)
  {
    printIndent();
    print(    "glPointParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL4.glPointParameterf(arg0,arg1);
    println("");
  }
  public  void glStencilOpValueAMD(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilOpValueAMD("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glStencilOpValueAMD(arg0,arg1);
    println("");
  }
  public  void glProgramUniformMatrix2dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix2dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glUniformBlockBinding(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniformBlockBinding("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glUniformBlockBinding(arg0,arg1,arg2);
    println("");
  }
  public  void glUniform4fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glCompressedTexSubImage1D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glCompressedTexSubImage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
downstreamGL4.glCompressedTexSubImage1D(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  public  void glGetQueryIndexediv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetQueryIndexediv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetQueryIndexediv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glViewportIndexedfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glViewportIndexedfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glViewportIndexedfv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4dv(int arg0,int arg1,int arg2,boolean arg3,double[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[D>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
downstreamGL4.glProgramUniformMatrix4dv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGetActiveAttrib(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
downstreamGL4.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  void glGetActiveSubroutineName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    printIndent();
    print(    "glGetActiveSubroutineName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.ByteBuffer> "+arg5+")");
downstreamGL4.glGetActiveSubroutineName(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  public  void glGenTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glGenTransformFeedbacks(arg0,arg1);
    println("");
  }
  public  void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  public  void glTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBindAttribLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glBindAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
downstreamGL4.glBindAttribLocation(arg0,arg1,arg2);
    println("");
  }
  public  void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glMultiTexCoordP1ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMultiTexCoordP1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glMultiTexCoordP1ui(arg0,arg1,arg2);
    println("");
  }
  public  void glGetMultisamplefv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetMultisamplefv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribL2dv(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribL2dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glVertexAttribL2dv(arg0,arg1);
    println("");
  }
  public  void glGetUniformuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGetDoublev(int arg0,java.nio.DoubleBuffer arg1)
  {
    printIndent();
    print(    "glGetDoublev("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.DoubleBuffer> "+arg1+")");
downstreamGL4.glGetDoublev(arg0,arg1);
    println("");
  }
  public  void glProgramUniform4uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glProgramUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttribI4sv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4sv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttribI4sv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib4Nsv(int arg0,short[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nsv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Nsv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetNamedBufferParameterui64vNV(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetNamedBufferParameterui64vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetNamedBufferParameterui64vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib4Nubv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4Nubv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glVertexAttrib4Nubv(arg0,arg1,arg2);
    println("");
  }
  public  void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glVertexAttrib3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
downstreamGL4.glVertexAttrib3f(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glBlendFunci(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFunci("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glBlendFunci(arg0,arg1,arg2);
    println("");
  }
  public  void glNormalP3uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glNormalP3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glNormalP3uiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glGetQueryiv(arg0,arg1,arg2);
    println("");
  }
  public  void glDepthFunc(int arg0)
  {
    printIndent();
    print(    "glDepthFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glDepthFunc(arg0);
    println("");
  }
  public  void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glQueryCounter(int arg0,int arg1)
  {
    printIndent();
    print(    "glQueryCounter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glQueryCounter(arg0,arg1);
    println("");
  }
  public  void glTextureImage2DMultisampleCoverageNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,boolean arg7)
  {
    printIndent();
    print(    "glTextureImage2DMultisampleCoverageNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<boolean> "+arg7+")");
downstreamGL4.glTextureImage2DMultisampleCoverageNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  public  void glDeleteProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDeleteProgramPipelines(arg0,arg1);
    println("");
  }
  public  void glVertexAttribP2uiv(int arg0,int arg1,boolean arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glVertexAttribP2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
downstreamGL4.glVertexAttribP2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniform4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glUniformMatrix4x3dv(int arg0,int arg1,boolean arg2,java.nio.DoubleBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.DoubleBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix4x3dv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glVertexAttrib1d(int arg0,double arg1)
  {
    printIndent();
    print(    "glVertexAttrib1d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+")");
downstreamGL4.glVertexAttrib1d(arg0,arg1);
    println("");
  }
  public  void glGetShaderiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetShaderiv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
downstreamGL4.glUniform4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glActiveShaderProgram(int arg0,int arg1)
  {
    printIndent();
    print(    "glActiveShaderProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glActiveShaderProgram(arg0,arg1);
    println("");
  }
  public  void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
downstreamGL4.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  public  int getDefaultDrawFramebuffer()
  {
        return downstreamGL4.getDefaultDrawFramebuffer();
  }
  public  void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGetIntegerv(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix3x4dv(int arg0,int arg1,int arg2,boolean arg3,java.nio.DoubleBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4dv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.DoubleBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix3x4dv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glPolygonMode(int arg0,int arg1)
  {
    printIndent();
    print(    "glPolygonMode("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glPolygonMode(arg0,arg1);
    println("");
  }
  public  void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
downstreamGL4.glUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glDeleteTextures(arg0,arg1,arg2);
    println("");
  }
  public  void glCompileShader(int arg0)
  {
    printIndent();
    print(    "glCompileShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glCompileShader(arg0);
    println("");
  }
  public  void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
downstreamGL4.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glAttachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glAttachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
downstreamGL4.glAttachShader(arg0,arg1);
    println("");
  }
  public  void glVertexAttrib1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glVertexAttrib1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
downstreamGL4.glVertexAttrib1f(arg0,arg1);
    println("");
  }
  public  void glUniform(javax.media.opengl.GLUniformData arg0)
  {
    printIndent();
    print(    "glUniform("+"<javax.media.opengl.GLUniformData> "+arg0+")");
downstreamGL4.glUniform(arg0);
    println("");
  }
  public  void glDrawBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
downstreamGL4.glDrawBuffers(arg0,arg1);
    println("");
  }
  public  void glMemoryBarrier(int arg0)
  {
    printIndent();
    print(    "glMemoryBarrier("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glMemoryBarrier(arg0);
    println("");
  }
  public  void glEdgeFlagFormatNV(int arg0)
  {
    printIndent();
    print(    "glEdgeFlagFormatNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glEdgeFlagFormatNV(arg0);
    println("");
  }
  public  boolean isFunctionAvailable(java.lang.String arg0)
  {
        return downstreamGL4.isFunctionAvailable(arg0);
  }
  public  void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public  void glVertexAttrib3d(int arg0,double arg1,double arg2,double arg3)
  {
    printIndent();
    print(    "glVertexAttrib3d("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+")");
downstreamGL4.glVertexAttrib3d(arg0,arg1,arg2,arg3);
    println("");
  }
  public  boolean isNPOTTextureAvailable()
  {
        return downstreamGL4.isNPOTTextureAvailable();
  }
  public  void glUniformSubroutinesuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniformSubroutinesuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
downstreamGL4.glUniformSubroutinesuiv(arg0,arg1,arg2);
    println("");
  }
  public  void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
downstreamGL4.glGetQueryObjectui64v(arg0,arg1,arg2,arg3);
    println("");
  }
  public  void glGenVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
downstreamGL4.glGenVertexArrays(arg0,arg1,arg2);
    println("");
  }
  public  void glLogicOp(int arg0)
  {
    printIndent();
    print(    "glLogicOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
downstreamGL4.glLogicOp(arg0);
    println("");
  }
  public  void glSamplerParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glSamplerParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
downstreamGL4.glSamplerParameterf(arg0,arg1,arg2);
    println("");
  }
  public  void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
downstreamGL4.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("TraceGL4 [ implementing javax.media.opengl.GL4,\n\t");
    sb.append(" downstream: "+downstreamGL4.toString()+"\n\t]");
    return sb.toString();
  }
private PrintStream stream;
private int indent = 0;
protected String dumpArray(Object obj)
{
  if (obj == null) return "[null]";
  StringBuilder sb = new StringBuilder("[");
  int len  = java.lang.reflect.Array.getLength(obj);
  int count = Math.min(len,16);
  for ( int i =0; i < count; i++ ) {
    sb.append(java.lang.reflect.Array.get(obj,i));
    if (i < count-1)
      sb.append(',');
  }
  if ( len > 16 )
    sb.append("...").append(len);
  sb.append(']');
  return sb.toString();
}
protected void print(String str)
{
  stream.print(str);
}
protected void println(String str)
{
  stream.println(str);
}
protected void printIndent()
{
  for( int i =0; i < indent; i++) {stream.print(' ');}
}

  private GL4 downstreamGL4;
} // end class TraceGL4
