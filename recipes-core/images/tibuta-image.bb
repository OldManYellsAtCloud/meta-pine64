
IMAGE_FEATURES += "splash package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image populate_sdk_qt6 grub-efi

IMAGE_INSTALL += " evtest \
                   settingslib \
                   mingetty \
                   lua \
                   mesa \
                   nano \
                   touchscreen-cal-file \
                   firmware-blobs \
                   strace \
                   buttond \
                   tzdata \
                   ttf-dejavu-sans \
                   xserver-xorg \
                   font-bh-100dpi \
                   sway \
                   libubootenv \
                   pp-systemd-conf \
                   pp-env-vars \
                   wvkbd \
                   connman-client \
                   at-spi2-atk \
                   atk \
                   foot \
                   screen \
                   wayland-utils \
                   libubootenv \
                   curl \
"

# rtl8723cs-firmware

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    xserver-xorg-extension-glx \
    my-wifi-connection \
    ntp \
    rumble-test \
    timetable \
    pipewire \
    bluealsa \
    pipewire-pulse \
    pipewire-spa-plugins-bluez5 \
    bluez5-testtools \
    bluez5-noinst-tools \
    pavucontrol \
    wireplumber \
    i2c-tools \
    htop \
    gdbserver \
    "

# to test bluetooth audio
IMAGE_INSTALL += " sox "

# x11-base seems to be the way to go
EXTRA_IMAGE_FEATURES += "debug-tweaks"


PACKAGES:${PN}:append = "tools-bluetooth"

# firefox requirement
PACKAGECONFIG:append:pn-mesa = " gallium lima kmsro"
