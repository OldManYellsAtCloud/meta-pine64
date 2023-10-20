LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/SimpleLogger.git;protocol=https;branch=master"
SRCREV = "cdedf03804ded631167375e5132415caebe063be"

PR = "r01"

S = "${WORKDIR}/git"

inherit cmake
