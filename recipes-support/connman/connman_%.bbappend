PR = "r12"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://main.conf \
            file://connman_sway.conf"

do_install:append(){
    install -D -m 0444 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
    install -D -m 0644 ${WORKDIR}/connman_sway.conf ${D}${sysconfdir}/dbus-1/system.d/connman_sway.conf
}

FILES:${PN} += "${sysconfdir}/connman/main.conf"
FILES:${PN} += "${sysconfdir}/dbus-1/system.d/connman_sway.conf"

PACKAGECONFIG:remove = "iptables"
PACKAGECONFIG:append = " nftables "
