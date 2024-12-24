LICENSE = "MIT"

inherit swupdate

SWUPDATE_IMAGES = "pinephone-image-pinephonepro-1-0.rootfs.ext4.gz fitImage update_bootargs.sh sw-description"

SWUPDATE_IMAGES_NOAPPEND_MACHINE[pinephone-image-pinephonepro-1-0.rootfs.ext4.gz] = "1"
SWUPDATE_IMAGES_NOAPPEND_MACHINE[update_bootargs.sh] = "1"

IMAGE_DEPENDS = "pinephone-image"
DEPENDS = "update-bootargs"
