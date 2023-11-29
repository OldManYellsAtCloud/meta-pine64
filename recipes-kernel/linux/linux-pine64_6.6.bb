DESCRIPTION = "Mainline Linux kernel with touchscreen support for PinePhone"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "6.6"
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
          "


SRC_URI += "file://extra.cfg \
            file://battery.cfg \
            file://debug.cfg \
            file://screen_new.cfg \
            file://try.cfg \
            file://enable_blobs.cfg \
            file://bake_in_camera_driver.patch \
            file://8999-boot-with-broken-mmc-cd-pin.patch \
            file://tether.cfg \
            file://0001-silence-rk818-battery-driver.patch \
           "

do_kernel_metadata:prepend(){
	if [ "$1" != "config" ]; then
		cd ${STAGING_KERNEL_DIR}
		git fetch origin '+refs/remotes/megi/*:refs/remotes/megi/*'
		git checkout megi/orange-pi-6.6
		cd -
	fi
}

KCONF_AUDIT_LEVEL="1"
KCONF_BSP_AUDIT_LEVEL="5"

KBUILD_DEFCONFIG:sopine-a64 = "defconfig"
KBUILD_DEFCONFIG:pine-a64-lts = "defconfig"
KBUILD_DEFCONFIG:pine-a64-plus = "defconfig"
KBUILD_DEFCONFIG:pinephone-1-2 = "pinephone_defconfig"
KBUILD_DEFCONFIG:pinephonepro-1-0 = "pinephone_pro_defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64|pine-a64-plus|pinephone-1-2|pinephonepro-1-0"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
