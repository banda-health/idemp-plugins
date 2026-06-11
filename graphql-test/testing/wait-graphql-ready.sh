#!/usr/bin/env bash
# Wait until the GraphQL HTTP endpoint responds before running Vitest.
set -euo pipefail

endpoint="${IDEMPIERE_ENDPOINT:-http://idempiere:8080}"
graphql_url="${endpoint%/}/graphql/"
timeout="${WAIT_GRAPHQL_TIMEOUT:-60}"
interval="${WAIT_GRAPHQL_INTERVAL:-2}"
probe_file="$(mktemp)"

cleanup() {
    rm -f "$probe_file"
}
trap cleanup EXIT

echo "Waiting for GraphQL at ${graphql_url} (timeout ${timeout}s, interval ${interval}s)..."

elapsed=0
while (( elapsed < timeout )); do
    if wget -q -O "$probe_file" \
        --header='Content-Type: application/json' \
        --post-data='{"query":"{ __typename }"}' \
        "$graphql_url" 2>/dev/null && grep -q '__typename' "$probe_file"; then
        echo "GraphQL endpoint is ready."
        exit 0
    fi

    sleep "$interval"
    elapsed=$((elapsed + interval))
done

echo "Timed out after ${timeout}s waiting for GraphQL at ${graphql_url}." >&2
exit 1
