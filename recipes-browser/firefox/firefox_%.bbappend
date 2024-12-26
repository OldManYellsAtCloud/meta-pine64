RDEPENDS:${PN} += "${@ 'gtk3-immodule-wayland' if 'wayland' in d.getVar('PACKAGECONFIG') and 'touchscreen' in d.getVar('MACHINE_FEATURES') else ''}"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://common \
            file://userChrome \
            file://userContent \
            file://mobile-config-autoconfig.js \
            file://mobile-config-prefs.js \
            file://policies.json \
            file://userChrome.files \
            file://userContent.files \
            file://firefox.cfg \
            file://0002-minimize-ff.patch \
           "

do_install:append(){
    mkdir -p ${D}${sysconfdir}/firefox/policies
    cp ${UNPACKDIR}/policies.json ${D}${sysconfdir}/firefox/policies/

    mkdir -p ${D}${sysconfdir}/mobile-config-firefox
    cp ${UNPACKDIR}/userChrome.files ${D}${sysconfdir}/mobile-config-firefox/
    cp ${UNPACKDIR}/userContent.files ${D}${sysconfdir}/mobile-config-firefox/
    cp -r ${UNPACKDIR}/common ${D}${sysconfdir}/mobile-config-firefox/
    cp -r ${UNPACKDIR}/userChrome ${D}${sysconfdir}/mobile-config-firefox/
    cp -r ${UNPACKDIR}/userContent ${D}${sysconfdir}/mobile-config-firefox/

    mkdir -p ${D}${libdir}/firefox/defaults/pref
    cp ${UNPACKDIR}/mobile-config-prefs.js ${D}${libdir}/firefox/defaults/pref/
    cp ${UNPACKDIR}/mobile-config-autoconfig.js ${D}${libdir}/firefox/

    mkdir -p ${D}${ROOT_HOME}/Desktop
    ln -s /usr/share/applications/mozilla-firefox.desktop ${D}${ROOT_HOME}/Desktop/Firefox

    mkdir -p ${D}${sysconfdir}/launcher
    install -m 0444 ${S}/../firefox.cfg ${D}${sysconfdir}/launcher/
}

FILES:${PN} += "${sysconfdir}/firefox/policies/*"
FILES:${PN} += "${sysconfdir}/mobile-config-firefox/*"
FILES:${PN} += "${ROOT_HOME}/Desktop/Firefox"
FILES:${PN} += "${sysconfdir}/launcher/firefox.cfg"

PACKAGECONFIG:append = " forbid-multiple-compositors openmax disable-sandboxed-libraries wayland-only"

EXTRA_OECONF:append = " --disable-backgroundtasks --disable-necko-wifi --enable-dbus --disable-printing \
                        --disable-synth-speechd --disable-webspeech --disable-webdriver --disable-accessibility \
                        --enable-mobile-optimize --disable-parental-controls --disable-legacy-profile-creation \
                        --enable-startupcache --disable-real-time-tracing --disable-webspeechtestbackend \
                        "

PACKAGECONFIG:append:armv6 = " system-libvpx system-jpeg "

PR = "r10"
