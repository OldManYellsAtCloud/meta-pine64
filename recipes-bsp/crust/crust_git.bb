LICENSE = "BSD-3-Clause | GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=067c70adcecb42b71c442bd4bcde626c"

SRC_URI = "git://github.com/crust-firmware/crust;branch=master;protocol=https"

inherit deploy or1k

PV = "1.0+git"
SRCREV = "499a362645e6ce6ac1fd8ea8d0f25d4df6690688"

DEPENDS = "flex-native ncurses bison-native"

do_configure () {
	oe_runmake pinephone_defconfig CC='${CC}' HOSTCC='${BUILD_CC}' LEX=flex
}

do_compile () {
	oe_runmake CROSS_COMPILE="or1k-linux-" HOST_COMPILE="aarch64-oe-linux-" build/scp/scp.bin
}

do_install[noexec] = "1"

do_deploy() {
	# this is used in the u-boot recipe, to include it in the final bootloader
	install -m 0644 ${S}/build/scp/scp.bin ${DEPLOYDIR}/
}

addtask deploy after do_compile before do_build

COMPATIBLE_MACHINE = "pinephone-1-2"
