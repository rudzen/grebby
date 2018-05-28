package util.swing

import javax.swing.*
import java.io.PipedOutputStream
import java.io.PrintStream

class SwingPrintStream(private val swing: JTextArea) : PrintStream(PipedOutputStream()) {

    private var lineEnd: String? = null

    init {
        this.lineEnd = "\r\n"
    }

    fun setWinLineEnd() {
        this.lineEnd = "\r\n"
    }

    fun setMacLineEnd() {
        this.lineEnd = "\r"
    }

    fun setUnixLineEnd() {
        this.lineEnd = "\n"
    }

    override fun close() {}

    override fun flush() {}

    override fun write(b: ByteArray) {
        this.swing.append(String(b))
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        this.swing.append(String(b, off, len))
    }

    override fun write(b: Int) {
        this.swing.append(java.lang.Byte.toString(b.toByte()))
    }

    override fun print(b: Boolean) {
        this.swing.append(java.lang.Boolean.toString(b))
    }

    override fun print(c: Char) {
        this.swing.append(Character.toString(c))
    }

    override fun print(s: CharArray) {
        this.swing.append(String(s))
    }

    override fun print(d: Double) {
        this.swing.append(java.lang.Double.toString(d))
    }

    override fun print(f: Float) {
        this.swing.append(java.lang.Float.toString(f))
    }

    override fun print(i: Int) {
        this.swing.append(Integer.toString(i))
    }

    override fun print(l: Long) {
        this.swing.append(java.lang.Long.toString(l))
    }

    override fun print(obj: Any?) {
        this.swing.append(obj!!.toString())
    }

    override fun print(s: String?) {
        this.swing.append(s)
    }

    override fun println() {
        this.swing.append(this.lineEnd)
    }

    override fun println(b: Boolean) {
        this.swing.append(java.lang.Boolean.toString(b))
        this.swing.append(this.lineEnd)
    }

    override fun println(c: Char) {
        this.swing.append(Character.toString(c))
        this.swing.append(this.lineEnd)
    }

    override fun println(s: CharArray) {
        this.swing.append(String(s))
        this.swing.append(this.lineEnd)
    }

    override fun println(d: Double) {
        this.swing.append(java.lang.Double.toString(d))
        this.swing.append(this.lineEnd)
    }

    override fun println(f: Float) {
        this.swing.append(java.lang.Float.toString(f))
        this.swing.append(this.lineEnd)
    }

    override fun println(i: Int) {
        this.swing.append(Integer.toString(i))
        this.swing.append(this.lineEnd)
    }

    override fun println(l: Long) {
        this.swing.append(java.lang.Long.toString(l))
        this.swing.append(this.lineEnd)
    }

    override fun println(obj: Any?) {
        this.swing.append(obj!!.toString())
        this.swing.append(this.lineEnd)
    }

    override fun println(s: String) {
        this.swing.append(s)
        this.swing.append(this.lineEnd)
    }
}
