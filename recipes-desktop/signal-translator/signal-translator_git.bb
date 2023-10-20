LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://github.com/OldManYellsAtCloud/signal-translator.git;protocol=https;branch=master"
SRC_URI += "file://signal-translator.service"

DEPENDS = "sdbus-c++"

PV = "1.0+git${SRCPV}"
SRCREV = "7b6f2f79540e9113e4d5703304ee519e8835f8d6"

S = "${WORKDIR}/git"

inherit cmake systemd

do_install(){
  mkdir -p ${D}${bindir}
  cp ${B}/signal-translator ${D}${bindir}/
  install -D -m 0644 ${WORKDIR}/signal-translator.service ${D}${systemd_unitdir}/system/signal-translator.service
}

SYSTEMD_SERVICE:${PN} = "signal-translator.service"
