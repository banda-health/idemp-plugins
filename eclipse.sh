#!/bin/bash

set -euo pipefail

DOCKER_DEV_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/docker-dev" && pwd)"
cd "$DOCKER_DEV_DIR"

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"

usage() {
    cat <<EOF
Usage: $0 [--snapshot|-s] [--build|-b] [--down]

  --snapshot, -s   Run from frozen image (docker-compose.snapshot.yml) [default]
  --build, -b      Build and run from Dockerfile (docker-compose.yml)
  --down           Stop the running dev stack (auto-detects compose file)
EOF
}

compose_file_from_label() {
    local config_files
    config_files="$(docker inspect -f '{{index .Config.Labels "com.docker.compose.project.config_files"}}' "$CONTAINER_NAME" 2>/dev/null || true)"
    if [[ -n "$config_files" && "$config_files" != "<no value>" ]]; then
        basename "${config_files%%,*}"
    fi
}

detect_compose_file() {
    local from_label
    from_label="$(compose_file_from_label)"
    if [[ -n "$from_label" ]]; then
        echo "$from_label"
        return 0
    fi

    local snapshot_q build_q
    snapshot_q="$(docker compose -f docker-compose.snapshot.yml ps -q 2>/dev/null || true)"
    build_q="$(docker compose -f docker-compose.yml ps -q 2>/dev/null || true)"

    if [[ -n "$snapshot_q" && -z "$build_q" ]]; then
        echo "docker-compose.snapshot.yml"
        return 0
    fi
    if [[ -n "$build_q" && -z "$snapshot_q" ]]; then
        echo "docker-compose.yml"
        return 0
    fi

    return 1
}

spin_down() {
    local compose_file
    if ! compose_file="$(detect_compose_file)"; then
        echo "No Eclipse dev stack is running."
        exit 0
    fi

    echo "Stopping Eclipse dev stack ($compose_file)..."
    docker compose -f "$compose_file" down
}

MODE="snapshot"
ACTION="start"

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
        --down)
            ACTION="down"
            shift
            ;;
        -h|--help)
            usage
            exit 0
            ;;
        *)
            echo "Unknown option: $1"
            usage
            exit 1
            ;;
    esac
done

if [[ "$ACTION" == "down" ]]; then
    spin_down
    exit 0
fi

# Detect Operating System
OS="$(uname -s)"
echo "Detecting OS: $OS"

case "${OS}" in
    Linux*)
        echo "Configuring X11 for Linux..."
        xhost +local:docker > /dev/null
        export DISPLAY=${DISPLAY:-:0}
        ;;
    Darwin*)
        echo "Configuring X11 for macOS (XQuartz)..."
        if command -v xhost >/dev/null 2>&1; then
            xhost +localhost > /dev/null
        else
            echo "Error: xhost not found. Please install XQuartz."
            exit 1
        fi
        export DISPLAY=host.docker.internal:0
        ;;
    CYGWIN*|MINGW32*|MSYS*|MINGW*)
        echo "Configuring for Windows (WSL/Git Bash)..."
        export DISPLAY=${DISPLAY:-:0}
        ;;
    *)
        echo "Unknown OS: ${OS}. Using system defaults."
        ;;
esac

case "${MODE}" in
    snapshot)
        echo "Starting Eclipse via Docker Compose (frozen snapshot image)..."
        docker compose -f docker-compose.snapshot.yml up -d
        ;;
    build)
        echo "Starting Eclipse via Docker Compose (build from Dockerfile)..."
        docker compose up -d --build
        ;;
esac
