LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=db9a68c16db2d1882b059380135f3056"


SRC_URI = "git://github.com/OldManYellsAtCloud/buttond.git;protocol=https;branch=master"
SRCREV = "70a583cfe68b0e36102d792392aa03ee9a2218b5"

DEPENDS += "sdbus-c++ settingslib loglibrary"
RDEPENDS:${PN} += "sdbus-c++"

SRC_URI += "file://buttond.service"
SRC_URI += "file://buttons.cfg"
PR = "r05"

inherit cmake systemd 

S = "${WORKDIR}/git"

SRC_URI += "file://buttond.service"

do_install:append(){
    install -D -m 0644 ${WORKDIR}/buttond.service ${D}${systemd_unitdir}/system/buttond.service
    install -D -m 0644 ${WORKDIR}/buttons.cfg ${D}${sysconfdir}/buttons.cfg
}

FILES:${PN} = "${bindir}/buttons"
FILES:${PN} += "${sysconfdir}/buttons.cfg"

SYSTEMD_SERVICE:${PN} = "buttond.service"
