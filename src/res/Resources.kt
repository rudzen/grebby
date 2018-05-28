package res

import util.misc.PropertyLoader

import java.awt.*

class Resources {
    companion object {
        val BORDER_COLOR: Color = Color.BLUE
        const val BORDER_THICKNESS = 2
        const val LOGO = "resources/grebby/logo.gif"
        const val PROPERTY_BASENAME = "resources.grebby.lang.lang"
        private var pl: PropertyLoader? = null
        val TITLE: String
        val MENU_FILE: String
        val MENU_QUIT: String
        val MENU_HELP: String
        val SWING_FILE_LABEL: String
        val SWING_SET_FILE_BUTTONS: String
        val SWING_PATTERN_LABEL: String
        val SWING_GREP_BUTTONS: String
        val SWING_GREP_BORDER: String
        val SWING_OUTPUT_BORDER: String

        init {
            pl = PropertyLoader("resources.grebby.lang.lang")
            TITLE = pl!!.getProperty("TITLE")
            MENU_FILE = pl!!.getProperty("MENU_FILE")
            MENU_QUIT = pl!!.getProperty("MENU_QUIT")
            MENU_HELP = pl!!.getProperty("MENU_HELP")
            SWING_FILE_LABEL = pl!!.getProperty("SWING_FILE_LABEL")
            SWING_SET_FILE_BUTTONS = pl!!.getProperty("SWING_SET_FILE_BUTTONS")
            SWING_PATTERN_LABEL = pl!!.getProperty("SWING_PATTERN_LABEL")
            SWING_GREP_BUTTONS = pl!!.getProperty("SWING_GREP_BUTTONS")
            SWING_GREP_BORDER = pl!!.getProperty("SWING_GREP_BORDER")
            SWING_OUTPUT_BORDER = pl!!.getProperty("SWING_OUTPUT_BORDER")
        }
    }
}
