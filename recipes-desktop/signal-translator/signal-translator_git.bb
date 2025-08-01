LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://github.com/OldManYellsAtCloud/signal-translator.git;protocol=https;branch=master"
SRC_URI += "file://signal-translator.service"
SRC_URI += "file://signal-translat.cfg"
SRC_URI += "file://power_button_handler.sh"
SRC_URI += "file://configure_wwan.sh" 

DEPENDS = "sdbus-c++ loglib settingslib"

PV = "1.1+git${SRCPV}"
SRCREV = "c85fa79e5521932c7149c5ef56b611988a23e7dc"

inherit cmake systemd

do_install(){
  mkdir -p ${D}${bindir}
  cp ${B}/signal-translator ${D}${bindir}/
  install -D -m 0644 ${UNPACKDIR}/signal-translator.service ${D}${systemd_unitdir}/system/signal-translator.service
  install -D -m 0644 ${UNPACKDIR}/signal-translat.cfg ${D}${sysconfdir}/signal-translat.cfg
  install -D -m 0766 ${UNPACKDIR}/power_button_handler.sh ${D}${bindir}/power_button_handler.sh
  install -m 0766 ${UNPACKDIR}/configure_wwan.sh ${D}${bindir}/configure_wwan.sh
}

SYSTEMD_SERVICE:${PN} = "signal-translator.service"

COMPATIBLE_MACHINE = "^(pp|pppro|pinephone-1-2|pinephonepro-1-0)$"
