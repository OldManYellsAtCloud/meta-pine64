DESCRIPTION = "Set basic environment variables for all profiles"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r07"

SRC_URI += "file://set-env-vars.sh"

# just copy a file, no need for a compiler
INHIBIT_DEFAULT_DEPENDENCIES = "1"

S = "${UNPACKDIR}"

do_install(){
  install -D -m0755 ${UNPACKDIR}/set-env-vars.sh ${D}${sysconfdir}/profile.d/set-env-vars.sh
}

FILES:${PN} = "${sysconfdir}/profile.d/set-env-vars.sh"

inherit allarch
