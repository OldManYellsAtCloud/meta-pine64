FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://rodney-img.h"
SRC_URI += "file://0001-make-background-white.patch"
SRC_URI += "file://psplash-start.service"

SPLASH_IMAGES = "file://rodney-img.h;outsuffix=default"

PR = "r03"

EXTRA_OECONF += "--disable-startup-msg --enable-img-fullscreen"
