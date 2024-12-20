FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://fw_env.config"

do_install:append(){
    install -m 0755 -D ${UNPACKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}
