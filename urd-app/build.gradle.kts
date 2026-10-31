import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
  id("urd.java-conventions")
  alias(libs.plugins.spring.boot)
}

dependencies {
  implementation(project(":urd-core"))

  implementation(platform(SpringBootPlugin.BOM_COORDINATES))
  implementation("org.springframework.boot:spring-boot-starter-webmvc")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-validation")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
