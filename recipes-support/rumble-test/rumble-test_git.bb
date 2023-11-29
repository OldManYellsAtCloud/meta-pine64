LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/skandigraun/rtest.git;protocol=https;branch=master"

SRCREV = "19a51201c48af6656c32f60a7a68d405d36c2c94"

PR = "r04"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"
