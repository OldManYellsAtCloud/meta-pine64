
IMAGE_FEATURES += "splash package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image populate_sdk_qt6

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
                   enable-wireless \
                   touch-gesture \
                   launcher \
                   connman-client \
                   at-spi2-atk \
                   atk \
                   megapixels \
                   signal-translator \
                   foot \
                   screen \
                   wayland-utils \
                   libubootenv \
                   curl \
                   rsync \
                   nft-rules \
                   save-logs \
                   emailclient \
                   screenlock \
                   udev-rules \
                   dictionary \
                   modemmanager-ng \
                   pin-enter \
                   shutdown-led-indicator \
                   kernel-module-cryptosk \
"

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    xserver-xorg-extension-glx \
    my-wifi-connection \
    ntp \
    rumble-test \
    timetable \
    firefox \
    mpd \
    mpc \
    mpv \
    pipewire \
    bluealsa \
    pipewire-pulse \
    pipewire-spa-plugins-bluez5 \
    bluez5-testtools \
    bluez5-noinst-tools \
    pavucontrol \
    wireplumber \
    i2c-tools \
    power-up-modem \
    htop \
    gdbserver \
    "

IMAGE_INSTALL:remove:star64 = "firmware-blobs touchscreen-cal-file \
                               buttond touch-gesture info-panel \
                               power-up-modem eg25manager wvkbd \
                               signal-translator timetable \
                               megapixels launcher"

IMAGE_INSTALL:append:star64 = "jh7110-gpu-blob"

# to test bluetooth audio
IMAGE_INSTALL += " sox "

# x11-base seems to be the way to go
EXTRA_IMAGE_FEATURES += "debug-tweaks"


PACKAGES:${PN}:append = "tools-bluetooth"

# firefox requirement
PACKAGECONFIG:append:pn-mesa = " gallium lima kmsro"

TOOLCHAIN_TARGET_TASK:append = " googletest qtwebview"
TOOLCHAIN_HOST_TASK:append = " nativesdk-loglibrary nativesdk-settingslib "
