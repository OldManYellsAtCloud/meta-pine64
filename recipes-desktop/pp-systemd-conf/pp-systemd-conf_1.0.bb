DESCRIPTION = "Extra systemd config files for PinePhone"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r01"

SRC_URI += "file://00-pinephone.conf"
SRC_URI += "file://10-wwan.network.template"

# these are just config files, no need for a compiler
INHIBIT_DEFAULT_DEPENDENCIES = "1"

S = "${UNPACKDIR}"

do_install(){
  install -D -m0644 ${UNPACKDIR}/00-pinephone.conf ${D}${systemd_unitdir}/logind.conf.d/00-pinephone.conf

  install -d ${D}${sysconfdir}/systemd/network
  ln -s /dev/null ${D}${sysconfdir}/systemd/network/99-default.link
  install -m 0555 ${UNPACKDIR}/10-wwan.network.template ${D}${sysconfdir}/systemd/network/10-wwan.network.template
}

FILES:${PN} = "${systemd_unitdir}/logind.conf.d/"
FILES:${PN} += "${sysconfdir}/systemd/network/99-default.link"
FILES:${PN} += "${sysconfdir}/systemd/network/10-wwan.network.template"
