PIPEWIRE_SESSION_MANAGER = "wireplumber"
SYSTEMD_SERVICE:${PN} += " pipewire-pulse.service "

do_install:append(){
    sed -i "/ConditionUser=!root/d" ${D}${systemd_user_unitdir}/pipewire-pulse.service
    sed -i "/Type=simple/a\Environment=XDG_RUNTIME_DIR=/var/run/wayland" ${D}${systemd_user_unitdir}/pipewire-pulse.service
    mv ${D}${systemd_user_unitdir}/pipewire-pulse.* ${D}${systemd_system_unitdir}/
}
