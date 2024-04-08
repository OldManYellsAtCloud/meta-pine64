DESCRIPTION = "Qt application to enter the PIN for EG25 modem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtdeclarative qtdeclarative-native loglibrary sdbus-c++ settingslib"
RDEPENDS:${PN} = "qtwayland qtdeclarative modemmanager-ng"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/pin-enter.git;protocol=ssh;branch=master \
           file://sim-card.png \
           file://pin-enter.cfg \
           file://pin-enter.service"

PV = "1.0+git${SRCPV}"
SRCREV = "cb57ef45e1a8407bf34c09ff248af70c5c5d96a0"

S = "${WORKDIR}/git"

inherit qt6-cmake

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appmodem-network ${D}/usr/bin/pin-enter
  install -d ${D}${datadir}/pixmaps
  install -m 0555 ${S}/../sim-card.png ${D}${datadir}/pixmaps/
  install -D -m 0555 ${S}/../pin-enter.cfg ${D}${sysconfdir}/launcher/pin-enter.cfg
}

FILES:${PN} += "${datadir}/pixmaps/sim-card.png"
FILES:${PN} += "${sysconfdir}/launcher/pin-enter.cfg"
FILES:${PN} += "${systemd_unitdir}/system/pin-enter.servic"
