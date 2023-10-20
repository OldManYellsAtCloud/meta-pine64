FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://ntp-pp.conf"

do_install:append(){
  install -m 0644 ${WORKDIR}/ntp-pp.conf ${D}/etc/ntp.conf
  sed -i "s~ntp:ntp~ntp:ntp -g~g" ${D}${sysconfdir}/init.d/ntpd
}
