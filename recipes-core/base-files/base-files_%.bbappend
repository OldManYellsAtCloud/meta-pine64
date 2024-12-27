# mount the data partition automatically
# this could be also done in the wks file,
# however the wic modification are not present in
# the swu
do_install:append(){
  echo "/dev/mmcblk2p6	/data	ext4	defaults	0	0" >> ${D}${sysconfdir}/fstab
}
