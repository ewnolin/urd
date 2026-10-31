# 0003. License

- **Status:** Accepted
- **Date:** 2026-10-30
- **Issue:** #2

## Context

The source code is public. Others may want to read it, learn from it or adapt it for their own
company. Because it handles bookkeeping, it must be clear that it comes without any guarantee of
legal compliance.

## Options considered

- **MIT:** short, permissive, widely understood, includes a warranty disclaimer.
- **Apache 2.0:** permissive with an explicit patent grant; more text than this project needs.
- **GPL:** forces derivatives to stay open, which is not a goal here.

## Decision

We will license Urd under the MIT License. The README additionally states that Urd is not certified
bookkeeping software and that nothing in the repository is legal advice.

## Consequences

- Anyone can use and modify the code, including commercially.
- Third-party data with its own terms is not automatically covered. In particular, the full BAS
  chart of accounts must not be committed until its license terms have been checked (see the chart
  of accounts import issue).
- Real bookkeeping data never belongs in the repository; `.gitignore` excludes common data and SIE
  file patterns.
