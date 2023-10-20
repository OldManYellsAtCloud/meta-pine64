

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../pointercal.xinput;md5=4aebd652e9c23d6837babdd28890465a"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://pointercal.xinput"

do_install(){
  install -d ${D}/etc
  install -m 0644 ${WORKDIR}/pointercal.xinput ${D}/etc/
}

FILES:{PN} = "/etc/pointercal.xinput"


