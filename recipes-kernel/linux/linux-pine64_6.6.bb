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

SRC_URI = "git://git@git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;branch=${BRANCH};protocol=https \
           https://xff.cz/kernels/git/orange-pi-active.bundle;downloadfilename=megi-bundle \
           file://9999-make-windows-install-NCM-drivers-automatically.patchy \
          "

do_apply_bundle(){
  cp ${WORKDIR}/megi-bundle ${STAGING_KERNEL_DIR}/
  cd ${STAGING_KERNEL_DIR}
  git fetch megi-bundle '+refs/heads/*:refs/remotes/megi/*'
  git checkout megi/orange-pi-6.6
  for p in `ls ${WORKDIR}/*.patchy`; do
    patch -p 1 < $p
  done
  cd -
}

do_kernel_metadata:prepend(){
  cd ${STAGING_KERNEL_DIR}
  git checkout "megi/orange-pi-6.6"
  cd -
}

addtask apply_bundle after do_validate_branches before do_kernel_metadata

SRC_URI += "file://extra.cfg \
            file://battery.cfg \
            file://debug.cfg \
            file://screen_new.cfg \
            file://try.cfg \
            file://enable_blobs.cfg \
            file://bake_in_camera_driver.patchy \
            file://8999-boot-with-broken-mmc-cd-pin.patchy \
            file://tether.cfg \
           "

SRC_URI[sha256sum] = "a8a9ef20db9be7ddb80ee668d955668b80fba09b457fd5d17fdeffbd2b4d351e"

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
