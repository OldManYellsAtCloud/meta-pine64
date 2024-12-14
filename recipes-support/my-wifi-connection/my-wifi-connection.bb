LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

WIFI_ID:pinephone-1-2 = "02ba5941a055"
WIFI_ID:pinephonepro-1-0 = "b48c9d7dedd1"

SRC_URI = "git://git@192.168.1.130/opt/pine_secrets;branch=master;protocol=ssh"
SRCREV = "${AUTOREV}"

S = "${UNPACKDIR}/git"

do_install(){
  install -d ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk
  install -m 0644 ${UNPACKDIR}/git/wifi/wifi-old/settings ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/
  install -m 0644 ${UNPACKDIR}/git/wifi/wifi-old/data ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/
  sed -i "s/WIFI_ID/${WIFI_ID}/g" ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/settings
}

do_install:pppro(){
  install -d ${D}/var/lib/connman/wifi_${WIFI_ID}_5361727661726935_managed_psk
  install -m 0644 ${UNPACKDIR}/git/wifi/wifi5/settings ${D}/var/lib/connman/wifi_${WIFI_ID}_5361727661726935_managed_psk/
  install -m 0644 ${UNPACKDIR}/git/wifi/wifi5/data ${D}/var/lib/connman/wifi_${WIFI_ID}_5361727661726935_managed_psk/
  sed -i "s/WIFI_ID/${WIFI_ID}/g" ${D}/var/lib/connman/wifi_${WIFI_ID}_5361727661726935_managed_psk/settings
}


FILES:{PN} = "/var/lib/connman/wifi_02ba5941a055_53617276617269_managed_psk/*"
FILES:{PN}:pppro = "/var/lib/connman/wifi_02ba5941a055_5361727661726935_managed_psk/*"

PR = "02"

INHIBIT_DEFAULT_DEPS = "1"
