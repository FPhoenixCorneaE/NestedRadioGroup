plugins {
    id(Deps.PluginIds.library)
    kotlin(Deps.PluginIds.kotlinAndroid)
    kotlin(Deps.PluginIds.kotlinKapt)
    `maven-publish`
}

android {
    compileSdkVersion(Deps.Versions.compileSdkVersion)
    buildToolsVersion(Deps.Versions.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Deps.Versions.minSdkVersion)
        targetSdkVersion(Deps.Versions.targetSdkVersion)
        versionCode = Deps.Versions.versionCode
        versionName = Deps.Versions.versionName

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        setConsumerProguardFiles(listOf("consumer-rules.pro"))
    }

    buildTypes {
        getByName(Deps.BuildType.Release) {
            // 执行proguard混淆
            isMinifyEnabled = false
            // 移除无用的resource文件
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName(Deps.BuildType.Debug) {
            // 执行proguard混淆
            isMinifyEnabled = false
            // 移除无用的resource文件
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        val main by getting
        main.java.srcDirs("src/main/kotlin")
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dexOptions {
        jumboMode = true
    }

    lintOptions {
        isCheckReleaseBuilds = false
        isAbortOnError = false
    }
}

dependencies {
    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    compileOnly(Deps.Kotlin.stdlib)
    compileOnly(Deps.AndroidX.appcompat)
    compileOnly(Deps.AndroidX.constraintLayout)
    // test
    testCompileOnly(Deps.Test.junit)
    androidTestCompileOnly(Deps.Test.junitExt)
    androidTestCompileOnly(Deps.Test.espresso)
}

// MavenPublication 配置-------------------------------------------------------------

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>(Deps.BuildType.Release) {
                from(components[Deps.BuildType.Release])
                groupId = Deps.MavenPublish.groupId
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
}