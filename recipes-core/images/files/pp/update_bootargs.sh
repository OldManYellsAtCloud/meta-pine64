#!/bin/sh

system_partition=`cat /proc/cmdline | tr ' ' '\n' | grep root | grep -o [0-9]$`
if [ $system_partition -eq 3 ]; then
  new_system_partition=5
  new_boot_partition=2
elif [ $system_partition -eq 5 ]; then
  new_system_partition=3
  new_boot_partition=1
else
  echo $system_partition is not a valid system partition!
  exit 1
fi

fw_setenv bootpart $new_boot_partition
fw_setenv bootargs "console=ttyS2,115200 root=/dev/mmcblk2p$new_system_partition rw earlyprintk=serial,ttyS2,11520"
