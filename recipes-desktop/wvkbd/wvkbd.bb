DESCRIPTION = "Virtual keyboard for wayland"

S = "${WORKDIR}/git"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

PR = "r16"

PROVIDES += "wvkbd"

DEPENDS = "cairo pango wayland libxkbcommon wayland-native wayland-protocols"

SRC_URI = "git://github.com/OldManYellsAtCloud/wvkbd.git;protocol=https;branch=react-on-text-input"
SRC_URI += "file://wvkbd.service"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit pkgconfig systemd

RUMBLE_PATH:pinephone-1-2 = "/dev/input/event2"
RUMBLE_PATH:pinephonepro-1-0 = "/dev/input/event0"
RUMBLE_PATH ?= ""

do_compile(){
  cd ${S}
  oe_runmake
}

do_install(){
  mkdir -p ${D}${bindir}
  cp ${S}/wvkbd-mobintl ${D}${bindir}/
  install -D -m 0644 ${WORKDIR}/wvkbd.service ${D}${systemd_unitdir}/system/wvkbd.service
  sed -i "s,RUMBLE_PATH,${RUMBLE_PATH},g" ${D}${systemd_unitdir}/system/wvkbd.service
}

SYSTEMD_SERVICE:${PN} = "wvkbd.service"

FILES:${PN} = "${bindir}/wvkbd-mobintl"
