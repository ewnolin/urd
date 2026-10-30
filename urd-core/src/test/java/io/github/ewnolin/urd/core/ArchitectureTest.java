package io.github.ewnolin.urd.core;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

/** Keeps the domain module free of framework and database dependencies. */
class ArchitectureTest {

  /** Derived from this class, so a later rename of the base package needs no change here. */
  private static final String CORE_PACKAGE = ArchitectureTest.class.getPackageName();

  private static final JavaClasses CORE_CLASSES =
      new ClassFileImporter()
          .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
          .importPackages(CORE_PACKAGE);

  @Test
  void coreDoesNotDependOnFrameworksOrDatabaseApis() {
    ArchRule rule =
        noClasses()
            .that()
            .resideInAPackage(CORE_PACKAGE + "..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage(
                "org.springframework..", "java.sql..", "javax.sql..", "jakarta.persistence..")
            .because("urd-core holds the bookkeeping rules and must stay plain Java (ADR 0006)")
            // The module has no classes until the domain model is written.
            .allowEmptyShould(true);

    rule.check(CORE_CLASSES);
  }
}
