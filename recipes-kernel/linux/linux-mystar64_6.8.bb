DESCRIPTION = "Mainline Linux kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

require recipes-kernel/linux/linux-yocto.inc
inherit externalsrc

LINUX_VERSION ?= "6.14"
LINUX_VERSION_EXTENSION = "-mainline"
KERNEL_VERSION_SANITY_SKIP = "1"

PR = "r06"

PV = "${LINUX_VERSION}"

SRC_URI = "file://9999-make-windows-install-NCM-drivers-automatically.patch \
           file://star64-test-enable-usb.patch \
           file://star64-test.cfg \
          "

#FILESEXTRAPATHS:prepend := "${THISDIR}/dts:"

#SRC_URI += "file://star64-v1.1.dts;subdir=arch/riscv/boot/dts/starfive \
#            file://star64-v1.1.dtsi;subdir=arch/riscv/boot/dts/starfive "


KCONF_AUDIT_LEVEL = "2"
KCONF_BSP_AUDIT_LEVEL = "5"

KBUILD_DEFCONFIG:star64-mine = "defconfig"
KCONFIG_MODE = "--alldefconfig"

COMPATIBLE_MACHINE = "star64-mine"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"

EXTERNALSRC = "/yocto/star64-kernel-src"
