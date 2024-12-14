FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://info"

do_install:append(){
    install -d ${D}/var/lib/bluetooth/00:E0:4C:23:99:87
    install -d ${D}/var/lib/bluetooth/00:E0:4C:23:99:87/12:34:56:78:90:2D
    touch ${D}/var/lib/bluetooth/00:E0:4C:23:99:87/12:34:56:78:90:2D/attributes
    install -m 0600 ${UNPACKDIR}/info ${D}/var/lib/bluetooth/00:E0:4C:23:99:87/12:34:56:78:90:2D/info
}
