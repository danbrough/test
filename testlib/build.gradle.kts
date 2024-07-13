import org.danbrough.xtras.xtrasTesting

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  `maven-publish`

  alias(libs.plugins.xtras)
  //alias(libs.plugins.android.library)
  signing
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

xtrasTesting { }

signing{
  publishing.publications.all {
    sign(this)
  }
}