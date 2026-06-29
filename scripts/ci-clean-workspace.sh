#!/usr/bin/env bash
# Clear CI workspace dirs. Docker test runs leave root-owned files under
# idempiere-logs/ and db-output/ (bind-mounted as /app/output in the tests container).
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

CONTAINER_NAME="${CONTAINER_NAME:-}"

docker run --rm -v "$PWD:/work" -e CONTAINER_NAME="${CONTAINER_NAME}" alpine sh -c '
  rm -rf /work/db-output /work/output
  mkdir -p /work/db-output /work/output
  rm -rf /work/idempiere-logs
  if [ -n "$CONTAINER_NAME" ]; then
    mkdir -p "/work/idempiere-logs/$CONTAINER_NAME"
  else
    mkdir -p /work/idempiere-logs
  fi
  chmod -R 777 /work/idempiere-logs /work/db-output /work/output
'
