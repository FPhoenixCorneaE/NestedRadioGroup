plugins {
    id(Deps.PluginIds.application)
    kotlin(Deps.PluginIds.kotlinAndroid)
    kotlin(Deps.PluginIds.kotlinKapt)
    id(Deps.PluginIds.kotlinParcelize)
}

android {
    compileSdkVersion(Deps.Versions.compileSdkVersion)
    buildToolsVersion(Deps.Versions.buildToolsVersion)

    defaultConfig {
        applicationId = Deps.applicationId
        minSdkVersion(Deps.Versions.minSdkVersion)
        targetSdkVersion(Deps.Versions.targetSdkVersion)
        versionCode = Deps.Versions.versionCode
        versionName = Deps.Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        ndk {
            // 设置支持的SO库架构
            abiFilters.add("armeabi-v7a")  //'armeabi', 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
        }
    }

    buildTypes {
        getByName(Deps.BuildType.Release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    packagingOptions {
        exclude("META-INF/proguard/coroutines.pro")
    }

    configurations.all {
        resolutionStrategy {
            force(Deps.Kotlin.stdlib)
        }
    }
}

// 输出文件
android.applicationVariants.all {
    // 编译类型
    val buildType = buildType.name
    outputs.all {
        // 输出 Apk
        if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
            if (buildType == Deps.BuildType.Debug) {
                this.outputFileName =
                    "${project.name}_V${android.defaultConfig.versionName}_${buildType}_${Deps.getSystemTime()}.apk"
            } else if (buildType == Deps.BuildType.Release) {
                this.outputFileName =
                    "${project.name}_V${android.defaultConfig.versionName}_${buildType}_${Deps.getSystemTime()}.apk"
            }
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(project(mapOf("path" to ":nestedRadioGroup")))
    //    implementation(Deps.FPhoenixCorneaE.nestedRadioGroup)
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitExt)
    androidTestImplementation(Deps.Test.espresso)
}