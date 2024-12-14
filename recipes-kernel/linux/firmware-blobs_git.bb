LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://megous.com/git/linux-firmware;protocol=https;subdir=${BPN};branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "0510074346983ad33b3d52ce8f5d6a8f89a564a8"

inherit bin_package

S = "${UNPACKDIR}/firmware-blobs"

INSANE_SKIP:${PN} += "already-stripped"

do_install(){
  mkdir -p ${D}${base_libdir}/firmware
  cp -r ${UNPACKDIR}/${BPN}/* ${D}${base_libdir}/firmware/

# regulatory db's are provided by other packages also
  rm ${D}${base_libdir}/firmware/regulatory.db.p7s
  rm ${D}${base_libdir}/firmware/regulatory.db

  rm -rf ${D}${base_libdir}/firmware/rtw*
  rm -rf ${D}${base_libdir}/firmware/rtl*
  rm -rf ${D}${base_libdir}/firmware/brcm/2020-02-12
}

INHIBIT_DEFAULT_DEPS = "1"
