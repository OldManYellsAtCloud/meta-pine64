LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS:${PN} = "nftables"

inherit systemd
INHIBIT_DEFAULT_DEPS = "1"

PR = "r01"

S = "${UNPACKDIR}"

SRC_URI = "file://nft-rules"
SRC_URI += "file://nft-rules.service"

SYSTEMD_SERVICE:${PN} = "nft-rules.service"

do_install:append(){
  install -D -m 0744 ${UNPACKDIR}/nft-rules ${D}${bindir}/nft-rules
  install -D -m 0644 ${UNPACKDIR}/nft-rules.service ${D}${systemd_unitdir}/system/nft-rules.service
}
