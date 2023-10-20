LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/skandigraun/rtest.git;protocol=https;branch=master"
SRCREV = "e9cdef367c614cefb167e1c43408a7ab9316925b"

PR = "r02"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"
