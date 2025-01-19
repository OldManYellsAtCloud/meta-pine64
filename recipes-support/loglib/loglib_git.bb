LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/loglib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "a4ee47ee6cb8c47c8621f99994f1cb0802d6c339"

DEPENDS = "log"
RDEPENDS:${PN} = "log"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = ""

