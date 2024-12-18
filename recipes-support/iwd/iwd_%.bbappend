FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG:append = " ofono "

SRC_URI += "file://main.conf"

do_install:append(){
    install -D -m 0755 ${UNPACKDIR}/main.conf ${D}/${sysconfdir}/iwd/main.conf
}

FILES:${PN} += "/etc/iwd/main.conf"
