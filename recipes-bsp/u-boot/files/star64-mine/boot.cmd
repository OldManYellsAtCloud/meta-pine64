setenv bootargs console=ttyS0,115200 earlyprintk=serial,0xff1a0000,115200 root=/dev/mmcblk1p4 rootwait printk.time=1 rfkill.default_state=1

fatload mmc 1:3 $ramdisk_addr_r fitImage

bootm $ramdisk_addr_r
