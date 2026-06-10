#!/bin/bash
# Bake a pg_dump custom-format file into PGDATA during docker build (builder stage only).
set -euo pipefail

DUMP_PATH="${1:-/tmp/idempiere-db.dmp}"

if [ ! -f "$DUMP_PATH" ]; then
	echo "Dump not found: $DUMP_PATH" >&2
	exit 1
fi

docker-entrypoint.sh postgres &
pg_pid=$!

cleanup() {
	if kill -0 "$pg_pid" 2>/dev/null; then
		kill -INT "$pg_pid" 2>/dev/null || true
		wait "$pg_pid" 2>/dev/null || true
	fi
}
trap cleanup EXIT

for _ in $(seq 1 90); do
	if pg_isready -U postgres -q 2>/dev/null; then
		break
	fi
	if ! kill -0 "$pg_pid" 2>/dev/null; then
		echo "postgres exited during startup" >&2
		exit 1
	fi
	sleep 1
else
	echo "postgres did not become ready" >&2
	exit 1
fi

# CI export-db.sh: pg_dump -Fc of the idempiere database (postgres superuser).
if ! psql -v ON_ERROR_STOP=1 -U postgres -tc "SELECT 1 FROM pg_database WHERE datname = 'idempiere'" | grep -q 1; then
	psql -v ON_ERROR_STOP=1 -U postgres -c "CREATE DATABASE idempiere"
fi

pg_restore -U postgres -d idempiere --no-owner --no-acl --exit-on-error "$DUMP_PATH"

kill -INT "$pg_pid"
wait "$pg_pid"
trap - EXIT
