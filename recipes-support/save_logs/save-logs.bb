LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r01"

SRC_URI += "file://save_logs.cfg \
            file://save_logs.png \
            file://save_logs.sh"


do_install(){
  install -D -m 0664 ${UNPACKDIR}/save_logs.cfg ${D}${sysconfdir}/launcher/save_logs.cfg
  install -D -m 0664 ${UNPACKDIR}/save_logs.png ${D}${datadir}/pixmaps/save_logs.png
  install -D -m 0755 ${UNPACKDIR}/save_logs.sh  ${D}${bindir}/save_logs.sh
}


FILES:${PN} += "${sysconfdir}/launcher/save_logs.cfg"
FILES:${PN} += "${datadir}/pixmaps/save_logs.png"
FILES:${PN} += "${bindir}/save_logs.sh"

INHIBIT_DEFAULT_DEPS = "1"
