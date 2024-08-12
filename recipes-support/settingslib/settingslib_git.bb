LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/SettingsLib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "08dd7e231fdab67d15c5083dade558b68580cc20"

DEPENDS = "googletest loglibrary"
RDEPENDS:${PN} = "loglibrary"
RDEPENDS:${PN}-native = "loglibrary-native"

S = "${WORKDIR}/git"

inherit cmake

PROVIDES = "settingslib"

BBCLASSEXTEND:append = " native nativesdk "
