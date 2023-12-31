# python 3.12 (which is used by Fedora) dropped the "imp" module,
# making the version of Jack in Yocto fail to compile
SRC_URI = "git://github.com/jackaudio/jack2.git;branch=develop;protocol=https"
SRCREV = "250420381b1a6974798939ad7104ab1a4b9a9994"

LIC_FILES_CHKSUM = " \
    file://common/jack/control.h;beginline=2;endline=21;md5=9edb8b99b7a0dcd49dbf8741444f123d \
    file://common/jack/jack.h;beginline=1;endline=19;md5=6b736ed6b810592b135480a5e853392e \
"
