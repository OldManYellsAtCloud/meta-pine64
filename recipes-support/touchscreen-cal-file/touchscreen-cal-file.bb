LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://pointercal.xinput"

S = "${UNPACKDIR}"

do_install(){
  install -d ${D}/etc
  install -m 0644 ${UNPACKDIR}/pointercal.xinput ${D}/etc/
}

FILES:{PN} = "/etc/pointercal.xinput"


