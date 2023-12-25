LICENSE = "CLOSED"

SRC_URI = "file://rgx.fw.36.50.54.182 \
           file://rgx.sh.36.50.54.182 \
           file://chagall.bin \
           file://rtl8852bu_config.bin \
           file://rtl8852bu_fw.bin \
           "

INHIBIT_DEFAULT_DEPS = "1"

COMPATIBLE_MACHINE = "star64"

do_install(){
#    install -D -m 0644 ${WORKDIR}/rgx.fw.36.50.54.182 ${D}${nonarch_base_libdir}/firmware/rgx.fw.36.50.54.182
#    install -m 0644 ${WORKDIR}/rgx.sh.36.50.54.182 ${D}${nonarch_base_libdir}/firmware/rgx.sh.36.50.54.182
#    install -D -m 0644 ${WORKDIR}/chagall.bin ${D}${nonarch_base_libdir}/firmware/chagall.bin
    install -D -m 0644 ${WORKDIR}/rtl8852bu_config.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt/rtl8852bu_config.bin
    install -m 0644 ${WORKDIR}/rtl8852bu_fw.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt/rtl8852bu_fw.bin
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/*"
INSANE_SKIP = "arch"
