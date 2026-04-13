plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/Sokeriaaa/SugarkaneKMP")
        credentials {
            username = project.findProperty("github.packages.username") as String?
                ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("github.packages.password") as String?
                ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.sugarkane.kelp)
    testImplementation(libs.kotlin.test)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}