LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/SettingsLib.git;protocol=https;branch=master"

PV = "1.0+git"
SRCREV = "679ae38f21a7efaf6877d15c56e62e7a91612754"

DEPENDS = "googletest sdbus-c++ sdbus-c++-tools-native loglibrary"
RDEPENDS:${PN} = "loglibrary"

S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native nativesdk"
PROVIDES = "settingslib"

#do_install:append:${PN}-dev(){
#    rm ${D}${libdir}/libSettingsLib.so
#}
