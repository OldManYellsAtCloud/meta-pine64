EXTRA_OEMAKE += " FW_DYNAMIC=y FW_TEXT_START=0x40000000 FW_OPTIONS=0"
RISCV_SBI_PLAT = "generic"

do_compile_remove[depends] = "virtual/bootloader:do_deploy"
