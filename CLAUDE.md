# Claude Instructions

Project conventions and agent workflows live in tool-agnostic docs in the repo:

- **[`AGENTS.md`](AGENTS.md)** — entry point for all AI assistants
- **[`migration/README.md`](migration/README.md)** — migration naming, new-table workflow, canonical examples

When adding a database table, follow the full checklist in those files. Do not run
the model or GraphQL generators; replicate output using `BH_Feature_Flag` as reference.
