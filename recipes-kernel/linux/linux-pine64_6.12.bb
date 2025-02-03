DESCRIPTION = "Mainline Linux kernel with touchscreen support for PinePhone"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${S}/COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

DEPENDS:append = " wireless-regdb "

LINUX_VERSION ?= "6.14"
LINUX_VERSION_EXTENSION = "-mainline"
KERNEL_VERSION_SANITY_SKIP="1"

BRANCH = "orange-pi-6.14"
SRCREV = "${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

# this is a regularly updated local mirror of mainline kernel, having megi's changes applied from the
# bundle published at https://xff.cz/kernels/git/orange-pi-active.bundle

do_kernel_metadata[network] = "1"

SRC_URI = "git://git@192.168.1.130/opt/kernel/mainline/linux;protocol=ssh;branch=${BRANCH} \
           file://9999-make-windows-install-NCM-drivers-automatically.patch \
          "

# file://wifi-debug.patch

SRC_URI:append:pinephone-1-2 = " file://usb_bluetooth.cfg \
                                 file://usb_wifi.cfg \
                                 file://8999-boot-with-broken-mmc-cd-pin.patch"


SRC_URI += "file://battery.cfg \
            file://debug.cfg \
            file://screen.cfg \
            file://tether.cfg \
           "

# enable_blobs.cfg

SRC_URI:append:pinephonepro-1-0 = " file://extra-ppp.cfg \
                                    file://revert-saradc-commit-that-broke-adc-keys.patch \
                                    file://0002-silence-wifi-driver.patch \
                                    file://0001-silence-rk818-battery-driver.patch \
                                    file://defconfig \
                                    file://enable_blobs.cfg"


# 9999-rk818-debug.patch

SRC_URI:append:pinephone-1-2 = " file://extra-pp.cfg "


#do_kernel_metadata:prepend(){
#	if [ "$1" != "config" ]; then
#		cd ${STAGING_KERNEL_DIR}
#		git fetch origin '+refs/remotes/megi/*:refs/remotes/megi/*'
#		git checkout megi/orange-pi-6.9
#		cd -
#	fi
#}

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

INSANE_SKIP:${PN} += " buildpaths " 
