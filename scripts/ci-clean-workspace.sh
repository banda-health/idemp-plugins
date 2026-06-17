#!/usr/bin/env bash
# Clear CI workspace dirs; iDempiere leaves root-owned files under idempiere-logs/.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

CONTAINER_NAME="${CONTAINER_NAME:-}"

docker run --rm -v "$PWD:/work" -e CONTAINER_NAME="${CONTAINER_NAME}" alpine sh -c '
  rm -rf /work/output/*
  mkdir -p /work/output
  rm -rf /work/idempiere-logs
  if [ -n "$CONTAINER_NAME" ]; then
    mkdir -p "/work/idempiere-logs/$CONTAINER_NAME"
  else
    mkdir -p /work/idempiere-logs
  fi
  chmod -R 777 /work/idempiere-logs /work/output
'
