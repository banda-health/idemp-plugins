#!/usr/bin/env bash
# Wait until the headless iDempiere server is ready for tests.
#
# Mirrors ghcr.io/banda-health/banda-idempiere /health-check.sh when
# HEALTHY_AFTER_PLUGINS_START=true: telnet to the OSGi console (default 12612)
# and verify Banda plugin bundles are ACTIVE or RESOLVED.
set -euo pipefail

IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
SERVER_HOME="${IDEMPIERE_SERVER_HOME:-${IDEMPIERE_HOME}/org.idempiere.p2/target/products/org.adempiere.server.product/linux/gtk/x86_64}"
PLUGINS_DIR="${PLUGINS_DIR:-${SERVER_HOME}/plugins}"
TELNET_HOST="${TELNET_HOST:-localhost}"
TELNET_PORT="${TELNET_PORT:-12612}"
TIMEOUT="${WAIT_READY_TIMEOUT:-300}"
INTERVAL="${WAIT_READY_INTERVAL:-5}"
BUNDLES_FILE="${SERVER_HOME}/banda/bundles"

telnet_port_open() {
    (echo >"/dev/tcp/${TELNET_HOST}/${TELNET_PORT}") >/dev/null 2>&1
}

write_bundles_file() {
    local jar name
    mkdir -p "$(dirname "$BUNDLES_FILE")"
    : >"$BUNDLES_FILE"
    shopt -s nullglob
    for jar in "${PLUGINS_DIR}"/*bandahealth*.jar "${PLUGINS_DIR}"/com.chuboe.*.jar; do
        name="$(basename "$jar")"
        if [[ "$name" =~ ^(.+)-[0-9].*-SNAPSHOT\.jar$ ]]; then
            echo "echo ss ${BASH_REMATCH[1]}"
        fi
    done >>"$BUNDLES_FILE"
    echo "sleep 1" >>"$BUNDLES_FILE"
    shopt -u nullglob
    [[ -s "$BUNDLES_FILE" ]]
}

osgi_bundles_ready() {
    if [[ ! -s "$BUNDLES_FILE" ]]; then
        return 1
    fi

    rm -f /tmp/osgi_bundle_status
    touch /tmp/osgi_bundle_status
    # Same pipeline as banda-idempiere /health-check.sh
    eval "$(cat "$BUNDLES_FILE")" | telnet "$TELNET_HOST" "$TELNET_PORT" 2>&1 | grep -i "_[[:digit:]]" >>/tmp/osgi_bundle_status

    local total active
    total="$(wc -l </tmp/osgi_bundle_status | tr -d ' ')"
    active="$(grep -ciE 'active|resolved' /tmp/osgi_bundle_status || true)"
    [[ "$total" -gt 0 && "$total" -eq "$active" ]]
}

if [[ "${1:-}" == "--once" ]]; then
    if ! write_bundles_file; then
        exit 1
    fi
    if telnet_port_open && osgi_bundles_ready; then
        exit 0
    fi
    exit 1
fi

if ! write_bundles_file; then
    echo "No Banda plugin JARs found under ${PLUGINS_DIR}." >&2
    echo "Run ./dev.sh build and start the server before wait-ready." >&2
    exit 1
fi

echo "Waiting for OSGi console at ${TELNET_HOST}:${TELNET_PORT} (timeout ${TIMEOUT}s, interval ${INTERVAL}s)..."
echo "Checking bundles listed in ${BUNDLES_FILE}..."

elapsed=0
while true; do
    if telnet_port_open && osgi_bundles_ready; then
        echo "iDempiere OSGi plugins are ready (telnet ${TELNET_HOST}:${TELNET_PORT})."
        exit 0
    fi

    if (( elapsed >= TIMEOUT )); then
        echo "Timed out after ${TIMEOUT}s waiting for OSGi plugin readiness." >&2
        if [[ -f /tmp/osgi_bundle_status ]]; then
            echo "Last OSGi bundle status:" >&2
            cat /tmp/osgi_bundle_status >&2
        fi
        exit 1
    fi

    sleep "$INTERVAL"
    elapsed=$((elapsed + INTERVAL))
done
