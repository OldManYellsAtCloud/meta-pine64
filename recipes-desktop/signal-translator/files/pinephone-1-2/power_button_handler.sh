#!/bin/sh

go_down(){
	# disable touchscreen
	echo 1 > `ls /sys/devices/platform/ff130000.i2c/i2c-3/3-0014/input/input*/inhibited` &
	# turn off backlight and screen
	echo 4 > /sys/class/backlight/backlight/bl_power &
	echo 4 > /sys/devices/platform/display-subsystem/graphics/fb0/blank &
	# turn off most of CPU cores
	echo powersave > /sys/devices/system/cpu/cpufreq/policy0/scaling_governor &
	echo powersave > /sys/devices/system/cpu/cpufreq/policy4/scaling_governor &
	echo 0 > /sys/devices/system/cpu/cpu1/online &
	echo 0 > /sys/devices/system/cpu/cpu2/online &
	echo 0 > /sys/devices/system/cpu/cpu3/online &
	echo 0 > /sys/devices/system/cpu/cpu4/online &
	echo 0 > /sys/devices/system/cpu/cpu5/online &
	# send a signal about going down
	dbus-send --system --dest=org.gspine.display --type=signal /org/gspine/display org.gspine.display.screenOff boolean:true &
	# switch modem to low power mode
	dbus-send --system --dest=sgy.pine.modem --type=method_call --print-reply=literal /sgy/pine/modem sgy.pine.modem.enable_low_power string:1
}

bring_up(){
	# enable touchscreen
	echo 0 > `ls /sys/devices/platform/ff130000.i2c/i2c-3/3-0014/input/input*/inhibited` &
	# turn on backlight and screen
	echo 0 > /sys/class/backlight/backlight/bl_power &
	echo 0 > /sys/devices/platform/display-subsystem/graphics/fb0/blank &
	# turn on the CPU cores
	echo 1 > /sys/devices/system/cpu/cpu1/online
	echo 1 > /sys/devices/system/cpu/cpu2/online
	echo 1 > /sys/devices/system/cpu/cpu3/online
	echo 1 > /sys/devices/system/cpu/cpu4/online
	echo 1 > /sys/devices/system/cpu/cpu5/online
	# change governor back only once all cores are back up
	echo performance > /sys/devices/system/cpu/cpufreq/policy0/scaling_governor &
	echo performance > /sys/devices/system/cpu/cpufreq/policy4/scaling_governor &
	# send a signal about coming back up
	dbus-send --system --dest=org.gspine.display --type=signal /org/gspine/display org.gspine.display.screenOff boolean:false &
	# bring back the modem from low power mode
	dbus-send --system --dest=sgy.pine.modem --type=method_call --print-reply=literal /sgy/pine/modem sgy.pine.modem.enable_low_power string:0
}

#check if touchscreen is enabled, and infer the current state of it

CURRENT_STATUS=`cat /sys/devices/platform/ff130000.i2c/i2c-3/3-0014/input/input*/inhibited`

if [ $CURRENT_STATUS -eq 0 ]; then
	go_down
else
	bring_up
fi
