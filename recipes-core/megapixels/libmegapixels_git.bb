# this srcrev has no license indication, but it was
# updated in 88d3efcf87d346d9835a193fa8212bad646de99c
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://gitlab.com/megapixels-org/libmegapixels.git;branch=master;protocol=https"

DEPENDS = "libconfig"

PV = "1.0+git"
SRCREV = "6c54600fdc758636c0a88ae2dd2fcc19a6ee5f26"

S = "${WORKDIR}/git"

inherit meson pkgconfig

FILES:${PN} += "/usr/share/megapixels/config/*"
