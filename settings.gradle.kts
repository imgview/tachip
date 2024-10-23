include(":core")

include(":lib-ratelimit")
project(":lib-ratelimit").projectDir = File("lib/ratelimit")

include(":lib-dataimage")
project(":lib-dataimage").projectDir = File("lib/dataimage")

if (System.getenv("CI") == null) {
    // Local development (full project build)

    include(":multisrc")
    project(":multisrc").projectDir = File("multisrc")

    // Hanya memuat Kuryuu
    include(":extensions:individual:id:kiryuu")
    project(":extensions:individual:id:kiryuu").projectDir = File("src/id/kiryuu")
} else {
    // Running in CI (GitHub Actions)

    val lang = System.getenv("CI_MATRIX_LANG")

    // Hanya memuat Kuryuu untuk CI
    if (lang == "id") {
        include(":extensions:individual:id:kiryuu")
        project(":extensions:individual:id:kiryuu").projectDir = File("src/id/kiryuu")
    }
}

// Fungsi tambahan untuk mengiterasi direktori
inline fun File.eachDir(block: (File) -> Unit) {
    listFiles()?.filter { it.isDirectory }?.forEach { block(it) }
}
