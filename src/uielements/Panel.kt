package uielements

import res.Resources
import util.swing.SwingPrintStream

import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintStream
import javax.swing.BorderFactory
import javax.swing.Box
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.JTextField

class Panel : JPanel(), ActionListener {
    private val fileText: JTextField
    private val fileButton: JButton
    private val patternText: JTextField
    private val grepButton: JButton
    private val psArea: JTextArea
    private val ps: PrintStream

    init {
        val fileLabel = JLabel(Resources.SWING_FILE_LABEL)
        this.fileText = JTextField(null as String?, 24)
        this.fileText.isEditable = false
        this.fileButton = JButton(Resources.SWING_SET_FILE_BUTTONS)
        this.fileButton.addActionListener(this)
        val filePanel = JPanel(FlowLayout(0))
        filePanel.add(fileLabel)
        filePanel.add(this.fileText)
        filePanel.add(this.fileButton)
        val patternLabel = JLabel(Resources.SWING_PATTERN_LABEL)
        this.patternText = JTextField(null as String?, 24)
        this.grepButton = JButton(Resources.SWING_GREP_BUTTONS)
        this.grepButton.addActionListener(this)

        val grepPanel = JPanel(FlowLayout(0))
        grepPanel.add(patternLabel)
        grepPanel.add(this.patternText)
        grepPanel.add(this.grepButton)
        grepPanel.border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Resources.BORDER_COLOR, 2), Resources.SWING_GREP_BORDER)

        this.psArea = JTextArea(10, 40)
        this.psArea.isEditable = false
        this.ps = SwingPrintStream(this.psArea)

        val psScroll = JScrollPane(this.psArea)
        psScroll.horizontalScrollBarPolicy = 32
        psScroll.verticalScrollBarPolicy = 22
        psScroll.border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Resources.BORDER_COLOR, 2), Resources.SWING_OUTPUT_BORDER)

        val b = Box(1)
        b.add(filePanel)
        b.add(grepPanel)
        b.add(psScroll)
        this.add(b)
    }

    override fun actionPerformed(ae: ActionEvent) {
        val o = ae.source
        if (o == this.fileButton) {
            val fc = JFileChooser()
            fc.fileSelectionMode = 0
            fc.isFileHidingEnabled = true
            fc.isMultiSelectionEnabled = false
            if (fc.showOpenDialog(this) == 0) {
                this.fileText.text = fc.selectedFile.path
            }
        }

        if (o == this.grepButton) {
            this.psArea.text = null
            val pattern = this.patternText.text
            val file = this.fileText.text
            var command = arrayOf("grep", "-F", pattern, file)
            if (pattern == null || pattern.isEmpty()) {
                command = arrayOf("cat", file)
            }

            if (file != null && file.isNotEmpty()) {
                try {
                    for (aCommand in command) {
                        print("$aCommand ")
                    }

                    println()
                    val runtime = Runtime.getRuntime()
                    val p = runtime.exec(command)
                    val input = BufferedReader(InputStreamReader(p.inputStream))

                    var s: String
                    while (true) {
                        s = input.readLine()
                        if (s == null)
                            break
                        this.ps.println(s)
                    }

                    input.close()
                } catch (var10: Exception) {
                    var10.printStackTrace()
                }

            }
        }

    }
}
