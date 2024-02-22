LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/touchDirection.git;protocol=ssh;branch=master"
SRC_URI += "file://touch-gesture.service"
SRC_URI += "file://org.gspine.gesture.conf"

PV = "1.0+git${SRCPV}"
SRCREV = "b25ac0042b5f88755c818e6adf666da68204bcf7"

DEPENDS = "sdbus-c++ loglibrary"
RDEPENDS:${PN} = "sdbus-c++"

S = "${WORKDIR}/git"

inherit cmake systemd

do_install:append(){
    install -D -m 0644 ${WORKDIR}/touch-gesture.service ${D}${systemd_unitdir}/system/touch-gesture.service
    install -D -m 0644 ${WORKDIR}/org.gspine.gesture.conf ${D}${sysconfdir}/dbus-1/system.d/org.gspine.gesture.conf
}

SYSTEMD_SERVICE:${PN} = "touch-gesture.service"
