#!/usr/bin/env bash
# CI / TeamCity test runner: quiet compose startup, tests-only log stream, clean exit.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

if [[ ! -f .env ]]; then
    echo "Missing .env in repo root (auto-created from .env.example when possible)." >&2
    exit 1
fi

load_env_file() {
    local file="$1"
    while IFS= read -r line || [[ -n "$line" ]]; do
        [[ -z "$line" || "$line" =~ ^[[:space:]]*# ]] && continue
        line="${line#export }"
        line="${line%%$'\r'}"
        if [[ "$line" =~ ^([A-Za-z_][A-Za-z0-9_]*)=(.*)$ ]]; then
            local key="${BASH_REMATCH[1]}"
            local value="${BASH_REMATCH[2]}"
            if [[ "$value" =~ ^\"(.*)\"$ ]] || [[ "$value" =~ ^\'(.*)\'$ ]]; then
                value="${BASH_REMATCH[1]}"
            fi
            export "$key=$value"
        fi
    done <"$file"
}

load_env_file .env

export CI=true
export TEST_QUIET="${TEST_QUIET:-true}"
export COMPOSE_PROGRESS=quiet

bash "${ROOT}/scripts/ci-clean-workspace.sh"

WAIT_TIMEOUT="${CI_TEST_WAIT_TIMEOUT:-1200}"
project_label="${COMPOSE_PROJECT_NAME:-${CONTAINER_NAME:-test}}"

echo "Starting test stack (project=${project_label}, postgres port=${POSTGRES_PORT})..."
bash "${ROOT}/scripts/compose.sh" up -d --wait --wait-timeout "${WAIT_TIMEOUT}" postgres external-mocks idempiere

echo "Running tests..."
set +e
compose_run_args=(run --rm)
for arg in "$@"; do
  case "$arg" in
    --build) compose_run_args+=(--build) ;;
    *) echo "Ignoring unknown ci-test.sh argument: $arg" >&2 ;;
  esac
done
bash "${ROOT}/scripts/compose.sh" "${compose_run_args[@]}" tests
exit_code=$?
set -e

echo "Tests finished (exit ${exit_code}); tearing down stack..."
bash "${ROOT}/scripts/compose.sh" down --timeout 15 --remove-orphans
exit "$exit_code"
