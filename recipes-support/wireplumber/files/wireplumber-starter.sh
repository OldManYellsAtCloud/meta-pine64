#!/bin/sh
export $(/usr/bin/dbus-launch | grep DBUS_SESSION_BUS_ADDRESS)
/usr/bin/wireplumber
