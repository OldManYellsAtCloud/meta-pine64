DESCRIPTION = "Qt application for managing EG25 modem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtdeclarative qtdeclarative-native qtserialport"
RDEPENDS:${PN} = "qtwayland qtdeclarative qtserialport"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/eg25debugger.git;protocol=ssh;branch=master \
           file://sim-card.png \
           file://eg25manager.cfg"

PV = "1.0+git${SRCPV}"
SRCREV = "352d0ee462b8248336989a1669b3fcf98926930e"

S = "${WORKDIR}/git"

inherit qt6-cmake

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appeg25debugger ${D}/usr/bin/eg25manager
  install -d ${D}${datadir}/pixmaps
  install -m 0555 ${S}/../sim-card.png ${D}${datadir}/pixmaps/
  install -D -m 0555 ${S}/../eg25manager.cfg ${D}${sysconfdir}/launcher/eg25manager.cfg
}

FILES:${PN} += "${datadir}/pixmaps/sim-card.png"
FILES:${PN} += "${sysconfdir}/launcher/eg25manager.cfg"
