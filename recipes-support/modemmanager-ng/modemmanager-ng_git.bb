LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/ModemManager.git;protocol=https;branch=master"

DEPENDS = "sdbus-c++ qtserialport settingslib qtwayland qtdeclarative qtwayland-native"
RDEPENDS:${PN} = "qtserialport settingslib"

# Modify these as desired
PV = "1.0+git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: sdbus-c Qt6
inherit qt6-cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " -Dbuild_ui=ON "

