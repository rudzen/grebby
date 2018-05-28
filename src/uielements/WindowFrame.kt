package uielements

import res.Resources
import util.swing.LookAndFeelMenu

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class GrebbyBrochure : JFrame(Resources.TITLE), ActionListener {
    private val quit: JMenuItem

    init {
        this.defaultCloseOperation = 3
        val mb = JMenuBar()
        val file = JMenu(Resources.MENU_FILE)
        this.quit = JMenuItem(Resources.MENU_QUIT)
        this.quit.addActionListener(this)
        file.add(this.quit)
        val help = JMenuItem(Resources.MENU_HELP)
        help.isEnabled = false
        help.addActionListener(this)
        mb.add(file)
        mb.add(help)
        this.jMenuBar = mb
        val panel = JPanel(BorderLayout())
        panel.add(Panel(), "Center")
        panel.add(Logo(), "Last")
        this.contentPane.add(panel)
        this.pack()
        this.setLocation(0, 0)
        this.isResizable = false

        val lfm = LookAndFeelMenu
        lfm.setDefaultSystemLookAndFeel()

    }

    override fun actionPerformed(ae: ActionEvent) {
        val o = ae.source
        if (o == this.quit) {
            System.exit(0)
        }

    }
}
