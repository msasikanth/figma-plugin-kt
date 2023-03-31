plugins {
    kotlin("js") version "1.8.0"
}

group = "dev.sasikanth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



kotlin {
    js {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}
