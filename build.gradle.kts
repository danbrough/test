import org.danbrough.xtras.xtrasDir
import org.danbrough.xtras.xtrasMavenDir

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


group = projectGroup
version = projectVersion


subprojects {
  group = projectGroup
  version = projectVersion

  pluginManager.apply("maven-publish")
  extensions.findByType<PublishingExtension>()?.apply {
    repositories {
      maven("https://maven.pkg.github.com/danbrough/test") {
        name = "GitHubPackages"

        credentials {
          username = System.getenv("USERNAME")
          password = System.getenv("TOKEN")
        }
      }

      maven(xtrasMavenDir){
        name = "Xtras"
      }
    }
  }
}

tasks.register("thang"){
  doFirst {
    println("XTRAS.dir = $xtrasDir")
  }
}