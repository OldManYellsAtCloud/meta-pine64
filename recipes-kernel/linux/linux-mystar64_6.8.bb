DESCRIPTION = "Mainline Linux kernel with touchscreen support for PinePhone"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "6.8"
LINUX_VERSION_EXTENSION = "-mainline"
KERNEL_VERSION_SANITY_SKIP="1"


BRANCH = "master"
SRCREV = "${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

# this is a regularly updated local mirror of mainline kernel, having megi's changes applied from the
# bundle published at https://xff.cz/kernels/git/orange-pi-active.bundle

do_kernel_metadata[network] = "1"

SRC_URI = "git://git@192.168.1.130/opt/kernel/mainline/linux;protocol=ssh;branch=${BRANCH} \
           file://9999-make-windows-install-NCM-drivers-automatically.patch \
           file://star64-test-enable-usb.patch \
           file://star64-test.cfg \
          "

KCONF_AUDIT_LEVEL="1"
KCONF_BSP_AUDIT_LEVEL="5"

KBUILD_DEFCONFIG:star64-mine = "defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "star64-mine"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
