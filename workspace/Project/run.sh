#!/bin/bash

export CLASSPATH=".:../libs/gluegen-rt.jar:../libs/jogl-all.jar:../libs/commons-cli-1.4.jar"

[ ! -d build ] && echo -e "Project not built yet." && ./build.sh

cd build && java etu.upmc.project.Application $@

exit 0
