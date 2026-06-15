#!/usr/bin/env bash
# Clear CI workspace dirs; idempiere log files are often root-owned inside the container.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

CONTAINER_NAME="${CONTAINER_NAME:-}"
LOG_DIR="idempiere-logs"
if [[ -n "$CONTAINER_NAME" ]]; then
    LOG_DIR="idempiere-logs/${CONTAINER_NAME}"
fi

rm -rf output/* 2>/dev/null || true
mkdir -p output

# iDempiere writes logs as root; remove via a throwaway container on the agent.
if [[ -d idempiere-logs ]]; then
    docker run --rm -v "$PWD/idempiere-logs:/logs" alpine \
        sh -c 'rm -rf /logs/*' 2>/dev/null || true
fi
mkdir -p "$LOG_DIR"
