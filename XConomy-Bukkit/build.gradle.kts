plugins {
    id("java")
    id("maven-publish")
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "me.yic"
version = property("revision") as String

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.glaremasters.me/repository/towny/")
}

dependencies {
    // Paper API dependency (provided scope in Maven)
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")// Provided scope in Maven is mapped to implementation here
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("me.clip:placeholderapi:2.11.5")
    implementation("org.bstats:bstats-bukkit:3.0.2")
    compileOnly("com.github.the-h-team:Enterprise:1.7")
    compileOnly("com.palmergames.bukkit.towny:towny:0.98.2.0")
    implementation(project(":XConomy-Core"))
    implementation("com.saicone.ezlib:ezlib:1.3.0")
}

tasks {
    shadowJar {
        relocate("com.saicone.ezlib", "me.yic.xc_libs.ezlib")
        relocate("org.bstats", "me.yic.xc_libs.bstats")
        relocate("com.zaxxer", "me.yic.xc_libs.zaxxer")
        relocate("redis.clients", "me.yic.xc_libs.redis")
        relocate("org.apache.commons", "me.yic.xc_libs.pool2")
    }
}

tasks.build {
    dependsOn(tasks.shadowJar)
}