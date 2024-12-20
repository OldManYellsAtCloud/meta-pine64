FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://webserver-args \
            file://systemd.cfg"

do_install:append(){
  install -D -m 0555 ${UNPACKDIR}/webserver-args ${D}{sysconfdir}/swupdate/conf.d/webserver-args
}

# don't start it automatically
SYSTEMD_AUTO_ENABLE="disable"
