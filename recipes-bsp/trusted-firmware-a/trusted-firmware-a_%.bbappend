COMPATIBLE_MACHINE:append:a64 = "|a64"
COMPATIBLE_MACHINE:append:h6 = "|h6"

COMPATIBLE_MACHINE:append:pppro = "|pinephonepro-1-0"

SRC_URI += "https://developer.arm.com/-/media/Files/downloads/gnu/12.2.mpacbti-rel1/binrel/arm-gnu-toolchain-12.2.mpacbti-rel1-x86_64-arm-none-eabi.tar.xz?rev=71e595a1f2b6457bab9242bc4a40db90&hash=37B0C59767BAE297AEB8967E7C54705BAE9A4B95;downloadfilename=arm-gnu-toolchain-12.2.tar.xz"
SRC_URI[sha256sum] = "17455a06c816031cc2c66243c117cba48463cd6a3a3fdfac7275b4e9c40eb314"

do_compile:prepend(){
    export PATH="${UNPACKDIR}/arm-gnu-toolchain-12.2.mpacbti-rel1-x86_64-arm-none-eabi/bin:$PATH"
}

