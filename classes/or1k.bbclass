DEPENDS:append = " or1k-native"

do_relocate_sdk(){
	cd ${RECIPE_SYSROOT_NATIVE}/usr/libexec/or1k-2025.08-1
	./relocate-sdk.sh
}

addtask relocate_sdk after do_patch before do_configure
