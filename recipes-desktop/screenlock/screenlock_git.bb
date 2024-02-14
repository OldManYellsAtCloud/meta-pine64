DESCRIPTION = "Qt application for locking my phone screen"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtwayland-native qtdeclarative qtdeclarative-native sdbus-c++ loglibrary buttond"
RDEPENDS:${PN} = "qtwayland qtdeclarative"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/screenlock.git;protocol=https;branch=master \
           file://screenlock.service"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit qt6-cmake systemd

do_install:append(){
  install -D -m 0644 ${WORKDIR}/screenlock.service ${D}${systemd_unitdir}/system/screenlock.service
}


SYSTEMD_SERVICE:${PN} = "screenlock.service"
