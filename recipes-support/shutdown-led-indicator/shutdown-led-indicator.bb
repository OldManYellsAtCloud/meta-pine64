LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR="r01"

SRC_URI = "file://shutdown-led-indicator.service"

SYSTEMD_SERVICE:${PN} = "shutdown-led-indicator.service"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/shutdown-led-indicator.service ${D}${systemd_unitdir}/system/shutdown-led-indicator.service
}
