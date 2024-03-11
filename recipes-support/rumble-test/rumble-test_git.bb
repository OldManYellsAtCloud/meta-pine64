LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/skandigraun/rtest.git;protocol=https;branch=master"

SRCREV = "e2572d9f03fceb76776b5aa523d1db1ee6796f7f"

PR = "r04"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"
