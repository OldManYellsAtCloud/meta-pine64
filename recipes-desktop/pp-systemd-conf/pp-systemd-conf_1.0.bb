DESCRIPTION = "Extra systemd config files for PinePhone"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r01"

SRC_URI += "file://00-pinephone.conf"

# these are just config files, no need for a compiler
INHIBIT_DEFAULT_DEPENDENCIES = "1"

do_install(){
  install -D -m0644 ${WORKDIR}/00-pinephone.conf ${D}${systemd_unitdir}/logind.conf.d/00-pinephone.conf
}

FILES:${PN} = "${systemd_unitdir}/logind.conf.d/"
