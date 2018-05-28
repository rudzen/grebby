package util.misc

import java.util.Locale
import java.util.ResourceBundle

class PropertyLoader {
    private var locale: Locale? = null
    private var properties: ResourceBundle? = null

    constructor(basename: String) {
        this.locale = Locale.getDefault()
        this.properties = ResourceBundle.getBundle(basename, this.locale!!)
    }

    constructor(basename: String, language: String, country: String) {
        this.locale = Locale(language, country)
        this.properties = ResourceBundle.getBundle(basename, this.locale!!)
    }

    fun getProperty(property: String): String {
        return this.properties!!.getString(property)
    }
}
