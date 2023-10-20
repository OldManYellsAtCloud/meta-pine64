DESCRIPTION = "Set basic environment variables files for Wayland"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r06"

SRC_URI += "file://set-env-vars.sh"

# just copy a file, no need for a compiler
INHIBIT_DEFAULT_DEPENDENCIES = "1"

do_install(){
  install -D -m0755 ${WORKDIR}/set-env-vars.sh ${D}${sysconfdir}/profile.d/set-env-vars.sh
}

FILES:${PN} = "${sysconfdir}/profile.d/set-env-vars.sh"

inherit allarch
