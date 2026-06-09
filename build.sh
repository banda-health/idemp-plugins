#!/bin/bash

set -euo pipefail

DOCKER_DEV_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/dev-docker" && pwd)"
cd "$DOCKER_DEV_DIR"

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"
IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
PLUGINS_DIR="${PLUGINS_CONTAINER_DIR:-/workspace/idemp-banda}"

usage() {
    cat <<EOF
Usage: $0 [--skip-tests] [-- maven_args ...]

Build BandaGo plugins and deploy artifacts into the dev container's iDempiere home.

Equivalent to running inside the container:
  mvn verify -Didempiere.home.dir=$IDEMPIERE_HOME -Dgitbuildhook.gitconfig.skip=true

This builds plugins, compiles reports, and copies data/migration/reports into
$IDEMPIERE_HOME (same as host-side mvn verify with idempiere.home.dir set).

  --skip-tests   Pass -DskipTests to Maven (faster iteration)
  --             Pass remaining args to Maven (e.g. -pl base,graphql)

Requires the dev container from ./eclipse.sh to be running.
EOF
}

MAVEN_ARGS=()

while [[ $# -gt 0 ]]; do
    case "$1" in
        --skip-tests)
            MAVEN_ARGS+=("-DskipTests")
            shift
            ;;
        -h|--help)
            usage
            exit 0
            ;;
        --)
            shift
            MAVEN_ARGS+=("$@")
            break
            ;;
        -*)
            MAVEN_ARGS+=("$1")
            shift
            ;;
        *)
            MAVEN_ARGS+=("$1")
            shift
            ;;
    esac
done

wait_for_container() {
    local retries=30
    while [ "$retries" -gt 0 ]; do
        if docker container inspect "$CONTAINER_NAME" >/dev/null 2>&1; then
            local running
            running="$(docker inspect -f '{{.State.Running}}' "$CONTAINER_NAME" 2>/dev/null || echo false)"
            if [ "$running" = "true" ]; then
                return 0
            fi
        fi
        retries=$((retries - 1))
        sleep 1
    done
    echo "Container '$CONTAINER_NAME' is not running." >&2
    echo "Start it with ./eclipse.sh first." >&2
    exit 1
}

wait_for_container

docker exec -u root "$CONTAINER_NAME" bash /usr/local/bin/ensure-build-volume-permissions.sh

echo "Running mvn verify in '$CONTAINER_NAME' ($PLUGINS_DIR)..."
docker exec \
    -u developer \
    -w "$PLUGINS_DIR" \
    "$CONTAINER_NAME" \
    mvn verify \
        -Didempiere.home.dir="$IDEMPIERE_HOME" \
        -Dbanda.skip.testing.staging=true \
        -Dgitbuildhook.gitconfig.skip=true \
        "${MAVEN_ARGS[@]+"${MAVEN_ARGS[@]}"}"
