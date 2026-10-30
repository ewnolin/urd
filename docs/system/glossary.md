# Glossary

Swedish bookkeeping terms and the English names used in code, issues and documentation. The UI
shows the Swedish term by default.

| Swedish | English (code) | Meaning |
|---|---|---|
| aktiebolag (AB) | limited company | The company whose books Urd keeps |
| affärshändelse | business transaction | An event that changes the company's assets, liabilities or equity |
| verifikation | voucher (`Voucher`) | The record of one business transaction, with its lines and source documents |
| verifikationsnummer | voucher number | Sequential number within a voucher series and fiscal year, without gaps |
| konteringsrad | voucher line (`VoucherLine`) | One debit or credit amount on one account |
| debet / kredit | debit / credit | The two sides of double-entry bookkeeping; they must balance |
| underlag | source document (`Attachment`) | Receipt, invoice or other evidence for a voucher |
| rättelseverifikation | correction voucher | A new voucher that reverses or adjusts an earlier one; the original is never changed |
| utkast | draft (`VoucherDraft`) | A voucher being prepared; editable until it is posted |
| bokföra | post | Turn a draft into a numbered, immutable voucher |
| konto | account (`Account`) | A four-digit account in the chart of accounts |
| kontoplan | chart of accounts | The list of accounts; based on BAS |
| kontoklass | account class | The first digit of an account number |
| räkenskapsår | fiscal year (`FiscalYear`) | The accounting period, normally 12 months |
| ingående balans (IB) | opening balance (`OpeningBalance`) | Balance-sheet account balances at the start of a fiscal year |
| utgående balans (UB) | closing balance | Balances at the end of a fiscal year |
| grundbok | journal | All vouchers in chronological (registration) order |
| huvudbok | general ledger | All vouchers grouped by account |
| balansräkning | balance sheet | Assets, equity and liabilities at a point in time |
| resultaträkning | income statement | Revenue and expenses for a period |
| moms | VAT | Value added tax |
| momsdeklaration | VAT return | The periodic VAT report to Skatteverket |
| bokslut | year-end closing | Closing entries and statements at the end of a fiscal year |
| årsredovisning | annual report | Statutory annual report filed with Bolagsverket |
| behandlingshistorik | audit trail (`AuditLog`) | A record of how data was processed in the system |
| systemdokumentation | system documentation | This folder |
| arkivering | archiving | Keeping the records readable for the required period |
| organisationsnummer | organisation number | Swedish company identifier, ten digits with a Luhn check digit |
| SIE | SIE | Swedish standard file format for exchanging bookkeeping data |
| SRU | SRU | File format for transferring tax return values to Skatteverket |
