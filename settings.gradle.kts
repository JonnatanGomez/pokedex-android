pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        // Repositorio de JetBrains Compose
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "PokeApi"
include(":app")
include(":data")
include(":domain")
