import com.android.build.api.variant.BuildConfigField

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.ksp)
    id("org.jetbrains.kotlin.kapt")

}

android {
    namespace = "com.vvfy.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

androidComponents {
    onVariants(selector().withName("debug")) {
        it.buildConfigFields.put(
            "API_URL",
            BuildConfigField(
                "String", "\"https://zenquotes.io/\"", ""
            )
        )
    }
    onVariants(selector().withName("release")) {
        it.buildConfigFields.put(
            "API_URL",
            BuildConfigField(
                "String", "\"https://zenquotes.io/\"", ""
            )
        )
    }
}

dependencies {

    implementation(project(":domain"))

    implementation(libs.timber)

    //Coroutines
    implementation(libs.coroutines)

    //hilt
    implementation(libs.hilt)
    testImplementation("junit:junit:4.12")
    kapt(libs.hilt.compiler)

    //room
    ksp(libs.room.compiler)
    implementation(libs.bundles.room)

    //inject
    implementation(libs.javax.inject)

    //network
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.network)
    ksp(libs.moshi.codegen)

    //datastore
    implementation(libs.preference.datastore)

    testImplementation(libs.junit)

    //Android Junit runner
    androidTestImplementation(libs.test.runner)
    //Assertions
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.truth)
    //Kotlin coroutines testing
    androidTestImplementation(libs.coroutines.test)

    androidTestImplementation(libs.espresso.core)
}