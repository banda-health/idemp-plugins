#!/usr/bin/env bash
# Run docker compose at repo root after bidirectional env sync.
# Use instead of bare "docker compose" when dev-docker/.env and root .env must align.
# TeamCity / CI agents: set SKIP_ENV_SYNC=1 or CI=true to skip sync entirely.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
bash "${ROOT}/dev-docker/scripts/sync-env.sh" --quiet
cd "$ROOT"
exec docker compose "$@"
