package util.swing

import javax.swing.text.AttributeSet
import javax.swing.text.BadLocationException
import javax.swing.text.PlainDocument
import java.awt.*

class LimitedPlainDocument(limit: Int) : PlainDocument() {
    private var limit: Int = 0

    init {

        if (limit >= 0) {
            this.limit = limit
        } else {
            this.limit = 0
        }

    }

    @Throws(BadLocationException::class)
    override fun insertString(offs: Int, str: String?, a: AttributeSet) {
        if (str!!.length + this.length > this.limit) {
            Toolkit.getDefaultToolkit().beep()
            super.insertString(offs, str.substring(0, this.limit - this.length), a)
        } else {
            super.insertString(offs, str, a)
        }

    }
}
