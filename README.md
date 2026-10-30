# Urd

Bookkeeping software for a small Swedish limited company (*aktiebolag*), built to follow the
Swedish Bookkeeping Act (*bokföringslagen*, BFL).

Named after Urðr, the Norn of *what has been*, who carves fate into runes at the well beneath
Yggdrasil. A ledger is the same idea: once something is recorded, it is never erased, only
corrected by a new record.

> **Disclaimer:** Urd is a personal project and is **not** certified bookkeeping software. It is
> provided as is, without warranty (see [LICENSE](LICENSE)). The author runs it alongside an
> established bookkeeping program while it matures. Nothing in this repository is legal advice.

## Goals

- Double-entry bookkeeping on the BAS chart of accounts, for roughly 20–100 vouchers per year
- Vouchers that can never be changed or deleted; errors are fixed with correction vouchers
- An audit trail and system documentation, so anyone can follow what happened and how the system works
- Source documents (receipts, invoices) linked to every voucher
- Reports, VAT report, SIE4 export/import and year-end support
- A 7-year archive in formats that can be read without this program

Payroll and digital filing of the annual report are out of scope.

## Status

Early setup. See the [project board](https://github.com/ewnolin/urd/projects) and the
[epics](https://github.com/ewnolin/urd/issues?q=label%3Aepic).

## Running locally

Requirements: JDK 21 and Docker.

```bash
./gradlew build      # compile and run all tests
```

Instructions for running the application will be added together with the database setup.

## Documentation

- [Architecture decisions](docs/adr/)
- [System documentation](docs/system/) — required by BFL ch. 5 § 11
- [Changelog](CHANGELOG.md)

## Contributing

Work is tracked as issues grouped under epics. Branches are named `<type>/<issue>-<description>`,
commits follow [Conventional Commits](https://www.conventionalcommits.org/), and pull requests are
squash-merged.

## License

[MIT](LICENSE)
