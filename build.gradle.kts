plugins {
    kotlin("js") version "1.6.10"
}

group = "me.origi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.240-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.240-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.240-kotlin-1.5.30")
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            binaries.executable()
        }
    }
}