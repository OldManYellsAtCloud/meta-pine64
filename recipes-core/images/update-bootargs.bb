LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${UNPACKDIR}/update_bootargs.sh;md5=0a38f4d14de6989d36e0405a7555644e"

inherit deploy

S = "${UNPACKDIR}"

SRC_URI = "file://update_bootargs.sh file://sw-description"

do_deploy(){
  install -m 0755 ${UNPACKDIR}/update_bootargs.sh ${DEPLOYDIR}
  install -m 0555 ${UNPACKDIR}/sw-description ${DEPLOYDIR}
}

INHIBIT_DEFAULT_DEPS = "1"

addtask deploy after do_install before do_package
