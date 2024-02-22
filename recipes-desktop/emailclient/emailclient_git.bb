LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db9a68c16db2d1882b059380135f3056"

DEPENDS = "qtwayland qtdeclarative-native qtwebengine qtwebview settingslib loglibrary curl"
RDEPENDS:${PN} = "qtwayland"

SRC_URI = "git://git@github.com/OldManYellsAtCloud/emailclient;protocol=https;branch=master \
           file://mail.png \
           git://git@192.168.1.130/opt/pine_secrets;branch=master;name=secrets;destsuffix=secrets;protocol=ssh"

# Modify these as desired
PV = "1.0+git"
SRCREV = "92eb4d5925dcb9ae7a27872e9155815a9cc70270"
SRCREV_FORMAT .= "_secret"
SRCREV_secrets = "${AUTOREV}"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: Qt6 GTest
inherit qt6-cmake

do_install:append(){
  install -D -m 0644 ${S}/../secrets/emailclient/emailclient.cfg ${D}${sysconfdir}/launcher/emailclient.cfg
  install -D -m 0644 ${S}/../mail.png ${D}${datadir}/pixmaps/mail.png
}

