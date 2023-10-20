LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR="r02"

SRC_URI += "file://enable-wireless.service"

SYSTEMD_SERVICE:${PN} = "enable-wireless.service"

do_install:append(){
  install -D -m 0644 ${WORKDIR}/enable-wireless.service ${D}${systemd_unitdir}/system/enable-wireless.service
}
