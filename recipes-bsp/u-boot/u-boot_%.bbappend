FILESEXTRAPATHS:prepend := "${THISDIR}/files:"


SRCREV = "0beb649053b86b2cfd5cf55a0fc68bc2fe91a430"

SRC_URI:append:a64 = " \
    file://boot.cmd \
    file://0002-boot-from-broken-sdcard.patch \
    file://scp.bin \
    "

SRC_URI:append:pppro = " \
    file://boot.cmd \
    "

SRC_URI:append:star64 = " \
    file://boot.cmd \
    file://0005-star64-debug.patch \
    "

DEPENDS:append:a64 = " u-boot-tools-native python3-pyelftools-native"

DEPENDS:append:pppro = "python3-pyelftools-native"

DEPENDS:append:star64 = "spl-tool-native"

ATF_DEPENDS ??= ""

EXTRA_OEMAKE:append:a64 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_a64.bin"
ATF_DEPENDS:pppro = " trusted-firmware-a:do_deploy"
# PPP
EXTRA_OEMAKE:append:pppro = " BL31=${DEPLOY_DIR_IMAGE}/bl31.elf"
ATF_DEPENDS:a64 = " trusted-firmware-a:do_deploy"

EXTRA_OEMAKE:append:h6 = " BL31=${DEPLOY_DIR_IMAGE}/bl31-sun50i_h6.bin"
ATF_DEPENDS:h6 = " trusted-firmware-a:do_deploy"

# EXTRA_OEMAKE:append:star64 = " OPENSBI=${DEPLOY_DIR_IMAGE}/fw_dynamic.bin"
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

do_compile:prepend:a64(){
    cp "${S}/../scp.bin" "${B}/scp.bin"
}

do_configure:prepend:star64(){
    mkimage -A riscv -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/boot.cmd ${WORKDIR}/boot.scr
}

do_compile:append:star64(){
    spl_tool -c -f ${B}/spl/u-boot-spl.bin
}

FILES:${PN}:append:a64 = " /boot/boot.scr"
FILES:${PN}:append:star64 = " /boot/boot.scr"

CFLAGS += " -DCONFIG_MMC_BROKEN_CD=y "

PR = "r11"
