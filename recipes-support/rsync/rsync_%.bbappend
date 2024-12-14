FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://rsync.service"

inherit systemd

SYSTEMD_SERVICE:${PN} = "rsync.service"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/rsync.service ${D}${systemd_unitdir}/system/rsync.service
}
