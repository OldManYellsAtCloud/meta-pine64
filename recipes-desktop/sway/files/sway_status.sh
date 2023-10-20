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

connmanctl technologies > /tmp/sway_connman_text

wifi=$(grep -A4 "/net/connman/technology/wifi" /tmp/sway_connman_text | grep Connected | cut -f2 -d=)
if [[ "$wifi" == *"True"* ]]; then
  conn="W"
else
  cellular=$(grep -A4 "/net/connman/technology/cellular" /tmp/sway_connman_text | grep Connected | cut -f2 -d=)
  if [[ "$cellular" == *"True"* ]]; then
    conn="M"
  fi
fi

echo "$battery%$charging $conn $time"
