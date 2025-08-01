# actually this installs my wifi passwords, which is not exactly
# a state secret, but still, not really MIT.
LICENSE = "CLOSED"

SRC_URI = "git://git@192.168.1.130/opt/pine_secrets;branch=master;protocol=ssh"
SRCREV = "${AUTOREV}"

do_install(){
    install -D -m 0755 -t ${D}${localstatedir}/lib/iwd/ ${S}/wifi/*psk
}

FILES:{PN} = "${localstatedir}/lib/iwd/*psk"

PR = "03"

INHIBIT_DEFAULT_DEPS = "1"
