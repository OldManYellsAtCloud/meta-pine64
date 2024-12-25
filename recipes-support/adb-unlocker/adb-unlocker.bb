LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "libxcrypt"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

S = "${UNPACKDIR}"

SRC_URI = "file://whatev.c"

do_compile(){
  ${CC} -lcrypt ${S}/whatev.c -o adb-unlocker
}

do_install(){
  install -d ${D}/usr/bin
  install -m 755 ${S}/adb-unlocker ${D}${bindir}
}

FILES:${PN} = "${bindir}/adb-unlocker"

INSANE_SKIP:${PN} = "ldflags"
