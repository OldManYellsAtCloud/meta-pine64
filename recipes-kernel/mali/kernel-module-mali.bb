SECTION = "core"
SUMMARY = "Mali400 Device Driver for Linux"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "virtual/kernel"

inherit module

PV = "1.0.0+git${SRCPV}"
SRCREV = "f736708fb8ad4f244778324009fc703e91487d37"

SRC_URI = "git://github.com/mripard/sunxi-mali.git;branch=master;protocol=https"
S = "${WORKDIR}/git/r6p2/src/devicedrv/mali"

EXTRA_OEMAKE += "KDIR=${STAGING_KERNEL_BUILDDIR} USING_UMP=0 BUILD=release USING_PROFILING=0 MALI_PLATFORM=sunxi USING_DVFS=1 USING_DEVFREQ=1"
MODULES_INSTALL_TARGET = "install"

do_configure:prepend() {
    cd ${WORKDIR}/git/r6p2
    quilt pop -a || true
    quilt push -a
}

do_install:append() {
    install -d ${D}${sysconfdir}/modules-load.d
    echo "blacklist lima" >> ${D}${sysconfdir}/modules-load.d/mali.conf
    echo "mali"           >> ${D}${sysconfdir}/modules-load.d/mali.conf
}
