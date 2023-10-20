
IMAGE_FEATURES += "package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image populate_sdk_qt6

IMAGE_INSTALL += " evtest \
                   mingetty \
                   lua \
                   mesa \
                   nano \
                   touchscreen-cal-file \
                   firmware-blobs \
                   strace \
"

# rtl8723cs-firmware

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    xserver-xorg-extension-glx \
    ntp \
    htop \
    "


# x11-base seems to be the way to go
EXTRA_IMAGE_FEATURES += "debug-tweaks"


PACKAGES:${PN}:append = "tools-bluetooth"

# firefox requirement
PACKAGECONFIG:append:pn-mesa = " gallium lima kmsro"
