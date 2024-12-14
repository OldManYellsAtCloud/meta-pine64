LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/pointercal.xinput;md5=4aebd652e9c23d6837babdd28890465a"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://pointercal.xinput"

do_install(){
  install -d ${D}/etc
  install -m 0644 ${UNPACKDIR}/pointercal.xinput ${D}/etc/
}

FILES:{PN} = "/etc/pointercal.xinput"


