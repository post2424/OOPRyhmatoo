plugins {
    id("java")
    application // Add the application plugin
}
version = "Algne"

repositories {
    mavenCentral()
    allprojects {
        repositories {
            maven { url = uri("https://jitpack.io") }

        }
    }
}

dependencies {
    implementation("com.github.kwhat:jnativehook:2.2.2")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("Mang") // Replace with the fully qualified name of your main class
}