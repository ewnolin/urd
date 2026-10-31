# 0001. Record architecture decisions

- **Status:** Accepted
- **Date:** 2026-10-30
- **Issue:** #2

## Context

Urd is bookkeeping software that must be explainable years after it was written. BFL ch. 5 § 11
requires system documentation describing how the system is organised and how it processes
bookkeeping data. Many of the important design choices (how immutability is enforced, how money is
stored) exist precisely because of legal requirements, and the reasoning is easy to forget.

## Options considered

- **No written record:** reasons live in commit messages and memory. Cheap, but lost over time.
- **A single design document:** easy to read, but tends to be rewritten, so the history of why a
  decision changed disappears.
- **Architecture Decision Records:** one short, numbered file per decision, never rewritten.

## Decision

We will record significant decisions as ADRs in `docs/adr/`, using
[0000-template.md](0000-template.md).

- Files are numbered sequentially: `NNNN-short-title.md`.
- An ADR is written in the same pull request as the change it describes, or before it.
- An accepted ADR is never edited to change the decision. A new ADR supersedes it, and the old
  one's status is updated to point to the new one.
- If a decision serves a legal requirement, the ADR names it under *Legal basis*.

## Legal basis

Part of the system documentation required by BFL ch. 5 § 11.

## Consequences

- Decisions and their reasoning are reviewed in pull requests like code.
- The system documentation can link to ADRs instead of repeating them.
- Writing an ADR adds a little work to significant changes. "Significant" means hard to reverse,
  affecting stored data, or likely to be questioned later.
