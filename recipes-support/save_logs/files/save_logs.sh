#!/bin/sh
DIRNAME=`date +%s`
mkdir ~/$DIRNAME
cp /var/log/* ~/$DIRNAME/
dmesg > ~/$DIRNAME/dmesg
lsmod > ~/$DIRNAME/lsmod
ps > ~/$DIRNAME/ps
journalctl > ~/$DIRNAME/journalctl
