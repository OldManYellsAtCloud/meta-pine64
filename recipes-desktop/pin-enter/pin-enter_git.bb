DESCRIPTION = "Qt application to enter the PIN for EG25 modem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtdeclarative qtdeclarative-native sdbus-c++ settingslib nlohmann-json"
RDEPENDS:${PN} = "qtwayland qtdeclarative modemmanager-ng"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/pin-enter.git;protocol=ssh;branch=master \
           file://sim-card.png \
           file://pin-enter.cfg \
           file://pin-enter.service \
           file://org.gspine.sim.conf"

PV = "1.0+git${SRCPV}"
SRCREV = "a5622273bbe890bd521d34b578ce90b72452627b"

inherit qt6-cmake

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appmodem-network ${D}/usr/bin/pin-enter
  install -d ${D}${datadir}/pixmaps
  install -m 0555 ${UNPACKDIR}/sim-card.png ${D}${datadir}/pixmaps/
  install -D -m 0555 ${UNPACKDIR}/pin-enter.cfg ${D}${sysconfdir}/launcher/pin-enter.cfg
  install -D -m 0644 ${UNPACKDIR}/org.gspine.sim.conf ${D}${sysconfdir}/dbus-1/system.d/org.gspine.sim.conf
}

FILES:${PN} += "${datadir}/pixmaps/sim-card.png"
FILES:${PN} += "${sysconfdir}/launcher/pin-enter.cfg"
FILES:${PN} += "${systemd_unitdir}/system/pin-enter.servic"
