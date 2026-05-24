COMPATIBLE_MACHINE:append:a64 = "|a64"
COMPATIBLE_MACHINE:append:h6 = "|h6"

inherit deploy

COMPATIBLE_MACHINE:append:pppro = "|pinephonepro-1-0"

TFA_PLATFORM:a64 = "sun50i_a64"
TFA_LTO:a64 = "1"

do_deploy(){
    cp ${B}/sun50i_a64/release/bl31.bin ${DEPLOYDIR}/bl31-sun50i_a64.bin
}

addtask deploy after do_compile
