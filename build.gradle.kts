plugins {
    id("java")
    application
}
version = "Algne"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.kwhat:jnativehook:2.2.2")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("Mang")
}