group = "com.ccfraser.muirwik"
version = "0.6.5"
description = "Starter Application for Muirwik (a Material UI React wrapper written in Kotlin)"

plugins {
    kotlin("js") version "1.4.20"
}

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
//    mavenLocal()
}

dependencies {
    val kotlinVersion = "1.4.20"
    val muirwikComponentVersion = "0.6.5"
    val kotlinJsVersion = "pre.129-kotlin-$kotlinVersion"

    implementation(kotlin("stdlib-js", kotlinVersion))
    implementation("org.jetbrains", "kotlin-styled", "5.2.0-$kotlinJsVersion")
    implementation(npm("react-hot-loader", "^4.13.0"))
    implementation ("org.jetbrains:kotlin-react:17.0.1-pre.148-kotlin-1.4.21")
    //implementation("org.jetbrains", "kotlin-react-dom", kotlinReactVersion)
    implementation("com.ccfraser.muirwik:muirwik-components:$muirwikComponentVersion")

    implementation(npm("@material-ui/core", "^4.11.3"))
    implementation(npm("@material-ui/lab", "4.0.0-alpha.56"))
    implementation(npm("@material-ui/icons", "^4.11.2"))
}

kotlin {
    js(LEGACY) {
        useCommonJs()
        browser {
            //binaries.executable()
            commonWebpackConfig {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        binaries.executable()
    }
}
