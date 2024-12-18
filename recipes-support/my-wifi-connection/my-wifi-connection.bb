LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://git@192.168.1.130/opt/pine_secrets;branch=master;protocol=ssh"
SRCREV = "${AUTOREV}"

S = "${UNPACKDIR}/git"

do_install(){
    install -D -m 0755 -t ${D}${localstatedir}/lib/iwd/ ${S}/wifi/*psk
}

FILES:{PN} = "${localstatedir}/lib/iwd/*psk"

PR = "03"

INHIBIT_DEFAULT_DEPS = "1"
