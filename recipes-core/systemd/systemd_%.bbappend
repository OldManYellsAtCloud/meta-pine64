do_install:append(){
    install -d ${D}${sysconfdir}/systemd/network
    ln -s /dev/null ${D}${sysconfdir}/systemd/network/99-default.link
}

FILES:${PN} += "/etc/systemd/network/99-default.link"
PACKAGECONFIG:append = " coredump"
