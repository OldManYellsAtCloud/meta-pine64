
require pinephone-image.bb

inherit populate_sdk populate_sdk_qt6

TOOLCHAIN_TARGET_TASK:append = " googletest qtwebview qtdeclarative emailclient \
                                 wlroots wayland-protocols log loglib settingslib"

TOOLCHAIN_HOST_TASK:append = " nativesdk-loglib nativesdk-settingslib nativesdk-qtdeclarative \
                               nativesdk-log "

