LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/log.git;protocol=https;branch=master \
           file://log.service"

PV = "1.0+git"
SRCREV = "1b25cb7ad80c7b4a16cc7021a21dcc319fc7c835"

S = "${WORKDIR}/git"

inherit cmake systemd

EXTRA_OECMAKE = ""

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/log.service ${D}${systemd_unitdir}/system/log.service
}

SYSTEMD_SERVICE:${PN} = "log.service"

BBCLASSEXTEND:append = " native nativesdk "
