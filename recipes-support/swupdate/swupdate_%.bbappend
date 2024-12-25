FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://webserver-args \
            file://sw-selection-args \
            file://systemd.cfg \
            file://store-update-result-in-u-boot.cfg \
            file://swupdate.launcher_conf"

do_install:append(){
  install -D -m 0555 ${UNPACKDIR}/webserver-args ${D}${sysconfdir}/swupdate/conf.d/webserver-args
  install -m 0555 ${UNPACKDIR}/sw-selection-args ${D}${sysconfdir}/swupdate/conf.d/sw-selection-args

  install -D -m 0555 ${UNPACKDIR}/swupdate.launcher_conf ${D}${sysconfdir}/launcher/swupdate.cfg
  install -D -m 0555 ${S}/web-app/images/favicon.png ${D}${datadir}/pixmaps/swupdate.png
}

FILES:${PN} += "${sysconfdir}/swupdate/conf.d/webserver-args"
FILES:${PN} += "${sysconfdir}/swupdate/conf.d/sw-selection-args"
FILES:${PN} += "${sysconfdir}/launcher/swupdate.cfg"
FILES:${PN} += "${datadir}/pixmaps/swupdate.png"

# don't start it automatically
SYSTEMD_AUTO_ENABLE="disable"
