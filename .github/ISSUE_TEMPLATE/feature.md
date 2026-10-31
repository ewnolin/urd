---
name: Feature
about: One testable piece of work. One issue, one branch, one pull request.
title: ""
labels: ["feature"]
---

## Summary
<!-- What should exist when this is done, and why. One short paragraph. -->

**Module:** <!-- core / app / formats / docs / infra -->

## Legal basis
<!-- The BFL paragraph or BFN guidance this implements, and its row in docs/system/requirements-matrix.md.
     Write "None" if this is not a legal requirement. If it is, add the `legal` label. -->

## Acceptance criteria
<!-- Observable behaviour or tests someone else can verify. Include at least one failure case. -->
- [ ]
- [ ]

## Out of scope
<!-- What this issue deliberately does not do, and where it is handled instead. Delete if empty. -->

## Schema change
<!-- No / Yes. If yes, the PR must explain the design: keys, types, constraints, privileges. -->

## Definition of Done
- [ ] All acceptance criteria met
- [ ] Tests cover new logic, including failure cases
- [ ] CHANGELOG entry under `Unreleased`
- [ ] Requirements matrix updated (if there is a legal basis)
- [ ] Claude review comments addressed or answered
- [ ] CI green, squash-merged with `Closes #<this issue>`

## Branch
<!-- feat/ fix/ docs/ build/ ci/ refactor/ chore/ followed by <issue>-<short-description> -->
`feat/<issue>-<short-description>`
