LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../git/wifi/settings;md5=3ebc2adb496d71d9330854946101d10e"

WIFI_ID:pinephone-1-2 = "02ba5941a055"
WIFI_ID:pinephonepro-1-0 = "b48c9d7dedd1"

SRC_URI = "git://git@192.168.1.130/opt/pine_secrets;branch=master;protocol=ssh"
SRCREV = "${AUTOREV}"

do_install(){
  install -d ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk
  install -m 0644 ${WORKDIR}/git/wifi/settings ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/
  install -m 0644 ${WORKDIR}/git/wifi/data ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/
  sed -i "s/WIFI_ID/${WIFI_ID}/g" ${D}/var/lib/connman/wifi_${WIFI_ID}_53617276617269_managed_psk/settings
}

FILES:{PN} = "/var/lib/connman/wifi_02ba5941a055_53617276617269_managed_psk/*"

PR = "02"

INHIBIT_DEFAULT_DEPS = "1"
