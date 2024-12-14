SYSTEMD_SERVICE:${PN} = "wireplumber.service"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://wireplumber-starter.sh "

do_install:append(){
  install -m 0755 ${UNPACKDIR}/wireplumber-starter.sh ${D}${bindir}/wireplumber-starter.sh
  sed -i "s,ExecStart=/usr/bin/wireplumber,ExecStart=/usr/bin/wireplumber-starter.sh,g" ${D}${systemd_system_unitdir}/wireplumber.service
}
