---
name: run-idempiere-dev
description: >-
  Start iDempiere for development or automated testing. Use when running the
  dev environment, starting the iDempiere server, verifying the server is up,
  running CI tests, or iterating on GraphQL tests. Covers dev-docker (Eclipse)
  vs root docker compose (headless CI stack).
---

# Run iDempiere for Development & Testing

Two stacks serve different purposes — do not conflate them:

| Stack | Location | Purpose |
|-------|----------|---------|
| **Dev** | `dev-docker/` via `./dev.sh` | Interactive plugin development (Eclipse + PDE) |
| **CI / tests** | Root `docker-compose.yml` | Headless server + automated test suite |

Human setup details: [Setup Guide wiki](https://github.com/banda-health/idemp-banda/wiki/Setup-Guide)  
**New dev image / Dockerfile toolchain changes:** [dev-docker/IMAGE-SETUP.md](../../../dev-docker/IMAGE-SETUP.md) (manual Eclipse steps + `./dev.sh capture`)

## Prerequisites

- `dev-docker/.env` configured (`DB_UPSTREAM_*`, `DB_HOST_PORT`, `IDEMPIERE_HTTP_PORT`)
- Host Postgres reachable from the container (PgBouncer `db-proxy` → host DB)
- First-time dev: Eclipse iDempiere install creates `/opt/idempiere/idempiere.properties`; until then, container start skips migrations

## Path A: Interactive plugin development (dev-docker)

Use when changing Java plugins, migrations, or reports and testing in Eclipse.

1. `./dev.sh` — start dev container; Eclipse opens automatically
2. **First time / new image only:** follow [IMAGE-SETUP.md](../../../dev-docker/IMAGE-SETUP.md) (target platform, build/import Banda plugins, install, verify, `./dev.sh capture`). Wiki: [Setup Guide](https://github.com/banda-health/idemp-banda/wiki/Setup-Guide)
3. **Start the server:** in Eclipse, run the **iDempiere server** configuration (`org.adempiere.server.product` / `server.product`). `./dev.sh` does **not** start the server.
4. `./dev.sh build` — `mvn verify`; deploys plugins, reports, data, migrations into `/opt/idempiere`
5. `./dev.sh migrate` — apply pending DB migrations via `RUN_SyncDBDev.sh`
6. **After build or migrate:** restart the iDempiere server in Eclipse (stop → run again)
7. Verify: `./dev.sh wait-ready` or open `http://localhost:${IDEMPIERE_HTTP_PORT}` (default **8080**; check `dev-docker/.env`)

### Agent limitations (Path A)

- Requires GUI (Eclipse + X11). Not headless-automatable without human interaction.
- Server Run Configuration lives in `/home/developer/eclipse-workspace` inside the dev image (captured with `./dev.sh capture`), not in git.
- Prefer Path B for agent-driven verification after code changes.

## Path B: Automated tests (CI stack, no Eclipse)

Use when verifying plugin changes end-to-end without Eclipse.

1. From repo root: `cp .env.example .env` (if not already present)
2. `./dev.sh test` or `docker compose up` — starts `banda-idempiere`, Postgres, external mocks, and runs `base-test`, `graphql-test`, `reports-test`
3. Any service that exits unhealthy means tests failed
4. iDempiere exposed at `${IDEMPIERE_PORT}` (default **9877** per root `.env.example`)

Tests require the **Garden World** client (ClientID 11 in SOAP requests).

## Path C: GraphQL test iteration

Use when developing GraphQL endpoints against a running server.

1. iDempiere running (Path A or B, or any reachable instance)
2. `docker compose -f docker-compose.dev.yml up --build`
3. `docker compose -f docker-compose.dev.yml exec tests /bin/bash`
4. `cd graphql-test && jest`

Environment variables (root `.env` or shell):

- `IDEMPIERE_ENDPOINT` — e.g. `http://idempiere:8080` (compose) or `http://host.docker.internal:9090` (dev)
- `IDEMPIERE_USER` / `IDEMPIERE_USER_PASSWORD` — default `SuperUser` / `System`
- `IDEMPIERE_GRAPHQL_TEST_CLIENT` — optional test client name

Build the `graphql` plugin first so generated types exist.

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
| Build plugins | `./dev.sh build` |
| Apply migrations | `./dev.sh migrate` |
| Wait for dev server (after Eclipse start) | `./dev.sh wait-ready` |
| Run full CI test suite | `./dev.sh test` |
| Stop dev stack | `./dev.sh down` |
| Freeze dev container to snapshot image | `./dev.sh capture` |
| Push snapshot image to registry | `./dev.sh push` |

## Checklist: after plugin or migration changes

- [ ] `./dev.sh build`
- [ ] `./dev.sh migrate` (if SQL changed)
- [ ] Restart iDempiere server (Eclipse for Path A; CI stack restarts automatically for Path B)
- [ ] `./dev.sh wait-ready` or run `./dev.sh test` for verification

## Related

- Table/migration workflow: [add-database-table skill](../add-database-table/SKILL.md)
- Agent entry point: [AGENTS.md](../../../AGENTS.md)
