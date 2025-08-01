LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR = "r05"

S = "${UNPACKDIR}"

SRC_URI = "file://power-up-modem.sh"
SRC_URI += "file://power-up-modem.service"

SYSTEMD_SERVICE:${PN} = "power-up-modem.service"

do_install:append(){
  install -D -m 0744 ${UNPACKDIR}/power-up-modem.sh ${D}${bindir}/power-up-modem.sh
  install -D -m 0644 ${UNPACKDIR}/power-up-modem.service ${D}${systemd_unitdir}/system/power-up-modem.service
}
