PACKAGECONFIG:append:h6 = " panfrost"

PACKAGECONFIG:append:pppro = " panfrost tools" 
PACKAGECONFIG:append:pinephone-1-2 = " lima glvnd va gallium-llvm "

EXTRA_OEMESON:append:star64 = "-Dvulkan-drivers=imagination-experimental -Dimagination-srv=true -Dgallium-drivers=zink"

TOOLS:append:star64 = ",imagination"
FILES:${PN}:star64 += "/usr/lib/libpowervr_rogue.so"

SRC_URI:append = " file://0001-panfrost-add-stub-methods-to-report-EGL-1.5-conforma.patch"

# GALLIUMDRIVERS:append:pp = ",lima"
VULKAN_DRIVERS:pppro = "panfrost"
VULKAN_DRIVERS:pinephone-1-2 = "swrast"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

