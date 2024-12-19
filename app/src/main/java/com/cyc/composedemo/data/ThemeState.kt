package com.cyc.composedemo.data

data class ThemeState(
    var mode: Mode = Mode.Light,
    var pallet: ColorPallet = ColorPallet.BAMBOO
) {
    enum class Mode {
        Light, Dark
    }

    enum class ColorPallet(val value: String) {
        CYAN("CYAN"),
        BAMBOO("BAMBOO"),
        DAWN("DAWN"),
        BLUE("BLUE"),
        VIOLET("VIOLET")
    }
}
