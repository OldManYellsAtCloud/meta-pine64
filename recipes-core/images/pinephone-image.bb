
IMAGE_FEATURES += "splash package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

# populate_sdk populate_sdk_qt6

IMAGE_INSTALL += " evtest \
                   settingslib \
                   mingetty \
                   lua \
                   mesa \
                   nano \
                   touchscreen-cal-file \
                   firmware-blobs \
                   strace \
                   tzdata \
                   ttf-dejavu-sans \
                   font-bh-100dpi \
                   sway \
                   libubootenv \
                   pp-systemd-conf \
                   pp-env-vars \
                   wvkbd \
                   enable-wireless \
                   launcher \
                   at-spi2-atk \
                   atk \
                   signal-translator \
                   foot \
                   screen \
                   wayland-utils \
                   libubootenv \
                   curl \
                   rsync \
                   nft-rules \
                   save-logs \
                   screenlock \
                   udev-rules \
                   dictionary \
                   modemmanager-ng \
                   pin-enter \
                   shutdown-led-indicator \
                   mpv \
                   megapixels \
                   mesa-demos \
                   hwmanager \
                   iwd \
                   firefox \
                   emailclient \
                   libubootenv-bin \
                   util-linux-lsblk \
                   e2fsprogs-resize2fs \
                   e2fsprogs-tune2fs \
                   dosfstools \
                   swupdate \
                   swupdate-www \
                   swupdate-progress \
                   hwrevision \
                   libqmi \
"

IMAGE_INSTALL += "\
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    mesa-demos \
    xserver-xorg-extension-glx \
    xserver-xorg \
    my-wifi-connection \
    ntp \
    rumble-test \
    timetable \
    mpd \
    mpc \
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

EXTRA_IMAGE_FEATURES += " allow-empty-password empty-root-password allow-root-login post-install-logging "

PACKAGES:${PN}:append = "tools-bluetooth"

IMAGE_OVERHEAD_FACTOR = "3"

fix_fstab(){
  echo "/dev/mmcblk2p6 /data ext4 defaults" >> ${IMAGE_ROOTFS}${sysconfdir}/fstab
}

ROOTFS_POSTPROCESS_COMMAND += "fix_fstab"
