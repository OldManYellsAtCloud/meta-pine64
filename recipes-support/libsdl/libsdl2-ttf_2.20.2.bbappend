SRCREV_FORMAT="freetype_harfbuzz_main"

SRC_URI:remove = "git://github.com/libsdl-org/SDL_ttf.git;branch=release-2.20.x;protocol=https"
SRC_URI:append = "git://github.com/libsdl-org/SDL_ttf.git;branch=release-2.20.x;protocol=https;name=main"
