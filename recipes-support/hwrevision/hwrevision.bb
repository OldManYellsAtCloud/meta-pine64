LICENSE = "MIT"
do_install(){
  install -d ${D}${sysconfdir}
  echo -n "pppro 1.0" > ${D}${sysconfdir}/hwrevision
}
