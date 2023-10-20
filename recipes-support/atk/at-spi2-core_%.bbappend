PACKAGECONFIG[x11] = "-Dx11=disabled,-Dx11=disabled,virtual/libx11 libxi libxtst"

pkg_postinst:${PN}:append() {
    mkdir -p $D${sysconfdir}/systemd/user/default.target.wants
    ln -s ${systemd_user_unitdir}/at-spi-dbus-bus.service $D${sysconfdir}/systemd/user/default.target.wants/at-spi-dbus-bus.service
}

PR = "r01"
