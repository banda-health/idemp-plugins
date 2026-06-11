---
name: run-idempiere-dev
description: >-
  Start iDempiere for development or automated testing. Use when running the
  dev environment, starting the iDempiere server, verifying the server is up,
  running dev or CI tests, or iterating on GraphQL tests. Covers dev-docker
  (Eclipse) vs docker-compose.dev.yml vs root CI stack.
---

# Run iDempiere for Development & Testing

Three stacks serve different purposes:

| Stack | Location | Purpose |
|-------|----------|---------|
| **Dev (Eclipse)** | `dev-docker/` via `./dev.sh` | Interactive plugin development |
| **Dev tests** | `docker-compose.dev.yml` via `./dev.sh test` | Automated tests against dev-container iDempiere |
| **CI tests** | Root `docker-compose.yml` via `./dev.sh test-ci` | Headless CI image + `./testing/` staging |

Human setup details: [Setup Guide wiki](https://github.com/banda-health/idemp-banda/wiki/Setup-Guide)  
**New dev image / Dockerfile toolchain changes:** [dev-docker/IMAGE-SETUP.md](../../../dev-docker/IMAGE-SETUP.md) (manual Eclipse steps + `./dev.sh capture`)

## Prerequisites

- `dev-docker/.env` configured (`DB_UPSTREAM_*`, `DB_HOST_PORT`, `IDEMPIERE_HTTP_PORT`)
- Root `.env` (synced from `dev-docker/.env` via `sync-env.sh`; set `IDEMPIERE_ENDPOINT=http://host.docker.internal:${IDEMPIERE_HTTP_PORT}`)
- Host Postgres reachable from the container when `DB_TARGET=host` (PgBouncer `db-proxy` → host DB)
- First-time dev: Eclipse iDempiere install creates `/opt/idempiere/idempiere.properties`; until then, headless server start fails

## Path A: Interactive plugin development (dev-docker)

Use when changing Java plugins, migrations, or reports and testing in Eclipse.

1. `./dev.sh` — start dev container; Eclipse opens automatically
2. **First time / new image only:** follow [IMAGE-SETUP.md](../../../dev-docker/IMAGE-SETUP.md)
3. **Start the server:** in Eclipse, run **iDempiere server** (`server.product`). `./dev.sh` does **not** start the server.
4. `./dev.sh build` — `mvn verify` in container; deploys to `/opt/idempiere` (not `./testing/`)
5. `./dev.sh migrate` — apply pending DB migrations via `RUN_SyncDBDev.sh`
6. **After build or migrate:** restart the iDempiere server in Eclipse
7. Verify: `./dev.sh wait-ready` or open `http://localhost:${IDEMPIERE_HTTP_PORT}`

### Agent limitations (Path A)

- Requires GUI (Eclipse + X11). Not headless-automatable without human interaction.

## Path B: Automated dev tests (`./dev.sh test`)

Use when verifying plugin changes end-to-end without Eclipse or the gitignored `./testing/` folder.

Prerequisite: run `./dev.sh build` (and `./dev.sh migrate` if SQL changed) separately when you have code or migration changes.

1. Ensure `dev-docker/.env` and root `.env` exist (root `.env` is auto-synced)
2. `./dev.sh test` — if iDempiere is not already HTTP-ready on `IDEMPIERE_HTTP_PORT`:
   - Starts dev stack **headless** (no Eclipse; `docker-compose.headless.yml`)
   - Starts iDempiere via `start-idempiere-server.sh` (syncs deployed JARs into server product)
   - Waits for HTTP readiness
3. `docker compose -f docker-compose.dev.yml up` — external-mocks + test container
4. Runs the selected test suite via `docker compose exec` (see suites below)

**Default:** `./dev.sh test` runs **GraphQL Jest only** (fastest iteration).

On a **new database**, run `./dev.sh test graphql` once first (SOAP creates the test client).

| Command | What runs |
|---------|-----------|
| `./dev.sh test` | GraphQL Jest only |
| `./dev.sh test -- visitReceiptReport.test.ts` | Jest with file/pattern filter |
| `./dev.sh test graphql` | graphql SOAP Java tests + Jest |
| `./dev.sh test base` / `reports` | That suite's `runTests.sh` only |
| `./dev.sh test --all` | base + graphql + reports |

Options:

- `./dev.sh test --rebuild` — restart the iDempiere server even when HTTP is already up (no `mvn verify`)

Tests require the **Garden World** client (ClientID 11 in SOAP requests) for SOAP suites.

## Path C: CI tests (`./dev.sh test-ci`)

Use for TeamCity-parity runs with the pre-built `banda-idempiere` image.

1. `mvn verify` on host or CI first — populates gitignored `./testing/`
2. `./dev.sh test-ci` or `docker compose up` at repo root
3. iDempiere at `${IDEMPIERE_PORT}` (default **9877**)

## Path D: GraphQL test iteration

Use when developing GraphQL endpoints against a running server.

1. iDempiere running (Path A or B)
2. `docker compose -f docker-compose.dev.yml up --build`
3. `docker compose -f docker-compose.dev.yml exec test /bin/bash`
4. `cd graphql-test && npm test`

Environment variables (root `.env`):

- `IDEMPIERE_ENDPOINT` — e.g. `http://host.docker.internal:9090` (dev) or `http://idempiere:8080` (CI)
- `IDEMPIERE_USER` / `IDEMPIERE_USER_PASSWORD` — default `SuperUser` / `System`
- `IDEMPIERE_GRAPHQL_TEST_CLIENT` — GraphQL test client name (default `GraphQL Test Client`; created by graphql SOAP population)

## Credentials & clients

| Context | User / password | Notes |
|---------|-----------------|-------|
| Dev / CI default | `SuperUser` / `System` | Standard iDempiere admin |
| SOAP tests | Garden World client | ClientID 11, RoleID 102 |
| Dev DB UI fields | Any value on localhost | PgBouncer ignores them; real creds are `DB_UPSTREAM_*` |

Do not commit `dev-docker/.env` or root `.env` — they contain real passwords.

## Quick reference

| Goal | Command |
|------|---------|
| Dev container + Eclipse | `./dev.sh` |
| Build plugins (dev container) | `./dev.sh build` |
| Apply migrations | `./dev.sh migrate` |
| Wait for dev server | `./dev.sh wait-ready` (OSGi telnet + Banda bundles, CI-style) |
| Run GraphQL Jest (default) | `./dev.sh test` |
| Run one Jest file | `./dev.sh test -- visitReceiptReport.test.ts` |
| Run full dev test suite | `./dev.sh test --all` |
| Restart server + test | `./dev.sh test --rebuild` |
| Run CI test suite | `./dev.sh test-ci` |
| Stop dev stack | `./dev.sh down` |
| Freeze dev container to snapshot | `./dev.sh capture` |

## Checklist: after plugin or migration changes

- [ ] `./dev.sh build`
- [ ] `./dev.sh migrate` (if SQL changed)
- [ ] Restart server (Eclipse for Path A; `./dev.sh test --rebuild` for Path B)
- [ ] `./dev.sh test` or `./dev.sh wait-ready` for verification

## Related

- Table/migration workflow: [add-database-table skill](../add-database-table/SKILL.md)
- Agent entry point: [AGENTS.md](../../../AGENTS.md)
