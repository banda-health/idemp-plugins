#!/usr/bin/env bash
# Start (or restart) the iDempiere server headlessly inside the dev container.
#
# Uses the p2 server product (idempiere-server.sh) with runtime config symlinked from
# IDEMPIERE_HOME and Banda plugin JARs synced from the mounted repo.
set -euo pipefail

IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
SERVER_HOME="${IDEMPIERE_SERVER_HOME:-${IDEMPIERE_HOME}/org.idempiere.p2/target/products/org.adempiere.server.product/linux/gtk/x86_64}"
PID_FILE="${IDEMPIERE_SERVER_PID_FILE:-/tmp/idempiere-server.pid}"
LOG_FILE="${IDEMPIERE_SERVER_LOG:-${IDEMPIERE_HOME}/log/idempiere-server.log}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [[ ! -s "${IDEMPIERE_HOME}/idempiere.properties" ]]; then
    echo "Missing ${IDEMPIERE_HOME}/idempiere.properties." >&2
    echo "Complete the one-time Eclipse install in the dev image (see dev-docker/IMAGE-SETUP.md)." >&2
    exit 1
fi

if [[ ! -x "${SERVER_HOME}/idempiere-server.sh" ]]; then
    echo "Server launcher not found: ${SERVER_HOME}/idempiere-server.sh" >&2
    exit 1
fi

bash "${SCRIPT_DIR}/sync-server-plugins.sh"

mkdir -p "${IDEMPIERE_HOME}/log" "$(dirname "$LOG_FILE")" "${SERVER_HOME}/utils"

java_bin="$(command -v java)"
java_home="$(dirname "$(dirname "$(readlink -f "$java_bin")")")"
cat > "${SERVER_HOME}/utils/myEnvironment.sh" <<EOF
#!/bin/sh
IDEMPIERE_HOME="${SERVER_HOME}"
export IDEMPIERE_HOME
JAVA_HOME="${java_home}"
export JAVA_HOME
EOF
chmod +x "${SERVER_HOME}/utils/myEnvironment.sh"

for config in idempiere.properties idempiereEnv.properties hazelcast.xml .idpass; do
    if [[ -e "${IDEMPIERE_HOME}/${config}" ]]; then
        rm -rf "${SERVER_HOME}/${config}"
        ln -sf "${IDEMPIERE_HOME}/${config}" "${SERVER_HOME}/${config}"
    fi
done

if [[ -f "${IDEMPIERE_HOME}/utils/getVar.sh" && ! -f "${SERVER_HOME}/utils/getVar.sh" ]]; then
    ln -sf "${IDEMPIERE_HOME}/utils/getVar.sh" "${SERVER_HOME}/utils/getVar.sh"
fi

# Runtime jetty config lives under IDEMPIERE_HOME after Eclipse install, not in the p2 product templates.
if [[ -d "${IDEMPIERE_HOME}/jettyhome" ]]; then
    rm -rf "${SERVER_HOME}/jettyhome"
    ln -sf "${IDEMPIERE_HOME}/jettyhome" "${SERVER_HOME}/jettyhome"
fi

# Compiled Jasper reports are deployed to IDEMPIERE_HOME/reports by mvn verify (reports module).
if [[ -d "${IDEMPIERE_HOME}/reports" ]]; then
    rm -rf "${SERVER_HOME}/reports"
    ln -sf "${IDEMPIERE_HOME}/reports" "${SERVER_HOME}/reports"
fi

# Banda data imports (report images, etc.) live under IDEMPIERE_HOME/data.
if [[ -d "${IDEMPIERE_HOME}/data" ]]; then
    rm -rf "${SERVER_HOME}/data"
    ln -sf "${IDEMPIERE_HOME}/data" "${SERVER_HOME}/data"
fi

stop_server() {
    if [[ -f "$PID_FILE" ]]; then
        local pid
        pid="$(cat "$PID_FILE")"
        if kill -0 "$pid" 2>/dev/null; then
            echo "Stopping iDempiere server (pid $pid)..."
            kill "$pid" 2>/dev/null || true
            for _ in $(seq 1 30); do
                kill -0 "$pid" 2>/dev/null || break
                sleep 1
            done
            kill -9 "$pid" 2>/dev/null || true
        fi
        rm -f "$PID_FILE"
    fi

    if command -v pgrep >/dev/null 2>&1; then
        # Match JVMs only — avoid killing this script (also named idempiere-server.sh).
        for pattern in "org.adempiere.server.application" "org.adempiere.server.product" "org.eclipse.equinox.launcher"; do
            while read -r orphan; do
                [[ -n "$orphan" && "$orphan" != "$$" ]] || continue
                echo "Stopping orphaned JVM (pid $orphan)..."
                kill "$orphan" 2>/dev/null || true
            done < <(pgrep -f "$pattern" 2>/dev/null || true)
        done
        sleep 2
        for pattern in "org.adempiere.server.application" "org.adempiere.server.product" "org.eclipse.equinox.launcher"; do
            while read -r orphan; do
                [[ -n "$orphan" && "$orphan" != "$$" ]] || continue
                kill -9 "$orphan" 2>/dev/null || true
            done < <(pgrep -f "$pattern" 2>/dev/null || true)
        done
    fi
}

stop_server

echo "Starting iDempiere server from ${SERVER_HOME} (log: ${LOG_FILE})..."
if [[ -z "${GRAPHQL_PROXY_UPSTREAM_URL:-}" ]]; then
    GRAPHQL_PROXY_UPSTREAM_URL="http://host.docker.internal:${EXTERNAL_MOCKS_PORT:-8081}/graphql-proxy"
    export GRAPHQL_PROXY_UPSTREAM_URL
    echo "GRAPHQL_PROXY_UPSTREAM_URL not set; defaulting to ${GRAPHQL_PROXY_UPSTREAM_URL}"
fi
cd "$SERVER_HOME"
nohup ./idempiere-server.sh >>"$LOG_FILE" 2>&1 &
echo $! >"$PID_FILE"
echo "iDempiere server started (pid $(cat "$PID_FILE"))."
