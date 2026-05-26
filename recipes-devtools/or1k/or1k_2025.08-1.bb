SUMMARY = "or1k toolchain"
LICENSE = "GPL-2.0-only & GPL-2.0-or-later & GPL-3.0-or-later & GPL-3.0-with-GCC-exception & LGPL-3.0-or-later & MIT-advertising & Python-2.0 & pkgconf & Zlib"
LIC_FILES_CHKSUM = "file://summary.csv;md5=99c2186a0642c976e46446013e955d40"

SRC_URI = "https://toolchains.bootlin.com/downloads/releases/toolchains/openrisc/tarballs/openrisc--glibc--stable-2025.08-1.tar.xz;subdir=${BPN}"
SRC_URI[sha256sum] = "03b6e025b372970d4daf6879900b19df6fe23c9feb2c130c6743f36a48cb7d70"

inherit bin_package

INSANE_SKIP:${PN} += "already-stripped"

INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

BBCLASSEXTEND = "native nativesdk"

S = "${UNPACKDIR}/or1k/openrisc--glibc--stable-2025.08-1"

# do_install is mostly graciously stolen from meta-arm:
# https://git.yoctoproject.org/meta-arm/tree/meta-arm-toolchain/recipes-devtools/external-arm-toolchain/arm-binary-toolchain.inc
do_install() {
    cd ${S}
    ./relocate-sdk.sh __PLACEHOLDER__

    install -d ${D}${bindir} ${D}${libexecdir}/${BP}/
    cp -r ${S}/. ${D}${libexecdir}/${BP}

    # Symlink all executables into bindir
    for f in ${D}${libexecdir}/${BP}/bin/*; do
        ln -rs $f ${D}${bindir}/$(basename $f)
    done
}
