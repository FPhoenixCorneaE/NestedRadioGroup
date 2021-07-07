import java.text.SimpleDateFormat
import java.util.*

/**
 * @desc：所有依赖库按照规范写在这里，用到的地方，通过 Deps 引用即可。在添加依赖之前，请检查该文件中是否已存在相
 *        同的依赖，如若已经添加相同依赖，则无需再重复添加，请注意。
 * @date：2021/1/16 19:08
 */
object Deps {

    const val applicationId = "com.fphoenixcorneae.nestedradiogroup.demo"

    object FPhoenixCorneaE {
        const val nestedRadioGroup = "com.github.FPhoenixCorneaE:NestedRadioGroup:${Versions.versionName}"
    }

    object MavenPublish {
        const val groupId = "com.github.FPhoenixCorneaE"
    }

    object GradlePlugin {
        const val gradle = "com.android.tools.build:gradle:4.2.2"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    }

    object PluginIds {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val kotlinAndroid = "android"
        const val kotlinParcelize = "kotlin-parcelize"
        const val kotlinKapt = "kapt"
    }

    object Versions {
        const val compileSdkVersion = 30
        const val buildToolsVersion = "30.0.3"
        const val minSdkVersion = 21
        const val targetSdkVersion = 30
        const val versionCode = 101
        const val versionName = "1.0.1"
        const val kotlinVersion = "1.5.10"
    }

    object BuildType {
        const val Debug = "debug"
        const val Release = "release"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    /**
     * 当前时间
     */
    fun getSystemTime(): String {
        val simpleDateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA)
        return simpleDateFormat.format(System.currentTimeMillis())
    }
}
