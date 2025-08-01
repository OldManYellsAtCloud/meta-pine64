DESCRIPTION = "Small qt5 application to control some PinePhone properties"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland sdbus-c++ qtdeclarative-native loglib"
RDEPENDS:${PN} = "qtwayland sdbus-c++ loglib"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/Plauncher.git;protocol=ssh;branch=master"
SRC_URI += "file://launcher.service"

PV = "1.1+git${SRCPV}"
SRCREV = "2b80c046a09880b0ffba0fd47975c8534fab9c0e"

inherit qt6-cmake systemd

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appLauncher ${D}/usr/bin/launcher
  install -D -m 0644 ${UNPACKDIR}/launcher.service ${D}${systemd_unitdir}/system/launcher.service
}

SYSTEMD_SERVICE:${PN} = "launcher.service"
