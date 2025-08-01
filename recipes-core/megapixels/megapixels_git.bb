LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://gitlab.com/megapixels-org/Megapixels.git;protocol=https;branch=master \
           file://megapixels.cfg \
           file://megapixels.png"

SRCREV = "46ada9c17f5475626d11fdab4818be5a3499b90b"

inherit meson pkgconfig vala

do_install:append(){
    install -D -m 0555 ${UNPACKDIR}/megapixels.png ${D}${datadir}/pixmaps/megapixels.png
    install -D -m 0555 ${UNPACKDIR}/megapixels.cfg ${D}${sysconfdir}/launcher/megapixels.cfg
}

RDEPENDS:${PN} = "gtk4"
DEPENDS = "gtk4 libfeedback zbar libxml2-native libmegapixels libdng"

FILES:${PN} += "${datadir}/*"
FILES:${PN} += "${sysconfdir}/launcher/megapixels.cfg"

PR = "r03"
