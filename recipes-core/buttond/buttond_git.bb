LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=db9a68c16db2d1882b059380135f3056"


SRC_URI = "git://github.com/OldManYellsAtCloud/buttond.git;protocol=https;branch=master"
SRCREV = "f0ecfd929d84f783204e9bc4467fcf35b803fcaf"

DEPENDS += "sdbus-c++ settingslib loglibrary"
RDEPENDS:${PN} += "sdbus-c++"

SRC_URI += "file://buttond.service"
SRC_URI += "file://buttons.cfg"
SRC_URI += "file://sgy.pine.screenLock.conf"
PR = "r07"

inherit cmake systemd 

S = "${WORKDIR}/git"

SRC_URI += "file://buttond.service"

do_install:append(){
    install -D -m 0644 ${WORKDIR}/buttond.service ${D}${systemd_unitdir}/system/buttond.service
    install -D -m 0644 ${WORKDIR}/buttons.cfg ${D}${sysconfdir}/buttons.cfg
    install -D -m 0644 ${WORKDIR}/sgy.pine.screenLock.conf ${D}${sysconfdir}/dbus-1/system.d/sgy.pine.screenLock.conf
}

FILES:${PN} = "${bindir}/buttons"
FILES:${PN} += "${sysconfdir}/buttons.cfg"
FILES:${PN} += "${sysconfdir}/dbus-1/system.d/sgy.pine.screenLock.conf"

SYSTEMD_SERVICE:${PN} = "buttond.service"
