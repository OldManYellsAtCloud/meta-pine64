
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


EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"

