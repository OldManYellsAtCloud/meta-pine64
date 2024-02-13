PR = "r11"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://main.conf"

do_install:append(){
    mkdir -p ${D}${sysconfdir}/connman
    install -m 0444 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/main.conf
}

FILES:${PN} += "/etc/connman/main.conf"

PACKAGECONFIG:remove = "iptables"
PACKAGECONFIG:append = " nftables "
