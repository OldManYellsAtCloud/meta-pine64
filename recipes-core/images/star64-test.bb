
#IMAGE_FEATURES += "ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

#IMAGE_INSTALL += " mingetty \
#                   lua \
#                   nano \
#                   firmware-blobs \
#                   strace \
#                   u-boot-fw-utils \
#"

# x11-base seems to be the way to go
EXTRA_IMAGE_FEATURES += "debug-tweaks"


