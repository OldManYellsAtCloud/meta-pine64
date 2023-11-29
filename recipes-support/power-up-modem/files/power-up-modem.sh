#!/bin/sh

PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
DESC="Power up PinePhone modem"

set -e

case "$1" in
  start)
        echo -n "Starting $DESC: "
        cd /sys/devices/platform

        for i in `seq 10`; do
          if [ -z "$(find . -name powered_blocking)" ]; then
             if [ $i -eq 10 ]; then
               echo "powered_blocking file does not exist, can't power up modem"
               exit 1
             else
               usleep 500000
             fi
          else
             break;
          fi
        done
        sleep 2
        echo 1 > $(find . -name powered_blocking)
        ;;
  stop)
        echo -n "Stopping $DESC: "
        cd /sys/devices/platform
        echo 0 > $(find . -name powered_blocking)
        ;;
  restart|force-reload)
        echo -n "Restarting $DESC: "
        cd /sys/devices/platform
        echo 0 > $(find . -name powered_blocking)
        sleep 1
        echo 1 > $(find . -name powered_blocking)
        ;;
  *)
        N=/etc/init.d/$0
        echo "Usage: $N {start|stop|restart|force-reload}" >&2
        exit 1
        ;;
esac

exit 0
