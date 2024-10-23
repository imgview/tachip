include(":core")

include(":lib-ratelimit")
project(":lib-ratelimit").projectDir = File("lib/ratelimit")

include(":lib-dataimage")
project(":lib-dataimage").projectDir = File("lib/dataimage")

if (System.getenv("CI") == null) {
    // Pengembangan lokal (build penuh proyek)

    include(":multisrc")
    project(":multisrc").projectDir = File("multisrc")

    // Hanya memuat Kiryuu dari multisrc
    val name = "kiryuu"
    val lang = "wpmangareader"
    val projectName = ":extensions:multisrc:$lang:$name"

    include(projectName)
    project(projectName).projectDir = File("multisrc/overrides/$lang/$name")

} else {
    // Menjalankan di CI (GitHub Actions)

    val isMultisrc = System.getenv("CI_MULTISRC") == "true"
    val lang = System.getenv("CI_MATRIX_LANG")

    if (isMultisrc && lang == "wpmangareader") {
        include(":multisrc")
        project(":multisrc").projectDir = File("multisrc")

        // Hanya memuat Kiryuu dari multisrc dalam CI
        val name = "kiryuu"
        val projectName = ":extensions:multisrc:$lang:$name"

        include(projectName)
        project(projectName).projectDir = File("multisrc/overrides/$lang/$name")
    }
}

inline fun File.eachDir(block: (File) -> Unit) {
    listFiles()?.filter { it.isDirectory }?.forEach { block(it) }
}
