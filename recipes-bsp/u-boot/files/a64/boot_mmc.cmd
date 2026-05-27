setenv bootargs console=ttyS0,115200 earlyprintk=ttyS0 root=/dev/mmcblk2p2 rootwait printk.time=1 rfkill.default_state=1

fatload mmc 1 $ramdisk_addr_r fitImage

bootm $ramdisk_addr_r
