#!/bin/bash

set -euo pipefail

DOCKER_DEV_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/dev-docker" && pwd)"
cd "$DOCKER_DEV_DIR"

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"
BUILD_OVERLAYS_FILE="docker-compose.build-overlays.yml"
IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
SYNC_SCRIPT="${IDEMPIERE_HOME}/RUN_SyncDBDev.sh"

usage() {
    cat <<EOF
Usage: $0 [--snapshot|-s] [--build|-b] [--no-start] [-- migration_folder ...]

Run pending iDempiere DB migrations via RUN_SyncDBDev.sh inside the dev container.

  --snapshot, -s   Use frozen image (docker-compose.snapshot.yml) [default]
  --build, -b      Build and use Dockerfile (docker-compose.yml)
  --no-start       Do not start compose; require an already-running container
  --               Pass remaining args to RUN_SyncDBDev.sh (optional migration folders)

Migrations also run automatically on container start when idempiere.properties exists.
EOF
}

MODE="snapshot"
START_CONTAINER=true
MIGRATE_ARGS=()

while [[ $# -gt 0 ]]; do
    case "$1" in
        --snapshot|-s)
            MODE="snapshot"
            shift
            ;;
        --build|-b)
            MODE="build"
            shift
            ;;
        --no-start)
            START_CONTAINER=false
            shift
            ;;
        -h|--help)
            usage
            exit 0
            ;;
        --)
            shift
            MIGRATE_ARGS+=("$@")
            break
            ;;
        -*)
            echo "Unknown option: $1" >&2
            usage >&2
            exit 1
            ;;
        *)
            MIGRATE_ARGS+=("$1")
            shift
            ;;
    esac
done

compose_file() {
    case "$MODE" in
        snapshot) echo "docker-compose.snapshot.yml" ;;
        build) echo "docker-compose.yml" ;;
    esac
}

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
    exit 1
}

if [ "$START_CONTAINER" = true ]; then
    COMPOSE_FILE="$(compose_file)"
    case "$MODE" in
        snapshot)
            echo "Starting dev container (frozen snapshot)..."
            docker compose -f "$COMPOSE_FILE" -f "$BUILD_OVERLAYS_FILE" up -d
            ;;
        build)
            echo "Starting dev container (build from Dockerfile)..."
            export HOST_UID="${HOST_UID:-$(id -u)}"
            export HOST_GID="${HOST_GID:-$(id -g)}"
            echo "Building with HOST_UID=$HOST_UID HOST_GID=$HOST_GID"
            docker compose -f "$COMPOSE_FILE" -f "$BUILD_OVERLAYS_FILE" up -d --build
            ;;
    esac
fi

wait_for_container

echo "Running RUN_SyncDBDev.sh in '$CONTAINER_NAME'..."
docker exec \
    -w "$IDEMPIERE_HOME" \
    "$CONTAINER_NAME" \
    bash "$SYNC_SCRIPT" "${MIGRATE_ARGS[@]+"${MIGRATE_ARGS[@]}"}"
