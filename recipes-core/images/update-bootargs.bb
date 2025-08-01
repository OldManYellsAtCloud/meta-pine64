LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit deploy

S = "${UNPACKDIR}"

SRC_URI = "file://update_bootargs.sh file://sw-description"

do_deploy(){
  install -m 0755 ${UNPACKDIR}/update_bootargs.sh ${DEPLOYDIR}
  install -m 0555 ${UNPACKDIR}/sw-description ${DEPLOYDIR}
}

INHIBIT_DEFAULT_DEPS = "1"

addtask deploy after do_install before do_package

COMPATIBLE_MACHINE = "^pinephone.*$"
