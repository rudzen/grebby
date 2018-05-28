package uielements

import javax.swing.*
import java.awt.*

class Logo : JPanel(GridLayout(1, 1)) {
    init {
        val url = ClassLoader.getSystemResource("resources/grebby/logo.gif")
        val label = JLabel(ImageIcon(url))
        this.add(label)
    }
}
