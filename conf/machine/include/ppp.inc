SOC_FAMILY = "pppro"

require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot"
#UBOOT_BINARY ?= "u-boot-sunxi-with-spl.bin"
UBOOT_BINARY ?= "u-boot.itb"
#SPL_BINARY ?= "spl/sunxi-spl.bin"
SPL_BINARY ?= "idbloader.img"
UBOOT_ENTRYPOINT = "0x40000000"
UBOOT_DTB_LOADADDRESS = "0x4FA00000"
#UBOOT_ENTRYPOINT = "0x4000"
#UBOOT_DTB_LOADADDRESS = "0x01f00000"

UBOOT_ENV ?= "boot"
#UBOOT_ENV = "uEnv"
UBOOT_ENV_SUFFIX ?= "scr"
#UBOOT_ENV_SUFFIX = "txt"

TFA_PLATFORM = "rk3399"
TFA_BUILD_TARGET = "bl31"
