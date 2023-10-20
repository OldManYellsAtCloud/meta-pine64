#!/bin/sh

PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
DESC="Power up PinePhone modem"

set -e

case "$1" in
  start)
        echo -n "Starting $DESC: "

        for i in `seq 10`; do
          if [ ! -e /sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking ]; then
             if [ $i -eq 10 ]; then
               echo "/sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking file does not exist, can't power up modem"
               exit 1
             else
               usleep 500000
             fi
          else
             break;
          fi
        done

        echo 1 > /sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking
        ;;
  stop)
        echo -n "Stopping $DESC: "
        echo 0 > /sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking
        ;;
  restart|force-reload)
        echo -n "Restarting $DESC: "
        echo 0 > /sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking
        sleep 1
        echo 1 > /sys/devices/platform/soc/1c28c00.serial/serial1/serial1-0/powered_blocking
        ;;
  *)
        N=/etc/init.d/$0
        echo "Usage: $N {start|stop|restart|force-reload}" >&2
        exit 1
        ;;
esac

exit 0
