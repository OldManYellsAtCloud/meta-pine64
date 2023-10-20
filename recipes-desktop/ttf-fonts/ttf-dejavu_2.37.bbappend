# QT applications are looking for fonts in /usr/lib/fonts folder

do_install:append(){
  mkdir -p ${D}/usr/lib
  ln -s /usr/share/fonts/truetype ${D}/usr/lib/fonts
}

FILES:${PN}-sans += "/usr/lib/fonts"
