LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/loglib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "b2a928263e93647f2360dbc880f9c9ffd920deae"

DEPENDS = "log"
RDEPENDS:${PN} = "log"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = ""

BBCLASSEXTEND:append = " native nativesdk "
