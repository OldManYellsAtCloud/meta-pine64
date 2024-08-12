inherit systemd useradd

PR = "r19"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://sway.service"
SRC_URI += "file://krtek.jpg"
SRC_URI += "file://0001-use-own-background.patch"
SRC_URI += "file://sway_volatiles.conf"
SRC_URI += "file://sway_status.sh"

SYSTEMD_SERVICE:${PN} = "sway.service"

PACKAGECONFIG:append = " swaybar"

do_install:append(){
    install -m 0644 ${WORKDIR}/krtek.jpg ${D}${datadir}/backgrounds/sway/
    install -D -m 0644 ${WORKDIR}/sway.service ${D}${systemd_unitdir}/system/sway.service

    install -d ${D}${sysconfdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/sway_volatiles.conf  ${D}${sysconfdir}/tmpfiles.d/

    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/sway_status.sh ${D}${bindir}/sway_status.sh
}

# these are only needed for two obscure user scripts, which most likely will never be used in this distro
RDEPENDS:${PN}:remove = "python3 python-i3ipc"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = "-u 1100 -d /home/swayuser -m -r -s /bin/sh -g swaygroup -G input,tty,video swayuser"
GROUPADD_PARAM:${PN} = "-g 500 swaygroup"

