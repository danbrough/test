import org.danbrough.xtras.xtrasDir

plugins {
  alias(libs.plugins.xtras) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kotlin.android) apply false

  alias(libs.plugins.org.jetbrains.dokka) apply false
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false

  alias(libs.plugins.jetbrains.compose) apply false
  alias(libs.plugins.compose.compiler) apply false
  `maven-publish`
}

val projectGroup = project.property("project.group").toString()
val projectVersion = project.property("project.version").toString()

allprojects {
  group = projectGroup
  version = projectVersion
}

subprojects {
  pluginManager.apply("maven-publish")
  extensions.findByType<PublishingExtension>()?.apply {
    repositories {
      maven("https://maven.pkg.github.com/danbrough/klog") {
        name = "GitHubPackages"

        credentials {
          username = System.getenv("USERNAME")
          password = System.getenv("TOKEN")
        }
      }
    }
  }
}

tasks.register("thang"){
  doFirst {
    println("XTRAS.dir = $xtrasDir")
  }
}