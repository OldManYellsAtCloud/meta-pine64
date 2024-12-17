LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://source.puri.sm/Librem5/feedbackd.git;protocol=https;branch=main"
SRCREV = "b3758dee3dfefb44e8a6674410435acc6b2503af"

inherit meson pkgconfig vala

S = "${WORKDIR}/git"

EXTRA_OEMESON = "-Ddaemon=false -Dtests=false"

DEPENDS = "glib-2.0 glib-2.0-native gobject-introspection-native gobject-introspection vala-native"
RDEPENDS:${PN} = "glib-2.0 gobject-introspection"

FILES:${PN} += "/usr/share/*"
FILES:${PN} += "/usr/lib/*"
