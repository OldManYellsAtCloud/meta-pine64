DESCRIPTION = "Qt application for locking my phone screen"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtwayland-native qtdeclarative qtdeclarative-native sdbus-c++ loglibrary"
RDEPENDS:${PN} = "qtwayland qtdeclarative"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/screenlock.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit qt6-cmake

#do_install(){
#  install -d ${D}/usr/bin
#  install -m 0755 ${D}/../build/appBusTimetable ${D}/usr/bin/timetable
#  install -d ${D}/home
#  install -d ${D}/home/root
#  install -m 0755 ${S}/sample_pine_bus.cfg ${D}/home/root/pine_bus.cfg
#  install -d ${D}${datadir}/pixmaps
#  install -m 0555 ${S}/../bus.png ${D}${datadir}/pixmaps/
#  install -D -m 0555 ${S}/../Timetable.cfg ${D}${sysconfdir}/launcher/Timetable.cfg
#}

