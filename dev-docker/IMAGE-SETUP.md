# Dev image setup (manual Eclipse steps)

The Dockerfile builds iDempiere from source and installs Eclipse + Jaspersoft Studio, but **does not** complete the PDE workspace setup. That work is done once interactively in Eclipse inside the container, then frozen into a snapshot image so day-to-day development can use `./dev.sh` without repeating it.

## When you must do this again

Repeat the full workflow whenever you change any of:

- **Eclipse** version in `dev-docker/Dockerfile`
- **iDempiere** release branch zipped into the image
- **Jaspersoft Studio** version or download URL in the Dockerfile
- A **fresh image** from `./dev.sh --build` with no usable snapshot

Bumping only Banda plugin code, migrations, or reports in this repo does **not** require redoing this — use `./dev.sh build`, `./dev.sh migrate`, and restart the server in Eclipse.

## Build vs snapshot mode

| Command | Compose file | Image source |
|---------|--------------|--------------|
| `./dev.sh` (default) | `docker-compose.snapshot.yml` | Frozen `IDEMPIERE_DEV_IMAGE` (e.g. GHCR snapshot) — **no Dockerfile rebuild** |
| `./dev.sh --build` | `docker-compose.yml` | **Fresh build from `dev-docker/Dockerfile`** (`docker compose up --build`) |

During image setup, use **`./dev.sh --build` only** until you run `./dev.sh capture` and point `IDEMPIERE_DEV_IMAGE` at the new tag. If you run plain `./dev.sh` in between, Compose will start the **old snapshot**, not the image you just built.

After the team snapshot is published, day-to-day work uses `./dev.sh` (snapshot). Use `--build` again only when the Dockerfile toolchain changes.

## Overview

```text
./dev.sh --build          → image with Eclipse + /opt/idempiere source build
./dev.sh --build          → container starts; Eclipse opens (use --build throughout setup)
   … manual steps below …
./dev.sh capture          → docker commit → snapshot image for the team
./dev.sh                  → later starts use snapshot (no manual steps)
```

Repo mount (per-developer): `/workspace/idemp-banda` via `PLUGINS_MOUNT`  
iDempiere home after install: `/opt/idempiere`  
Eclipse workspace (in image): `/home/developer/eclipse-workspace`  
Maven cache (in image): `/home/developer/.m2`  
Jaspersoft Studio workspace (in image): `/home/developer/jaspersoft-studio-workspace`

## Manual steps (in order)

Start the container so Eclipse opens:

```bash
./dev.sh --build   # first time, or after Dockerfile toolchain changes
./dev.sh           # or combined: ./dev.sh --build
```

Then in Eclipse:

