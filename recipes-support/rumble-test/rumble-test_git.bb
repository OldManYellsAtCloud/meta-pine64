LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/rtest.git;protocol=https;branch=master"

SRCREV = "7c6e46d0db732afc74d628db2bdc9c4e0912b53a"

PR = "r05"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"

OECMAKE_GENERATOR = "Unix Makefiles"
