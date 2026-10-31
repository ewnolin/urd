# 0004. Package namespace `io.github.ewnolin.urd`

- **Status:** Accepted
- **Date:** 2026-10-30
- **Issue:** #2

## Context

Java packages use a reverse domain name controlled by the author. The company does not have a
domain yet. Every GitHub account controls `<username>.github.io`, so `io.github.<username>` is a
namespace the author owns today.

## Options considered

- **`io.github.ewnolin.urd`:** owned now, no purchase needed.
- **A future company domain:** not available yet; waiting would block the project.
- **A made-up domain:** risks colliding with someone else's namespace.

## Decision

We will use `io.github.ewnolin.urd` as the base package and Gradle group, with one sub-package per
module (`io.github.ewnolin.urd.core`, `io.github.ewnolin.urd.app`).

## Consequences

- When the company owns a domain, the package can be renamed in a single, isolated refactoring pull
  request, and this ADR will be superseded.
- To keep that rename safe, fully qualified class or package names are never persisted: not in
  the database, the archive, or the input to the hash chain. Stored type information uses stable
  codes defined by the application. This rule is recorded in `CLAUDE.md` and checked in reviews.
- Architecture rules (ArchUnit) and other package references are written relative to the root
  package where possible, so there are few strings to change.
