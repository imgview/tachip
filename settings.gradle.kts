include(":core")

include(":lib-ratelimit")
project(":lib-ratelimit").projectDir = File("lib/ratelimit")

include(":lib-dataimage")
project(":lib-dataimage").projectDir = File("lib/dataimage")

if (System.getenv("CI") == null) {
    // Local development (full project build)

    include(":multisrc")
    project(":multisrc").projectDir = File("multisrc")

    // Memuat hanya Kiryuu dari multisrc
    val kiryuuPath = "multisrc/overrides/wpmangareader/kiryuu"
    include(":kiryuu")
    project(":kiryuu").projectDir = File(kiryuuPath)

} else {
    // Running in CI (GitHub Actions)

    val isMultisrc = System.getenv("CI_MULTISRC") == "true"
    val lang = System.getenv("CI_MATRIX_LANG")

    if (isMultisrc && lang == "wpmangareader") {
        include(":multisrc")
        project(":multisrc").projectDir = File("multisrc")

        // Memuat Kiryuu dari multisrc dalam CI
        val kiryuuPath = "multisrc/overrides/wpmangareader/kiryuu"
        include(":kiryuu")
        project(":kiryuu").projectDir = File(kiryuuPath)
    }
}
