@ECHO OFF
set CLASSPATH=.;..\libs\gluegen-rt.jar;..\libs\jogl-all.jar;..\libs\commons-cli-1.4.jar

IF NOT EXIST build (
    mkdir build
    echo Project not built yet.
    call build
)

cd build && java etu.upmc.project.Application %*

pause