1. **Turn off Build Automatically** — **Project → Build Automatically** (uncheck). Keep it off until step 7.
2. **Confirm auto-build is off** — if Eclipse or the import wizard re-enables it, turn **Build Automatically** off again before target-platform work.
3. **Set compiler and JREs** — use the Java level required by the iDempiere/Eclipse combo in the image (Java **17** for release-12 / current Dockerfile). Check **Window → Preferences → Java → Compiler** and **Installed JREs**.
4. **Open the target platform and import** — **Window → Preferences → Plug-in Development → Target Platform** (or **Target Definition**): open/set the iDempiere target, let it resolve, and import the workspace projects you need from `/opt/idempiere` and `/workspace/idemp-banda` per the [Setup Guide](https://github.com/banda-health/idemp-banda/wiki/Setup-Guide).
5. **Build the Banda plugins** inside the container — build the Banda modules from the imported projects (PDE build), not only host-side Maven.
6. **Import those plugins into the server** — add the Banda plugins/features to `server.product` / the iDempiere server feature so the runtime includes them ([Setup Guide](https://github.com/banda-health/idemp-banda/wiki/Setup-Guide)).
7. **Turn Build Automatically back on** — **Project → Build Automatically** (check).
8. **Install the app** — run the Eclipse/iDempiere **Install** flow so `/opt/idempiere` is populated for runtime (`idempiere.properties`, etc.).
9. **Verify the app runs** — launch the iDempiere server (`server.product` / `org.adempiere.server.product`). Confirm HTTP on the port in `dev-docker/.env` (`IDEMPIERE_HTTP_PORT`, default 8080).
10. **Save the container state** — freeze the configured container (see below).

### If something goes wrong mid-setup

You can **commit a partial snapshot** between steps (e.g. after target platform resolves, or after a successful plugin build) so you do not lose hours of work:

```bash
IMAGE_TAG=snapshot-step4 ./dev.sh capture
```

`./dev.sh capture` commits to **`IDEMPIERE_DEV_IMAGE`** in `dev-docker/.env` (repo + tag parsed automatically). Use `IMAGE_TAG=…` on the command line for partial saves without changing `.env`. Bump the tag in `.env` when publishing a new team image, then `capture` and `docker push`.

## What is in the image vs bind mounts

Dev state is stored **inside the container filesystem** (not named volumes), so `./dev.sh capture` + `docker push` is all another developer needs.

| Data | Where | Shared via image? |
|------|--------|-------------------|
| `/opt/idempiere` install, plugins, `idempiere.properties` | Image | Yes |
| Eclipse workspace, run configs, target platform | `/home/developer/eclipse-workspace` | Yes |
| Maven cache | `/home/developer/.m2` | Yes |
| Jaspersoft Studio workspace | `/home/developer/jaspersoft-studio-workspace` | Yes |
| Banda source tree | Bind mount `PLUGINS_MOUNT` → `/workspace/idemp-banda` | **No** — each dev uses their own `git clone` |

Quit Eclipse and stop the iDempiere server before `./dev.sh capture` so the committed filesystem is consistent.

### Why we removed named volumes for dev state

Named volumes (`eclipse-workspace`, `maven-repo`, etc.) **replace** image directories at runtime. On a new machine Docker creates **empty** volumes, hiding whatever you baked into the image. That prevented “pull image → same Eclipse I had” without a separate export step.

We still use bind mounts only where they should differ per developer (the repo) or per host (X11 / WSLg).

Optional **`docker-compose.build-overlays.yml`** adds named volumes over `target/` and `lib/` under the repo mount for **Windows drvfs** permission issues. `./dev.sh` does not merge it by default; use it only if Maven fails writing to the bind mount on Windows.

**Upgrading from the old volume-based setup:** stop the stack, remove obsolete volumes once (`./dev.sh down` then `docker volume rm dev-docker_eclipse-workspace dev-docker_maven-repo dev-docker_jaspersoft-studio-workspace` if they exist), re-run your Eclipse setup or pull a fresh snapshot image, then `./dev.sh capture` so workspace state is in the image layers.

## Freeze and share (image only)

When steps 1–9 succeed:

**Publisher:**

```bash
# Quit Eclipse and stop the iDempiere server
# Set IDEMPIERE_DEV_IMAGE in dev-docker/.env first (repo:tag for GHCR)
./dev.sh capture
./dev.sh push
```

Update `IDEMPIERE_DEV_IMAGE` in `dev-docker/.env.example` (and team `.env`) when you change the published tag.

**New developer:**

```bash
git clone …
cp dev-docker/.env.example dev-docker/.env   # IDEMPIERE_DEV_IMAGE, DB_*, PLUGINS_MOUNT
docker pull ghcr.io/banda-health/idempiere-dev:<tag>
./dev.sh
```

Same Eclipse workspace and iDempiere install as the publisher; only the repo checkout and DB connection settings are local.

After that, developers run `./dev.sh` (snapshot mode) and skip manual Eclipse setup unless the Dockerfile toolchain changes.

## Day-to-day after the snapshot exists

| Task | Command |
|------|---------|
| Start Eclipse | `./dev.sh` |
| Build & deploy plugins/reports | `./dev.sh build` |
| DB migrations | `./dev.sh migrate` |
| Report design | `./dev.sh jasper` |
| Restart server | Stop/run `server.product` in Eclipse after build or migrate |

See [README.md](../README.md) and [`.cursor/skills/run-idempiere-dev/SKILL.md`](../.cursor/skills/run-idempiere-dev/SKILL.md).
