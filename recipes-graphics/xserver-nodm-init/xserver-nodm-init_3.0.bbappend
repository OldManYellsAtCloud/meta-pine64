FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://40-dpi.conf"

do_install:append(){
    mkdir -p ${D}${sysconfdir}/X11/xorg.conf.d
    install -m 644 ${WORKDIR}/40-dpi.conf ${D}${sysconfdir}/X11/xorg.conf.d/
}

SYSTEMD_AUTO_ENABLE = "disable"
