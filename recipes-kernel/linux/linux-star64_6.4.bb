DESCRIPTION = "Mainline Linux kernel with touchscreen support for PinePhone"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "5.15.115"
LINUX_VERSION_EXTENSION = "-borged"
KERNEL_VERSION_SANITY_SKIP="1"


BRANCH = "Star64_devel"
SRCREV = "${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://git@github.com/Fishwaldo/Star64_linux.git;branch=${BRANCH};protocol=https \
          "

KCONF_AUDIT_LEVEL="1"
KCONF_BSP_AUDIT_LEVEL="5"

KBUILD_DEFCONFIG:star64 = "pine64_star64_defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "star64"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
# INITRAMFS_IMAGE = "core-image-minimal-initramfs"
