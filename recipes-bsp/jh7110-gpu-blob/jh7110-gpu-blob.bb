LICENSE = "Closed"
LIC_FILES_CHKSUM = "file://../rgx.fw.36.50.54.182;md5=45badf3e1fb2c19b0140c5651ae59ae8"

SRC_URI = "file://rgx.fw.36.50.54.182 \
           file://rgx.sh.36.50.54.182 \
           "

INHIBIT_DEFAULT_DEPS = "1"

COMPATIBLE_MACHINE = "star64"

do_install(){
    install -D -m 0644 ${WORKDIR}/rgx.fw.36.50.54.182 ${D}${nonarch_base_libdir}/firmware/rgx.fw.36.50.54.182
    install -D -m 0644 ${WORKDIR}/rgx.sh.36.50.54.182 ${D}${nonarch_base_libdir}/firmware/rgx.sh.36.50.54.182
}

FILES:${PN} = "/lib/firmware/*"
INSANE_SKIP = "arch"
