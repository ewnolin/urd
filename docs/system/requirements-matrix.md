# Requirements matrix

Each legal requirement that shapes Urd, the issue that implements it and the test that proves it.
A requirement is done when it has both.

The references are the author's reading of the law and have **not** been checked by a lawyer or
accountant. The *Verified* column records when a reference was checked against the current text of
BFL (SFS 1999:1078) and the Swedish Accounting Standards Board's guidance BFNAR 2013:2 *Bokföring*.

| ID | Requirement | Reference | Issue | Test | Verified |
|---|---|---|---|---|---|
| R1 | Posted vouchers are never changed or deleted | BFL ch. 5 § 5 | | | |
| R2 | Errors are corrected so that it is clear who made the correction, when, and why | BFL ch. 5 § 5 | | | |
| R3 | An audit trail shows how data was processed (*behandlingshistorik*) | BFL ch. 5 § 11 | | | |
| R4 | System documentation describes how the system is organised and processes data | BFL ch. 5 § 11 | #8 | | |
| R5 | Every business transaction has a voucher with the required content (dates, description, amounts, counterparty, voucher number) | BFL ch. 5 §§ 6–7 | | | |
| R6 | Voucher numbers run in an unbroken sequence per series and fiscal year | BFL ch. 5 § 7, BFNAR 2013:2 | | | |
| R7 | Each voucher can be linked to its source documents | BFL ch. 5 §§ 6–7 | | | |
| R8 | Transactions are recorded in chronological order (journal) and systematic order (general ledger) | BFL ch. 5 § 1 | | | |
| R9 | Fiscal years follow the length and start rules, including the first year | BFL ch. 3 | #16 | | |
| R10 | A chart of accounts is used; Urd bases it on BAS | BFNAR 2013:2 | #15 | | |
| R11 | Bookkeeping records are archived for 7 years in a readable form that does not depend on Urd | BFL ch. 7 §§ 1–2 | | | |

## How to update

- When an issue implements a requirement, fill in the *Issue* column and give the issue the `legal`
  label.
- When a test proves it, fill in the *Test* column with the test class and method.
- When you check a reference against the current law text, write the date in *Verified*.
- New requirements get the next free ID; IDs are never reused.
