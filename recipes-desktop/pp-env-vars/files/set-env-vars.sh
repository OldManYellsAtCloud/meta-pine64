#!/bin/sh
export XDG_RUNTIME_DIR=/var/run/wayland
export WAYLAND_DISPLAY=wayland-1
export SWAYSOCK=$(ls $XDG_RUNTIME_DIR/sway-ipc*.sock | head -n 1)
export $(dbus-launch | grep DBUS_SESSION_BUS_ADDRESS)
export QT_QPA_PLATFORM=wayland
export LANG=C.UTF-8
