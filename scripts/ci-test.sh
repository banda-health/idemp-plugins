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

if [[ -z "${COMPOSE_PROJECT_NAME:-}" ]]; then
    echo "COMPOSE_PROJECT_NAME must be set in .env for CI test runs." >&2
    exit 1
fi

bash "${ROOT}/scripts/ci-clean-workspace.sh"

WAIT_TIMEOUT="${CI_TEST_WAIT_TIMEOUT:-1200}"
project_label="${COMPOSE_PROJECT_NAME}"

compose_ci() {
    bash "${ROOT}/scripts/compose.sh" -p "${COMPOSE_PROJECT_NAME}" "$@"
}

dump_compose_logs() {
    echo "========== docker compose logs (project=${project_label}) =========="
    compose_ci logs --no-color --timestamps --tail=200 postgres idempiere 2>&1 || true
    echo "========== docker compose ps =========="
    compose_ci ps -a 2>&1 || true
}

tear_down_stack() {
    compose_ci down -v --timeout 15 --remove-orphans 2>/dev/null || true
    # Fallback when compose project labels drift (e.g. manual down -p mismatch on agents).
    if [[ -n "${CONTAINER_NAME:-}" ]]; then
        docker rm -f \
            "${CONTAINER_NAME}_postgres" \
            "${CONTAINER_NAME}_idempiere" \
            "${CONTAINER_NAME}_external_mocks" \
            "${CONTAINER_NAME}_tests" \
            2>/dev/null || true
    fi
}

echo "Tearing down any previous test stack (project=${project_label})..."
tear_down_stack

echo "Starting test stack (project=${project_label}, postgres port=${POSTGRES_PORT})..."
set +e
compose_ci up -d --wait --wait-timeout "${WAIT_TIMEOUT}" postgres external-mocks idempiere
up_exit=$?
set -e
if [[ "$up_exit" -ne 0 ]]; then
    dump_compose_logs
    tear_down_stack
    exit "$up_exit"
fi

echo "Running tests..."
set +e
compose_run_args=(run --rm)
for arg in "$@"; do
  case "$arg" in
    --build) compose_run_args+=(--build) ;;
    *) echo "Ignoring unknown ci-test.sh argument: $arg" >&2 ;;
  esac
done
compose_ci "${compose_run_args[@]}" tests
exit_code=$?
set -e

echo "Tests finished (exit ${exit_code}); tearing down stack..."
tear_down_stack
exit "$exit_code"
