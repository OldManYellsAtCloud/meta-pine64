FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://pulse_volatiles.conf"

do_install:append(){
    install -d ${D}${sysconfdir}/tmpfiles.d
    install -m 0644 ${UNPACKDIR}/pulse_volatiles.conf  ${D}${sysconfdir}/tmpfiles.d/
}
