setenv bootargs console=ttyS0,115200 earlyprintk=serial,0xff1a0000,115200 root=/dev/mmcblk1p2 rootwait printk.time=1 rfkill.default_state=1

fatload mmc 1 $ramdisk_addr_r fitImage

bootm $ramdisk_addr_r