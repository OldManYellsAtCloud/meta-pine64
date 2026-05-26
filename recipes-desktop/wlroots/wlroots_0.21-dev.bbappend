SRC_URI += "file://0001-fix-text-input-displaying.patch"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append(){
	# remove tinywl
	rm -rf ${D}${bindir}
}
