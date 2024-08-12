LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e5ed334b1d945eea01057c0950510c43"

SRC_URI = "git://github.com/OldManYellsAtCloud/hwmanager.git;protocol=https;branch=master"
SRC_URI += "file://hwmanager.service"

DEPENDS = "loglibrary settingslib sdbus-c++"

PV = "1.0+git"
SRCREV = "45ccab7d8f7f7cdf08f1f8c2b2a520e68e712449"

S = "${WORKDIR}/git"

inherit cmake systemd

do_install:append(){
    install -D -m 0644 ${WORKDIR}/hwmanager.service ${D}${systemd_unitdir}/system/hwmanager.service
}

SYSTEMD_SERVICE:${PN} = "hwmanager.service"
