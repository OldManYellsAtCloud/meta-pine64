DESCRIPTION = "Mainline Linux kernel with touchscreen support for PinePhone"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "6.9"
LINUX_VERSION_EXTENSION = "-mainline"
KERNEL_VERSION_SANITY_SKIP="1"


BRANCH = "orange-pi-${LINUX_VERSION}"
SRCREV = "${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

# this is a regularly updated local mirror of mainline kernel, having megi's changes applied from the
# bundle published at https://xff.cz/kernels/git/orange-pi-active.bundle

do_kernel_metadata[network] = "1"

SRC_URI = "git://git@192.168.1.130/opt/kernel/mainline/linux;protocol=ssh;branch=${BRANCH} \
           file://9999-make-windows-install-NCM-drivers-automatically.patch \
           file://0003-fix-serial-com.patch \
           file://0004-rk818-fix-unsupported-behavior-spam.patch \
          "

# file://wifi-debug.patch

SRC_URI:append:pinephone-1-2 = " file://usb_bluetooth.cfg \
                                 file://usb_wifi.cfg \
                                 file://8999-boot-with-broken-mmc-cd-pin.patch"


SRC_URI += "file://battery.cfg \
            file://debug.cfg \
            file://screen.cfg \
            file://enable_blobs.cfg \
            file://tether.cfg \
           "

SRC_URI:append:pinephonepro-1-0 = " file://0001-silence-rk818-battery-driver.patch \
                                    file://extra-ppp.cfg \
                                    file://revert-saradc-commit-that-broke-adc-keys.patch \
                                    file://0002-silence-wifi-driver.patch \
                                    file://9999-rk818-debug.patch \
                                    file://defconfig"

SRC_URI:append:pinephone-1-2 = " file://extra-pp.cfg "

KCONF_AUDIT_LEVEL="1"
KCONF_BSP_AUDIT_LEVEL="5"

KBUILD_DEFCONFIG:sopine-a64 = "defconfig"
KBUILD_DEFCONFIG:pine-a64-lts = "defconfig"
KBUILD_DEFCONFIG:pine-a64-plus = "defconfig"
KBUILD_DEFCONFIG:pinephone-1-2 = "pinephone_defconfig"
# KBUILD_DEFCONFIG:pinephonepro-1-0 = "pinephone_pro_defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "pine-a64-lts|sopine-a64|pine-a64-plus|pinephone-1-2|pinephonepro-1-0"

# This is necessary since kmeta would be necessary otherwise
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
