LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR="r04"

SRC_URI = "file://power-up-modem.sh"
SRC_URI += "file://power-up-modem.service"

SYSTEMD_SERVICE:${PN} = "power-up-modem.service"

do_install:append(){
  install -D -m 0744 ${WORKDIR}/power-up-modem.sh ${D}${bindir}/power-up-modem.sh
  install -D -m 0644 ${WORKDIR}/power-up-modem.service ${D}${systemd_unitdir}/system/power-up-modem.service
}
