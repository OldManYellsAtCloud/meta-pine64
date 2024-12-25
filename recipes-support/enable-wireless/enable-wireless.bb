LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR="r02"

SRC_URI += "file://enable-wireless.service"

S = "${UNPACKDIR}"

SYSTEMD_SERVICE:${PN} = "enable-wireless.service"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/enable-wireless.service ${D}${systemd_unitdir}/system/enable-wireless.service
}
