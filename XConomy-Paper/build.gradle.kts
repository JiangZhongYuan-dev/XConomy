plugins {
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "me.yic"
version = property("revision") as String

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.org/repository/maven-public/")
}

dependencies {
    // Paper API dependency (provided scope in Maven)
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    // XConomy-Bukkit dependency
    implementation(project(":XConomy-Bukkit"))
    implementation(project(":XConomy-Core"))
}

tasks {
    shadowJar {
        relocate("me.yic.xc_libs.redis", "redis.clients")
        relocate("me.yic.xc_libs.pool2", "org.apache.commons")
    }
}

// Ensures the `shadowJar` task is run before build
tasks.build {
    dependsOn(tasks.shadowJar)
}
