LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=70661258512e4cb104c87e6bcaa8988f"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/rtest.git;protocol=https;branch=master"

SRCREV = "25a002ef51c2043516a1e234d5c14ae514e63cf7"

inherit cmake

FILES:${PN} = "/usr/bin/rumble"

OECMAKE_GENERATOR = "Unix Makefiles"
