plugins {
    `java-library` // For Java-based projects
}

group = "me.yic"
version = property("revision") as String

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    // Bungeecord dependencies
    compileOnly("net.md-5:bungeecord-api:1.20-R0.1-SNAPSHOT")
    // Velocity dependency
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
    // HikariCP
    implementation("com.zaxxer:HikariCP:5.0.1")
    // Redis Jedis
    implementation("redis.clients:jedis:5.1.5")
    // Commons Pool2
    implementation("org.apache.commons:commons-pool2:2.11.1")
}