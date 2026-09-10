plugins {
    java
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.19"
}

group = "io.moonlightnovamc.plugin"
version = "1.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "placeholderAPI-repo"
        url = uri("https://repo.extendedclip.com/releases/")
    }
    maven {
        name = "dmulloy2"
        url = uri("https://repo.dmulloy2.net/nexus/repository/public/")
    }
}

dependencies {
    // ⭐ Paper + NMS (รองรับ NMS 1.21.4)
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")

    // PlaceholderAPI
    compileOnly("me.clip:placeholderapi:2.11.7")

    // ProtocolLib
    compileOnly("net.dmulloy2:ProtocolLib:5.4.0")
}
tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.21.4")
    }
}
tasks.assemble {
    dependsOn(tasks.reobfJar)
}
tasks.test {
    useJUnitPlatform()
}
