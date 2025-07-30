plugins {
    id("java-library")
    id("chirp.kotlin-common")
}

group = "com.plcoding"
version = "unspecified"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    api(libs.kotlin.reflect)
    api(libs.jackson.module.kotlin)

    implementation(libs.spring.boot.starter.amqp)
    implementation(libs.spring.boot.starter.security)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}