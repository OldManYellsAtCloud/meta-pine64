LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "file://tty.rules"

S = "${UNPACKDIR}"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/tty.rules ${D}${sysconfdir}/udev/rules.d/tty.rules
}

PACKAGE_ARCHS = "noarch"
