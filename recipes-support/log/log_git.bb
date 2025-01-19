LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/log.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "594245bb269db85d62e773e726cde7f6c99b2b3d"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = ""

