package util.swing

import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class LookAndFeelMenu(private val frame: JFrame) : JMenu("Look and Feel"), ActionListener {

    init {
        val arrayOfLookAndFeelInfos = UIManager.getInstalledLookAndFeels()

        for (lookAndFeelInfo in arrayOfLookAndFeelInfos) {
            val name = lookAndFeelInfo.name
            val item = JMenuItem(name)
            item.addActionListener(this)
            this.add(item)
        }

    }

    override fun actionPerformed(e: ActionEvent) {
        val source = e.source as JMenuItem
        val arrayOfLookAndFeelInfos = UIManager.getInstalledLookAndFeels()

        for (lookAndFeelInfo in arrayOfLookAndFeelInfos) {
            val name = lookAndFeelInfo.name
            if (source.text == name) {
                try {
                    UIManager.setLookAndFeel(lookAndFeelInfo.className)
                    SwingUtilities.updateComponentTreeUI(this.frame)
                } catch (exception: Exception) {
                    JOptionPane.showMessageDialog(null, "Look and Feel error !!!", null, 0)
                }
            }
        }

    }

    companion object {
        const val ERROR_MESSAGE = "Look and Feel error !!!"

        fun setDefaultCrossPlatformLookAndFeel() {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName())
            } catch (exception: Exception) {
                JOptionPane.showMessageDialog(null, ERROR_MESSAGE, null, 0)
            }

        }

        fun setDefaultSystemLookAndFeel() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            } catch (exception: Exception) {
                JOptionPane.showMessageDialog(null, ERROR_MESSAGE, null, 0)
            }

        }
    }
}
