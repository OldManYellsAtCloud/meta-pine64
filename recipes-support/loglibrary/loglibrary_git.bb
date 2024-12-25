LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/LogLibrary.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND:append = " native nativesdk "
