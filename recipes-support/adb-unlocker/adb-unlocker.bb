LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../whatev.c;md5=d475f6e9f135b2ccc28137c8b4dc2467"

DEPENDS = "libxcrypt"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://whatev.c"

do_compile(){
  ${CC} -lcrypt ${WORKDIR}/whatev.c -o adb-unlocker
}

do_install(){
  install -d ${D}/usr/bin
  install -m 755 ${WORKDIR}/adb-unlocker-1.0/adb-unlocker ${D}/usr/bin/
}

FILES:${PN} = "/usr/bin/adb-unlocker"
