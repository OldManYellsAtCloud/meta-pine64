PR = "r03"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://foot.cfg \
            file://terminal.png \
            file://0001-increase-font-size.patch"


do_install:append(){
  install -D -m 0555 ${S}/../foot.cfg ${D}${sysconfdir}/launcher/foot.cfg
  install -D -m 0555 ${S}/../terminal.png ${D}${datadir}/pixmaps/terminal.png
}


FILES:${PN} += "${sysconfdir}/launcher/foot.cfg"
FILES:${PN} += "${datadir}/pixmaps/terminal.png"
