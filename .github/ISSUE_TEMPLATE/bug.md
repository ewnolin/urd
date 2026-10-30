---
name: Bug
about: Something behaves differently from what it should.
title: ""
labels: ["bug"]
---

## What happened
<!-- Steps to reproduce, what you expected and what you got. -->

1.
2.

**Expected:**

**Actual:**

## Could this have produced incorrect bookkeeping?
<!-- Wrong amounts, missing or duplicated vouchers, broken numbering, lost attachments, missing
     audit entries, or data that changed when it should not. If yes or unsure: add the `integrity`
     label and list the affected fiscal years and voucher numbers. -->
- [ ] No
- [ ] Yes or unsure → `integrity`

## Environment
<!-- Version or commit, browser if relevant. Never paste real bookkeeping data or personal data. -->

## Fix checklist
- [ ] Regression test that fails before the fix
- [ ] If bookkeeping was affected: corrected with correction vouchers, never by editing data
- [ ] CHANGELOG entry under `Unreleased` → `Fixed`
