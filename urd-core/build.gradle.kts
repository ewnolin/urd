// Pure Java domain model. Must never depend on Spring or java.sql (see ArchitectureTest).
plugins {
  id("urd.java-conventions")
}

dependencies {
  testImplementation(platform(libs.junit.bom))
  testImplementation(libs.junit.jupiter)
  testImplementation(libs.assertj.core)
  testImplementation(libs.archunit)
  testRuntimeOnly(libs.junit.platform.launcher)
}
