FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:a64 = " \
    file://boot.cmd \
    file://0002-boot-from-broken-sdcard.patch \
    file://scp.bin \
    "

SRC_URI:append:pppro = " \
    file://9999-store-uboot-on-mmc.cfg \
    file://sidebutton.cfg \
    file://enable-cat.cfg \
    file://init_env.cfg \
    file://0001-add-extra-u-boot-env-vars.patch \
    "

SRC_URI:append:star64-mine = " \
    file://boot.cmd \
    file://test_config.cfg \
    "

SRC_URI:append:tibuta = " file://tibuta.cfg "

DEPENDS:append:a64 = " u-boot-tools-native python3-pyelftools-native"

DEPENDS:append:pppro = "python3-pyelftools-native vim-native u-boot-tools-native"

DEPENDS:append:star64-mine = " spl-tool-native "

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
ATF_DEPENDS:pppro = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:pppro = " BL31=${DEPLOY_DIR_IMAGE}/bl31-rk3399.elf"
ATF_DEPENDS:a64 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
ATF_DEPENDS:h6 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:star64-mine = " OPENSBI=${DEPLOY_DIR_IMAGE}/fw_dynamic.bin"

do_compile[depends] .= "${ATF_DEPENDS}"

do_configure:prepend:a64() {
    mkimage -A arm -O linux -T script -C none -n "U-Boot boot script" \
        -d ${UNPACKDIR}/boot.cmd ${UNPACKDIR}/boot.scr
}

do_compile:prepend:a64(){
    cp "${S}/../scp.bin" "${B}/scp.bin"
}

do_compile:append:star64-mine(){
    spl_tool -c -f ${B}/spl/u-boot-spl.bin
}

FILES:${PN}:append:a64 = " /boot/boot.scr"
FILES:${PN}:append:star64-mine = " /boot/boot.scr"

CFLAGS += " -DCONFIG_MMC_BROKEN_CD=y "

PR = "r18"
