FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV = "0beb649053b86b2cfd5cf55a0fc68bc2fe91a430"
#SRC_URI = "git://git@github.com/Tow-Boot/U-Boot.git;branch=tow-boot/2022.07/board-pine64-pinephonePro;protocol=https"
#SRCREV = "ad8bc2f4f579aa23ee7c3791c1710a8da80b13fd"

SRC_URI:append:a64 = " \
    file://boot.cmd \
    file://0002-boot-from-broken-sdcard.patch \
    file://scp.bin \
    "

SRC_URI:append:pinephonepro-1-0 = " \
    file://boot.cmd \
    file://0004-initramfs-for-ppp.patch \
    file://9999-store-uboot-on-mmc.cfg \
    file://sidebutton.cfg \
    "

# bbb.patch
# aaa.patch
# 0001-pine64-pinephonepro-device-enablement_v2.patch

SRC_URI:append:star64 = " \
    file://boot.cmd \
    file://0005-star64-debug.patch \
    "

DEPENDS:append:a64 = " u-boot-tools-native python3-pyelftools-native"

DEPENDS:append:pppro = "python3-pyelftools-native vim-native u-boot-tools-native"

DEPENDS:append:star64 = " spl-tool-native "

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
ATF_DEPENDS:pppro = " trusted-firmware-a:do_deploy"
# PPP
EXTRA_OEMAKE:append:pppro = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
ATF_DEPENDS:a64 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
ATF_DEPENDS:h6 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:star64 = " OPENSBI=${DEPLOY_DIR_IMAGE}/fw_dynamic.bin"
# ATF_DEPENDS:star64 = " opensbi:do_deploy"

do_compile[depends] .= "${ATF_DEPENDS}"

do_configure:prepend:a64() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.cmd ${WORKDIR}/boot.scr
}

do_configure:prepend:pppro() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.cmd ${WORKDIR}/boot.scr
}

do_compile:append:pppro(){
    sed -i "s/baudrate=1500000/baudrate=115200/g" ${B}/u-boot-initial-env
    echo "bootargs=console=ttyS2,115200 earlyprintk=serial,0xff1a0000,115200 root=/dev/mmcblk1p2 rw printk.time=1 rfkill.default_state=1" >> ${B}/u-boot-initial-env
    echo "bootdelay=0" >> ${B}/u-boot-initial-env
}

do_compile:prepend:a64(){
    cp "${S}/../scp.bin" "${B}/scp.bin"
}

do_configure:prepend:star64(){
    mkimage -A riscv -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/uEnv.txt.orig ${WORKDIR}/uEnv.txt
}

do_compile:append:star64(){
    spl_tool -c -f ${B}/spl/u-boot-spl.bin
}

FILES:${PN}:append:a64 = " /boot/boot.scr"
FILES:${PN}:append:star64 = " /boot/boot.scr"
FILES:${PN}:append:pinephonepro-1-0 = "/boot/boot.scr"

CFLAGS += " -DCONFIG_MMC_BROKEN_CD=y "

PR = "r16"
