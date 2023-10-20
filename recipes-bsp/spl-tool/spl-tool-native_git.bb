LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6dc25dc2418b8831c906d43809d8336"

SRC_URI = "git://github.com/starfive-tech/Tools.git;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "6067c32c4cc11749a503b0708d98d6d45022cc0c"

S = "${WORKDIR}/git/spl_tool"

do_configure () {
	:
}

do_compile () {
    oe_runmake
}

do_install () {
    install -D -m 0755 ${S}/spl_tool ${D}${bindir}/spl_tool
}

inherit native
