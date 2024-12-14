DESCRIPTION = "Small offline dictionary Qt application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtwayland-native qtdeclarative qtdeclarative-native loglibrary settingslib icu"
RDEPENDS:${PN} = "qtwayland qtdeclarative"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/dictionary.git;protocol=https;branch=master;name=main \
           file://dictionary.png \
           file://dictionary.cfg \
           file://appconfig.cfg \
           git://git@192.168.1.130/opt/pine_secrets;branch=master;protocol=ssh;name=secret;destsuffix=secret \
           "

PV = "1.0+git${SRCPV}"
SRCREV_FORMAT .= "_main"
SRCREV_main = "${AUTOREV}"
SRCREV_FORMAT .= "_secret"
SRCREV_secret = "${AUTOREV}"

S = "${UNPACKDIR}/git"

inherit qt6-cmake

do_install(){
  install -d ${D}/usr/bin
  install -m 0755 ${D}/../build/appdictionary ${D}/usr/bin/dictionary

  install -d ${D}${datadir}/pixmaps
  install -m 0555 ${UNPACKDIR}/dictionary.png ${D}${datadir}/pixmaps/
  install -D -m 0555 ${UNPACKDIR}/dictionary.cfg ${D}${sysconfdir}/launcher/dictionary.cfg

  install -m 0555 ${UNPACKDIR}/appconfig.cfg ${D}${sysconfdir}/dictionary.cfg

  install -d ${D}${datadir}/dictionary
  gunzip -d -c ${UNPACKDIR}/secret/dictionary/en-de.txt.gz > ${D}${datadir}/dictionary/en-de.txt
  gunzip -d -c ${UNPACKDIR}/secret/dictionary/de-en.txt.gz > ${D}${datadir}/dictionary/de-en.txt
}

FILES:${PN} += "${datadir}/pixmaps/dictionary.png"
FILES:${PN} += "${sysconfdir}/launcher/dictionary.cfg"
FILES:${PN} += "${datadir}/dictionary/*"
FILES:${PN} += "${sysconfdir}/dictionary.cfg"
