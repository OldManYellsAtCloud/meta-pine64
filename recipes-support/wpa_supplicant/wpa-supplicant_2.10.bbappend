FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant_volatiles.conf"

do_install:append(){
    install -d ${D}${sysconfdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/wpa_supplicant_volatiles.conf  ${D}${sysconfdir}/tmpfiles.d/
}
