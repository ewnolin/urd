// Shared configuration for every Java module in Urd.
plugins {
  java
  jacoco
}

group = "io.github.ewnolin.urd"
version = "0.1.0-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
  options.compilerArgs.addAll(listOf("-Xlint:all", "-Xlint:-processing", "-parameters"))
}

tasks.test {
  useJUnitPlatform()
  finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
  reports {
    xml.required = true
    html.required = true
  }
}
