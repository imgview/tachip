package eu.kanade.tachiyomi.multisrc.wpmangareader

import generator.ThemeSourceData.SingleLang
import generator.ThemeSourceGenerator

class WPMangaReaderGenerator : ThemeSourceGenerator {

    override val themePkg = "wpmangareader"

    override val themeClass = "WPMangaReader"

    override val baseVersionCode: Int = 12

    override val sources = listOf(
        // Hanya menyisakan Kiryuu
        SingleLang("Kiryuu", "https://kiryuu.id", "id", overrideVersionCode = 6)
    )

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            WPMangaReaderGenerator().createAll()
        }
    }
}
