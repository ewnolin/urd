Closes #

## What
<!-- What changed, in a few bullets. -->
-

## Schema changes
<!-- None, or: which tables, keys, types, constraints and privileges, and why this design. -->

## Checklist
- [ ] Tests cover new logic, including failure cases
- [ ] No `UPDATE`/`DELETE` on posted vouchers, the audit log or attachments
- [ ] No applied Flyway migration edited (new migration instead)
- [ ] No fully qualified class names persisted
- [ ] UI texts added to both `messages_sv` and `messages_en`
- [ ] CHANGELOG updated under `Unreleased`
- [ ] Requirements matrix updated (if this implements a legal requirement)
- [ ] ADR added or updated (if this is a significant decision)
