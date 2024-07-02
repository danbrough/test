import org.danbrough.xtras.androidLibDir
import org.danbrough.xtras.capitalized
import org.danbrough.xtras.decapitalized
import org.danbrough.xtras.envLibraryPathName
import org.danbrough.xtras.konanDir
import org.danbrough.xtras.kotlinTargetName
import org.danbrough.xtras.logDebug
import org.danbrough.xtras.logError
import org.danbrough.xtras.logInfo
import org.danbrough.xtras.pathOf
import org.danbrough.xtras.supportsJNI
import org.danbrough.xtras.xtras
import org.danbrough.xtras.xtrasAndroidConfig
import org.danbrough.xtras.xtrasDeclareXtrasRepository
import org.danbrough.xtras.xtrasTesting
import org.gradle.jvm.tasks.Jar
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import org.jetbrains.kotlin.gradle.plugin.mpp.SharedLibrary
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTestRun
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompileCommon
import org.jetbrains.kotlin.gradle.tasks.KotlinNativeLink
import org.jetbrains.kotlin.konan.target.Family
import org.jetbrains.kotlin.konan.target.HostManager
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.konan.target.presetName

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  `maven-publish`

  alias(libs.plugins.xtras)
  //alias(libs.plugins.android.library)

  alias(libs.plugins.org.jetbrains.dokka)
}

kotlin {
  jvm()

  val commonMain by sourceSets.getting {
    dependencies {
      implementation(libs.klog.core)
    }
  }

  val commonTest by sourceSets.getting {
    dependencies {
      implementation(kotlin("test"))
    }
  }
}

xtrasTesting {  }