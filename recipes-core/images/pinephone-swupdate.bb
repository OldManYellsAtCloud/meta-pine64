LICENSE = "MIT"

inherit swupdate

SWUPDATE_IMAGES:pppro = "pinephone-image-pinephonepro-1-0.rootfs.ext4.gz fitImage update_bootargs.sh sw-description"
SWUPDATE_IMAGES:pp = "pinephone-image-pinephone-1-2.rootfs.ext4.gz fitImage update_bootargs.sh sw-description"

SWUPDATE_IMAGES_NOAPPEND_MACHINE[pinephone-image-pinephonepro-1-0.rootfs.ext4.gz] = "1"
SWUPDATE_IMAGES_NOAPPEND_MACHINE[pinephone-image-pinephone-1-2.rootfs.ext4.gz] = "1"
SWUPDATE_IMAGES_NOAPPEND_MACHINE[update_bootargs.sh] = "1"

IMAGE_DEPENDS = "pinephone-image"
DEPENDS = "update-bootargs"

SRC_URI += "file://sw-description"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
LICENSE = "MIT"
