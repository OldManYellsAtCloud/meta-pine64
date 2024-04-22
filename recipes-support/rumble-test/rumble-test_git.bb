LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/rtest.git;protocol=https;branch=master"

SRCREV = "c93a67d713b8c5b2d4b4083d1f8b7a69b0a5798a"

PR = "r05"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"
