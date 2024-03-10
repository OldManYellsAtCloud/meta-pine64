LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/SettingsLib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "58061c5a619df04f825492aa177545a31ad2f191"

DEPENDS = "googletest loglibrary"
RDEPENDS:${PN} = "loglibrary"
RDEPENDS:${PN}-native = "loglibrary-native"

S = "${WORKDIR}/git"

inherit cmake

PROVIDES = "settingslib"

BBCLASSEXTEND:append = " native nativesdk "
