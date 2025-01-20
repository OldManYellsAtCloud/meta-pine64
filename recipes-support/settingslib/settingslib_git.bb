LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/SettingsLib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "2f114e5af4b5d277e1c6c0ac163af9af86249dbd"

DEPENDS = "googletest loglib"
RDEPENDS:${PN} = "loglib"
RDEPENDS:${PN}-native = "loglib-native"

S = "${WORKDIR}/git"

inherit cmake

PROVIDES = "settingslib"

BBCLASSEXTEND:append = " native nativesdk "
