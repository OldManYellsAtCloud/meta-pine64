LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/kgmt0/megapixels.git;protocol=https;branch=master \
           file://megapixels.cfg \
           file://megapixels.png"

SRCREV = "8103e662a484c0887d29f11a1284f85ff34d0248"

inherit meson pkgconfig vala

S = "${WORKDIR}/git"

do_install:append(){
    install -D -m 0555 ${S}/../megapixels.png ${D}${datadir}/pixmaps/megapixels.png
    install -D -m 0555 ${S}/../megapixels.cfg ${D}${sysconfdir}/launcher/megapixels.cfg
}

RDEPENDS:${PN} = "gtk4"
DEPENDS = "gtk4 libfeedback zbar libxml2-native"

FILES:${PN} += "${datadir}/*"
FILES:${PN} += "${sysconfdir}/launcher/megapixels.cfg"

PR = "r03"
