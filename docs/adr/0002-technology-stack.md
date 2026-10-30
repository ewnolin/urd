# 0002. Technology stack

- **Status:** Accepted
- **Date:** 2026-10-30
- **Issue:** #2

## Context

Urd is a single-user application with very few transactions (roughly 20–100 vouchers per year), but
with strict requirements on data integrity, traceability and long-term readability. It is also a
learning project in Java and relational database design.

## Options considered

- **Language:** Java 21 (LTS, known well, records and sealed types suit a domain model) versus
  Kotlin or a scripting language. Java keeps the focus on the domain rather than the language.
- **Framework:** Spring Boot versus plain Java with a micro-framework. Spring Boot gives web,
  validation, transactions, configuration and test support out of the box.
- **Database:** PostgreSQL versus SQLite or H2. PostgreSQL supports roles and privileges,
  triggers, exclusion constraints and range types, which are needed to enforce bookkeeping rules
  in the database itself and are worth learning properly.
- **Migrations:** Flyway (plain SQL, versioned, immutable once applied) versus Liquibase (XML/YAML
  abstraction). Plain SQL is easier to read and review.
- **Build:** Gradle with Kotlin DSL versus Maven. Gradle with a version catalog and convention
  plugins keeps a multi-module build small.
- **Tests:** JUnit 5, AssertJ and Testcontainers, so integration tests run against a real
  PostgreSQL instead of an in-memory imitation.

## Decision

We will use Java 21, the latest stable Spring Boot, Gradle with Kotlin DSL, PostgreSQL with
Flyway migrations, and JUnit 5, AssertJ and Testcontainers for tests.

## Consequences

- Rules such as "no overlapping fiscal years" or "posted vouchers are never updated" can be
  enforced by the database, not only by application code.
- Running the application and the integration tests requires Docker.
- Flyway migrations are append-only by nature, which fits the domain: an applied migration is never
  edited, a new one is added.
