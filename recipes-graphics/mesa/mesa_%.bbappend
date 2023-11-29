PACKAGECONFIG:append:h6 = " kmsro panfrost"

EXTRA_OEMESON:append:star64 = "-Dvulkan-drivers=imagination-experimental -Dimagination-srv=true -Dgallium-drivers=zink"

TOOLS:append:star64 = ",imagination"
FILES:${PN}:star64 += "/usr/lib/libpowervr_rogue.so"
GALLIUMDRIVERS:append:pinephonepro-1-0 = ",zink,panfrost"
