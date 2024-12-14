LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e5ed334b1d945eea01057c0950510c43"

DEPENDS = "qtwayland qtdeclarative-native qtwebengine qtwebview settingslib loglibrary curl qtdeclarative"
RDEPENDS:${PN} = "qtwayland qtwebview"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/emailclient-ng;protocol=https;branch=master \
           file://mail.png \
           file://email.cfg \
           git://git@192.168.1.130/opt/pine_secrets;branch=master;name=secrets;destsuffix=secrets;protocol=ssh"

PV = "1.2+${SRCPV}"
SRCREV = "e6d2e423a66638bf0d61e0ec7a0f0bd569de7c7d"
SRCREV_FORMAT .= "_secret"
SRCREV_secrets = "${AUTOREV}"

S = "${UNPACKDIR}/git"

inherit qt6-cmake

do_install:append(){
  mv ${D}${bindir}/appemailclient ${D}${bindir}/emailclient
  install -D -m 0644 ${S}/../email.cfg ${D}${sysconfdir}/launcher/email.cfg
  install -D -m 0644 ${S}/../mail.png ${D}${datadir}/pixmaps/mail.png
  install -D -m 0644 ${S}/../secrets/emailclient/emailclient.cfg ${D}${sysconfdir}/emailclient.cfg
}

FILES:${PN} += "${bindir}/emailclient"
