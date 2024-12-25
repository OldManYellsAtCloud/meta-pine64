LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1a885ff0d285800de347e86ce1f0694c"

SRC_URI = "git://gitlab.com/megapixels-org/libdng.git;branch=master;protocol=https"

DEPENDS = "tiff"

PV = "1.0+git"
SRCREV = "9c7b18e7ff687a8c69704dc6fc8e7689e2532060"

S = "${WORKDIR}/git"

inherit meson pkgconfig
