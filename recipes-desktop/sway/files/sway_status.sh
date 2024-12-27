#!/bin/sh
time=$(date +%H:%M)
# the battery has different names in the two pinephones
battery=$(cat /sys/class/power_supply/*-battery/capacity)
status=$(cat /sys/class/power_supply/*-battery/status)

if [ $battery -lt 10 -a "$status" != "Charging" ]; then
  battery="<span foreground=\"red\">$battery</span>"
fi

if [[ "$status" == "Charging" ]]; then
  charging="↑"
fi

if [ -e /tmp/unreadMailFlag ]; then
  mail="<span foreground=\"GreenYellow\" size=\"10800\">✉</span>"
fi

conn=""

su root -c "iwctl station wlan0 show" | grep connected | grep -v disconnected > /dev/null
if [ $? -eq 0 ]; then
  conn="W"
fi

su root -c "qmi-network /dev/cdc-wdm0 status" | grep Status | grep disconnected > /dev/null

# dbus-send --system --dest=org.gspine.modem --type=method_call --print-reply /org/gspine/modem org.gspine.modem.pd.get_connection_details string:"internet" 2>/dev/null| grep internet
if [ $? -eq 1 ]; then
  conn=${conn}M
fi

echo "$mail $battery%$charging $conn $time"
