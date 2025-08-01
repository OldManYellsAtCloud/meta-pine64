LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR = "r01"

S = "${UNPACKDIR}"

SRC_URI = "file://shutdown-led-indicator.service"

SYSTEMD_SERVICE:${PN} = "shutdown-led-indicator.service"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/shutdown-led-indicator.service ${D}${systemd_unitdir}/system/shutdown-led-indicator.service
}
