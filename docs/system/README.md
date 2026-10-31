# System documentation

This folder is Urd's system documentation in the sense of the Swedish Bookkeeping Act
(*bokföringslagen*, BFL ch. 5 § 11): a description of how the system is organised and how it
processes bookkeeping data, so that someone else can understand and follow the bookkeeping without
the author present.

It must be kept for as long as the bookkeeping it describes (see the archive requirements). Every
released version of this folder is preserved in Git history and in the yearly archive export.

## Contents

| Document | What it answers |
|---|---|
| [requirements-matrix.md](requirements-matrix.md) | Which legal requirements apply, and which issue and test fulfil each one |
| [glossary.md](glossary.md) | Swedish bookkeeping terms and the English names used in code |
| [../adr/](../adr/) | Why the system is built the way it is |

Planned as the epics are delivered:

- **Overview:** modules, data flow from source document to report
- **Data model:** tables, constraints and the privileges of each database role
- **Processing rules:** how vouchers are validated, numbered, posted and corrected
- **Audit trail:** what is logged, where, and how to read it (*behandlingshistorik*)
- **Archive:** formats, how to read an archive without Urd, and how restore is tested
- **Operations:** backup, upgrades and how migrations are applied

## How to read this

Start with the requirements matrix. Each row points to the issue that implemented a requirement
and to the test that proves it. The ADRs explain the reasoning behind the design.

## Maintenance

A pull request that changes how bookkeeping data is processed updates the relevant document here in
the same pull request. The PR template and the review rules in `CLAUDE.md` check this.
