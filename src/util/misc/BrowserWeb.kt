package util.misc

import java.io.File

class BrowserWeb {
    companion object {

        fun browse(file: File) {
            val os = System.getProperty("os.name")
            val runtime = Runtime.getRuntime()
            val path = file.path

            try {
                when {
                    os == "Linux" -> runtime.exec("firefox $path")
                    os == "Mac OS X" -> runtime.exec("open -a Safari.app $path")
                    os.substring(0, 3) == "Win" -> runtime.exec("cmd.exe /C start $path")
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }

        }
    }
}
