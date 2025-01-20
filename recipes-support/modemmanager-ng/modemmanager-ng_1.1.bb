LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/ModemManager.git;protocol=https;branch=master \
           file://modemmanager.service \
           file://appconfig.cfg"

DEPENDS = "sdbus-c++ qtserialport settingslib qtwayland qtdeclarative qtwayland-native loglib nlohmann-json"
RDEPENDS:${PN} = "qtserialport settingslib"

PV = "1.1"
SRCREV = "${AUTOREV}"

S = "${UNPACKDIR}/git"

inherit qt6-cmake systemd

EXTRA_OECMAKE = " -Dbuild_ui=OFF "

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/modemmanager.service ${D}${systemd_unitdir}/system/modemmanager.service
  install -D -m 0644 ${UNPACKDIR}/appconfig.cfg ${D}${sysconfdir}/modemmanager.cfg
}

SYSTEMD_SERVICE:${PN} = "modemmanager.service"
