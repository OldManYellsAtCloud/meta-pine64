LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=db9a68c16db2d1882b059380135f3056"


SRC_URI = "git://github.com/skandigraun/buttond.git;protocol=https;branch=master"
SRCREV = "40fad99be87cf7d5c17b85e8747634cd657d1483"

DEPENDS += "sdbus-c++"
RDEPENDS:${PN} += "sdbus-c++"

SRC_URI += "file://buttond.service"

PR = "r05"

inherit cmake systemd 

S = "${WORKDIR}/git"

SRC_URI += "file://buttond.service"

do_install:append(){
    install -D -m 0644 ${WORKDIR}/buttond.service ${D}${systemd_unitdir}/system/buttond.service
}

FILES:${PN} = "/usr/bin/buttons"

SYSTEMD_SERVICE:${PN} = "buttond.service"
