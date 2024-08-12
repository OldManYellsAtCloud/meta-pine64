LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=db9a68c16db2d1882b059380135f3056"


SRC_URI = "git://github.com/OldManYellsAtCloud/buttond.git;protocol=https;branch=master"
SRCREV = "9da829b135d0ab98517741ac25e0c22cce875bd9"

DEPENDS += "sdbus-c++ settingslib loglibrary"
RDEPENDS:${PN} += "sdbus-c++"

SRC_URI += "file://buttond.service"
SRC_URI += "file://buttons.cfg"
SRC_URI += "file://org.gspine.button.conf"
PR = "r07"

inherit cmake systemd 

S = "${WORKDIR}/git"

SRC_URI += "file://buttond.service"

do_install:append(){
    install -D -m 0644 ${WORKDIR}/buttond.service ${D}${systemd_unitdir}/system/buttond.service
    install -D -m 0644 ${WORKDIR}/buttons.cfg ${D}${sysconfdir}/buttons.cfg
    install -D -m 0644 ${WORKDIR}/org.gspine.button.conf ${D}${sysconfdir}/dbus-1/system.d/org.gspine.button.conf
}

FILES:${PN} = "${bindir}/buttons"
FILES:${PN} += "${sysconfdir}/buttons.cfg"
FILES:${PN} += "${sysconfdir}/dbus-1/system.d/org.gspine.button.conf"

SYSTEMD_SERVICE:${PN} = "buttond.service"

COMPATIBLE_MACHINE = "^(pp|pppro|pinephone-1-2|pinephonepro-1-0)$"
