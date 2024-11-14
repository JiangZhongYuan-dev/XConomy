plugins {
    `java-library` // For Java-based projects
}

group = "me.yic"
version = project.findProperty("revision") ?: "2.27.0" // Default to 2.26.3 if revision is not defined

subprojects {
    // Apply to all subprojects (modules)
    apply(plugin = "java")
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
    }

    group = rootProject.group
    version = rootProject.version

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }
}

val revision: String by project

ext {
    set("revision", "2.27")
}
