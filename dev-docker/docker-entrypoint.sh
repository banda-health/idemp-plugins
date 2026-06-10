#!/bin/bash
set -euo pipefail

# Eclipse/Maven/Studio state lives under /home/developer in the image (see ./dev.sh capture).
if [ "$(id -u)" = "0" ]; then
    mkdir -p /home/developer/.m2/repository /home/developer/eclipse-workspace /home/developer/jaspersoft-studio-workspace
    chown -R developer:developer /home/developer/.m2 /home/developer/eclipse-workspace /home/developer/jaspersoft-studio-workspace
    # Jaspersoft Studio zip ships JRE binaries without +x; launcher fails with JVM exit code 13.
    if [ -d /opt/jaspersoft-studio/features ]; then
        find /opt/jaspersoft-studio/features -type f -path '*/adoptopenjdk_jre/bin/*' -exec chmod a+x {} + 2>/dev/null || true
    fi
    if [ -f /usr/local/bin/ensure-build-volume-permissions.sh ]; then
        bash /usr/local/bin/ensure-build-volume-permissions.sh
    fi
    exec runuser -u developer -w /home/developer -- "$0" "$@"
fi

IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
SYNC_SCRIPT="${IDEMPIERE_HOME}/RUN_SyncDBDev.sh"

wait_for_db() {
    local retries="${MIGRATION_DB_WAIT_RETRIES:-60}"
    echo "Waiting for database on localhost:5432..."
    while [ "$retries" -gt 0 ]; do
        if pg_isready -h localhost -p 5432 -q 2>/dev/null; then
            echo "Database is ready."
            return 0
        fi
        retries=$((retries - 1))
        sleep 1
    done
    echo "Timed out waiting for database on localhost:5432 (is db-proxy running?)" >&2
    return 1
}

if [ "${RUN_MIGRATIONS_ON_START:-true}" = "true" ] && [ -s "${IDEMPIERE_HOME}/idempiere.properties" ]; then
    echo "Running iDempiere migrations (RUN_SyncDBDev.sh)..."
    wait_for_db
    cd "$IDEMPIERE_HOME"
    bash "$SYNC_SCRIPT"
elif [ "${RUN_MIGRATIONS_ON_START:-true}" = "true" ]; then
    echo "Skipping migrations: ${IDEMPIERE_HOME}/idempiere.properties not found (run Eclipse install first)."
fi

if [ "$#" -eq 0 ]; then
    set -- /opt/eclipse/eclipse
fi

exec "$@"
