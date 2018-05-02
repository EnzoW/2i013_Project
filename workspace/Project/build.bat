@ECHO OFF
set CLASSPATH=.;..\libs\gluegen-rt.jar;..\libs\jogl-all.jar;..\libs\commons-cli-1.4.jar

IF NOT EXIST build (
    mkdir build
)

cd src && dir *.java /b/s > src.tmp~ && echo Building project... && javac -d ..\build @src.tmp~ && xcopy ..\config ..\build\config\ /E && cd .. && echo Done. || echo Failed.

pause