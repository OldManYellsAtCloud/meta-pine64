LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e5ed334b1d945eea01057c0950510c43"

SRC_URI = "git://github.com/OldManYellsAtCloud/hwmanager.git;protocol=https;branch=master"
SRC_URI += "file://hwmanager.service"

DEPENDS = "loglib settingslib sdbus-c++"

PV = "1.1+git"
SRCREV = "d92e0afaabc0de983182db48e2e808fa23101b44"

inherit cmake systemd

do_install:append(){
    install -D -m 0644 ${UNPACKDIR}/hwmanager.service ${D}${systemd_unitdir}/system/hwmanager.service
}

SYSTEMD_SERVICE:${PN} = "hwmanager.service"

EXTRA_OECMAKE:pinephone-1-2 = "-Dpinephone=ON"
EXTRA_OECMAKE:pinephonepro-1-0 = "-Dpinephone_pro=ON"
