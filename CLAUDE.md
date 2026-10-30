# Urd – instructions for Claude

## Project
Urd is bookkeeping software for one small Swedish aktiebolag, built to comply with the Swedish
Bookkeeping Act (BFL). It is a learning project in Java and database design that is also used for
real bookkeeping, so correctness and traceability matter more than features.

Modules:
- `urd-core` – pure Java domain model and rules. No Spring, no `java.sql`. Enforced by ArchUnit.
- `urd-app` – Spring Boot application: database access, Flyway migrations, web UI.

## How the owner wants help
The owner writes the domain code himself. Claude acts as guide and project manager: it sets up
tooling, CI and issues, explains design choices, and reviews. Do not write domain logic, schema
design or migrations unless explicitly asked; explain and point instead.

## Conventions
- Java 21, Spring Boot, Gradle Kotlin DSL, PostgreSQL with Flyway
- Data access with `JdbcClient` and explicit SQL; no JPA (see ADRs)
- Money is `long` öre (`bigint` in the database), never `double`; rounding happens explicitly
- Code, comments, docs, issues and commits in English; the UI is Swedish (default) and English
- Branches `<type>/<issue>-<description>`, Conventional Commits, squash merge
- ADRs in `docs/adr`, CHANGELOG under `Unreleased` for every user-visible change
- Never persist fully qualified Java class or package names (in the database, archive or hash
  input), so the base package can be renamed later without breaking stored data

## When reviewing a PR, flag

**Bookkeeping integrity (highest priority)**
- Any `UPDATE`, `DELETE` or `TRUNCATE` against posted vouchers, voucher lines, the audit log or
  attachments, in code or migrations
- Privileges granted to `urd_app` beyond what the feature needs
- Changes to an already-applied Flyway migration (migrations are immutable; add a new one)
- Gaps or reuse possible in voucher numbering per fiscal year
- Voucher validation that can be bypassed (debit ≠ credit, posting into a closed fiscal year)
- `double`/`float` for money, implicit rounding, unchecked `long` overflow (`Math.addExact`)
- Missing audit trail entry for a state change

**Code conventions**
- Spring or `java.sql` imports in `urd-core`
- Field `@Autowired`, business logic in controllers
- Swallowed exceptions, broad `catch (Exception e)`, returning `null`
- Mutable DTOs instead of `record`; status values as strings instead of enums
- UI text hard-coded instead of message keys in both `messages_sv` and `messages_en`

**Tests and docs**
- New or changed logic without tests, especially failure cases
- Schema changes without an explanation of the design in the PR
- Legal requirements without an update to `docs/system/requirements-matrix.md`
- Behaviour changes without a CHANGELOG entry
- TODOs without an issue number; commented-out code

## Do not flag
- Style nits that do not affect correctness or readability
- Missing features that are tracked in other issues
