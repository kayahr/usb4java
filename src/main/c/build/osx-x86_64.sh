#!/bin/sh
#
# Builds libusb4java for 64 bit x86 OS X
# Must run natively on a OS X machine

set -e

. $(dirname $0)/common.sh

OS="osx"
ARCH="x86_64"
HOST="$ARCH-apple-darwin"
CFLAGS="-arch x86_64 -O2"
USB4JAVA_LIBS="-lobjc -Wl,-framework,IOKit -Wl,-framework,CoreFoundation"

build
