DESCRIPTION = "Qt application for checking Swiss public transportation"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtwayland-native qtdeclarative qtdeclarative-native"
RDEPENDS:${PN} = "qtwayland qtdeclarative"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/timetable.git;protocol=https;branch=master \
           file://bus.png \
           file://Timetable.cfg"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${UNPACKDIR}/git"

inherit qt6-cmake

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appBusTimetable ${D}/usr/bin/timetable
  install -d ${D}/home
  install -d ${D}/home/root
  install -m 0755 ${S}/sample_pine_bus.cfg ${D}/home/root/pine_bus.cfg
  install -d ${D}${datadir}/pixmaps
  install -m 0555 ${UNPACKDIR}/bus.png ${D}${datadir}/pixmaps/
  install -D -m 0555 ${UNPACKDIR}/Timetable.cfg ${D}${sysconfdir}/launcher/Timetable.cfg
}

FILES:${PN} += "/home/root/pine_bus.cfg"
FILES:${PN} += "${datadir}/pixmaps/bus.png"
FILES:${PN} += "${sysconfdir}/launcher/Timetable.cfg"
