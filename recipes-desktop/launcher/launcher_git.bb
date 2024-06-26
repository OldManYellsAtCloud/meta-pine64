DESCRIPTION = "Small qt5 application to control some PinePhone properties"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland sdbus-c++ qtdeclarative-native loglibrary"
RDEPENDS:${PN} = "qtwayland sdbus-c++"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/Plauncher.git;protocol=ssh;branch=master"
SRC_URI += "file://launcher.service"

PV = "1.0+git${SRCPV}"
SRCREV = "b0fa5631c153cad077dde1329aeaf58c86c39f08"

S = "${WORKDIR}/git"

inherit qt6-cmake systemd

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appLauncher ${D}/usr/bin/launcher
  install -D -m 0644 ${WORKDIR}/launcher.service ${D}${systemd_unitdir}/system/launcher.service
}

SYSTEMD_SERVICE:${PN} = "launcher.service"
