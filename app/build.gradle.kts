import com.android.build.api.dsl.DefaultConfig

apply(from = "config.gradle.kts")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

// Extension function to add build config fields from a map
fun com.android.build.api.dsl.DefaultConfig.addBuildConfigFields(fields: Any?) {
    fields ?: return
    val buildConfigFields = fields as Map<String, String>
    buildConfigFields.forEach { (key, value) ->
        buildConfigField("String", key, "\"$value\"")
    }
}
android {
    namespace = "com.mahbub.baseurlconfig"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mahbub.baseurlconfig"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val buildConfigFields = project.ext["buildConfigFields"]
        addBuildConfigFields(buildConfigFields)
//
//        buildConfigField ("String", "BASE_URL",project.property("BASE_URL") as String)
//        buildConfigField ("String", "STAGE_BASE_URL",project.property("STAGE_BASE_URL") as String)
//        buildConfigField ("String", "DEV_BASE_URL",project.property("STAGE_BASE_URL") as String)

    }

    buildTypes {
        debug {
//           TODO: production build config fields
        }
        release {
//           TODO: production build config fields
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        buildConfig = true
    }

}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}