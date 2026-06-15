#!/usr/bin/env bash
# CI / TeamCity test runner: quiet compose startup, tests-only log stream, clean exit.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

if [[ ! -f .env ]]; then
    echo "Missing .env in repo root (auto-created from .env.example when possible)." >&2
    exit 1
fi

# shellcheck disable=SC1091
set -a
# shellcheck source=/dev/null
source .env
set +a

export CI=true
export TEST_QUIET="${TEST_QUIET:-true}"
export COMPOSE_PROGRESS=quiet

WAIT_TIMEOUT="${CI_TEST_WAIT_TIMEOUT:-1200}"
project_label="${COMPOSE_PROJECT_NAME:-${CONTAINER_NAME:-test}}"

echo "Starting test stack (project=${project_label}, postgres port=${POSTGRES_PORT})..."
bash "${ROOT}/scripts/compose.sh" up -d --wait --wait-timeout "${WAIT_TIMEOUT}" postgres external-mocks idempiere

echo "Running tests..."
set +e
bash "${ROOT}/scripts/compose.sh" run --rm tests "$@"
exit_code=$?
set -e

echo "Tests finished (exit ${exit_code}); tearing down stack..."
bash "${ROOT}/scripts/compose.sh" down --timeout 15 --remove-orphans
exit "$exit_code"
