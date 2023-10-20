DESCRIPTION = "Virtual keyboard for wayland"

S = "${WORKDIR}/git"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PR = "r15"

PROVIDES += "wvkbd"

DEPENDS = "cairo pango wayland libxkbcommon wayland-native wayland-protocols"

SRC_URI = "git://github.com/OldManYellsAtCloud/wvkbd.git;protocol=https;branch=react-on-text-input"
SRC_URI += "file://wvkbd.service"

SRCREV = "${AUTOREV}"
# 83edf203a7e6c1c08dd97bebcc9a240f04565ccc

S = "${WORKDIR}/git"

inherit pkgconfig systemd

do_compile(){
  cd ${S}
  oe_runmake
}

do_install(){
  mkdir -p ${D}${bindir}
  cp ${S}/wvkbd-mobintl ${D}${bindir}/
  install -D -m 0644 ${WORKDIR}/wvkbd.service ${D}${systemd_unitdir}/system/wvkbd.service
}

SYSTEMD_SERVICE:${PN} = "wvkbd.service"

FILES:${PN} = "${bindir}/wvkbd-mobintl"
