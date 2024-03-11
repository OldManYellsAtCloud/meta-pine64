LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/ModemManager.git;protocol=https;branch=master \
           file://modemmanager.service \
           file://appconfig.cfg"

DEPENDS = "sdbus-c++ qtserialport settingslib qtwayland qtdeclarative qtwayland-native"
RDEPENDS:${PN} = "qtserialport settingslib"

PV = "1.0+git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit qt6-cmake systemd

EXTRA_OECMAKE = " -Dbuild_ui=ON "

do_install:append(){
  install -D -m 0644 ${WORKDIR}/modemmanager.service ${D}${systemd_unitdir}/system/modemmanager.service
  install -D -m 0644 ${WORKDIR}/appconfig.cfg ${D}${sysconfdir}/modemservice.cfg
}

SYSTEMD_SERVICE:${PN} = "modemmanager.service"
