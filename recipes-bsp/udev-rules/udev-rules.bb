LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "file://tty.rules"

do_install:append(){
  install -D -m 0644 ${UNPACKDIR}/tty.rules ${D}${sysconfdir}/udev/rules.d/tty.rules
}

PACKAGE_ARCHS = "noarch"
