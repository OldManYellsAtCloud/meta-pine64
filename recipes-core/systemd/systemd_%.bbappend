FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://10-wwan.network.template"

do_install:append(){
    install -d ${D}${sysconfdir}/systemd/network
    ln -s /dev/null ${D}${sysconfdir}/systemd/network/99-default.link
    install -m 0555 ${UNPACKDIR}/10-wwan.network.template ${D}${sysconfdir}/systemd/network/10-wwan.network.template
}

FILES:${PN} += "${sysconfdir}/systemd/network/99-default.link"
FILES:${PN} += "${sysconfdir}/systemd/network/10-wwan.network.template"

PACKAGECONFIG:append = " coredump"
