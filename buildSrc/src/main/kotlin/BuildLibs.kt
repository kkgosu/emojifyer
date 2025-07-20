object BuildLibs {
    val versionName = "1.7.3"
    private val versionCodeBase = 173
    val versionCodeMobile = versionCodeBase + 3

    const val COMPILE_SDK = 36
    const val TARGET_SDK = 36
    const val MIN_SDK = 21

    const val GRADLE_PLUGIN = "com.android.tools.build:gradle:8.11.1"
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20"
    const val RELEASE_HUB_PLUGIN = "com.dipien.releaseshub.gradle.plugin"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.56.2"
}
