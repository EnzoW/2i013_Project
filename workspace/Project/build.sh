#!/bin/bash

function build {
    export CLASSPATH=".:../libs/gluegen-rt.jar:../libs/jogl-all.jar:../libs/commons-cli-1.4.jar"

    [ ! -d "build" ] && mkdir build
    cd src && printf "[ Project ] Building... " && javac -d ../build $(find . -name *.java) && cp -r ../config/ ../build/ && printf "Done.\n" || printf "Failed.\n"
}

function clean {
    printf "[ Project ] Deleting build directory... "
    rm -rf build/ && printf "Done.\n" || printf "Failed.\n"
}

case "$1" in 
    "clean") clean ;;
    *) build ;;
esac

exit 0