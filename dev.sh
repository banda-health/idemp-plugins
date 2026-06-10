#!/bin/bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
DOCKER_DEV_DIR="${SCRIPT_DIR}/dev-docker"
cd "$DOCKER_DEV_DIR"

# shellcheck disable=SC1091
source "${DOCKER_DEV_DIR}/scripts/compose-stack.sh"

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"
IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
PLUGINS_DIR="${PLUGINS_CONTAINER_DIR:-/workspace/idemp-banda}"
REPORTS_DIR="${REPORTS_CONTAINER_DIR:-/workspace/idemp-banda/reports}"
SYNC_SCRIPT="${IDEMPIERE_HOME}/RUN_SyncDBDev.sh"
JASPERSOFT_STUDIO_HOME="${JASPERSOFT_STUDIO_HOME:-/opt/jaspersoft-studio}"
JASPERSOFT_STUDIO_BIN="${JASPERSOFT_STUDIO_BIN:-${JASPERSOFT_STUDIO_HOME}/Jasper Studio}"
JASPERSOFT_WORKSPACE="${JASPERSOFT_WORKSPACE:-/home/developer/jaspersoft-studio-workspace}"

MODE="snapshot"
ACTION="up"
START_CONTAINER=true
MAVEN_ARGS=()
MIGRATE_ARGS=()

usage() {
    cat <<EOF
Usage: $0 <command> [options] [-- extra-args...]

Commands:
  up, start       Start the dev container (default). Launches Eclipse when the container starts.
  down            Stop the running dev stack.
  eclipse         Start the dev container if needed (same as up).
  jasper          Launch Jaspersoft Studio 6.20.3 in the running container (reports workspace).
  build           Run mvn verify inside the container (plugins, reports, data, migrations).
  migrate         Run RUN_SyncDBDev.sh for pending DB migrations.
  wait-ready      Poll HTTP until iDempiere responds (dev port from dev-docker/.env).
  test            Run CI test stack (docker compose up at repo root).
  download-jasper Pre-download Studio 6.20.3 zip to dev-docker/vendor/ (optional offline cache).
  capture         Freeze the running dev container (docker commit → IDEMPIERE_DEV_IMAGE in .env).
  push            Push IDEMPIERE_DEV_IMAGE to the registry (run after capture).

Global options (up, eclipse, migrate):
  --snapshot, -s   Use frozen image (docker-compose.snapshot.yml) [default]
  --build, -b      Build from Dockerfile and run (docker-compose.yml) — not the snapshot
  --no-start       Do not start compose; require an already-running container (migrate only)

Build options:
  --skip-tests     Pass -DskipTests to Maven

Examples:
  $0                          # start dev stack (snapshot image)
  $0 --build                  # rebuild image and start
  $0 jasper                   # open Jaspersoft Studio for report design
  $0 build --skip-tests
  $0 build -- -pl base,graphql
  $0 migrate -- migration/local-folder
  $0 wait-ready
  $0 test
  $0 capture                            # commits to IDEMPIERE_DEV_IMAGE from dev-docker/.env
  $0 push                               # docker push that image
  IMAGE_TAG=snapshot-step4 $0 capture   # same repo, different tag (partial save)
  $0 down

Jaspersoft Studio 6.20.3 is installed automatically on ./dev.sh --build (no login required).
Maven still compiles reports with JasperReports 6.17.0 (see reports/pom.xml).
Optional: $0 download-jasper to cache the zip locally; override URL via JASPERSOFT_STUDIO_URL in dev-docker/.env.
EOF
}

compose_file() {
    case "$MODE" in
        snapshot) echo "docker-compose.snapshot.yml" ;;
        build) echo "docker-compose.yml" ;;
    esac
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
    snapshot_q="$(run_compose_stack docker-compose.snapshot.yml ps -q 2>/dev/null || true)"
    build_q="$(run_compose_stack docker-compose.yml ps -q 2>/dev/null || true)"

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

configure_display() {
    local os
    os="$(uname -s)"
    echo "Detecting OS: $os"

    case "${os}" in
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
                echo "Error: xhost not found. Please install XQuartz." >&2
                exit 1
            fi
            export DISPLAY=host.docker.internal:0
            ;;
        CYGWIN*|MINGW32*|MSYS*|MINGW*)
            echo "Configuring for Windows (WSL/Git Bash)..."
            export DISPLAY=${DISPLAY:-:0}
            ;;
        *)
            echo "Unknown OS: ${os}. Using system defaults."
            ;;
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
    echo "Start it with: $0 up" >&2
    exit 1
}

load_env() {
    if [[ -f "${DOCKER_DEV_DIR}/.env" ]]; then
        set -a
        # shellcheck disable=SC1091
        source "${DOCKER_DEV_DIR}/.env"
        set +a
    fi
}

# Resolve docker commit target: IDEMPIERE_DEV_IMAGE from .env, with optional IMAGE_REPO/IMAGE_TAG overrides.
resolve_capture_image() {
    local repo tag

    if [[ -n "${IDEMPIERE_DEV_IMAGE:-}" ]]; then
        if [[ "$IDEMPIERE_DEV_IMAGE" == *:* ]]; then
            tag="${IDEMPIERE_DEV_IMAGE##*:}"
            repo="${IDEMPIERE_DEV_IMAGE%:*}"
        else
            repo="$IDEMPIERE_DEV_IMAGE"
            tag="latest"
        fi
    else
        repo="dev-docker-idempiere"
        tag="snapshot"
    fi

    CAPTURE_IMAGE_REPO="${IMAGE_REPO:-$repo}"
    CAPTURE_IMAGE_TAG="${IMAGE_TAG:-$tag}"
}

start_stack() {
    local compose_file_name
    compose_file_name="$(compose_file)"

    configure_display

    case "${MODE}" in
        snapshot)
            echo "Starting dev stack via Docker Compose (frozen snapshot image)..."
            run_compose_stack "$compose_file_name" up -d
            ;;
        build)
            echo "Starting dev stack via Docker Compose (build from Dockerfile)..."
            export HOST_UID="${HOST_UID:-$(id -u)}"
            export HOST_GID="${HOST_GID:-$(id -g)}"
            echo "Building with HOST_UID=$HOST_UID HOST_GID=$HOST_GID"
            run_compose_stack "$compose_file_name" up -d --build
            ;;
    esac
}

cmd_down() {
    load_env
    local compose_file_name
    if ! compose_file_name="$(detect_compose_file)"; then
        echo "No dev stack is running."
        exit 0
    fi

    echo "Stopping dev stack ($compose_file_name)..."
    run_compose_down "$compose_file_name"
}

cmd_up() {
    start_stack
}

cmd_jasper() {
    load_env
    wait_for_container
    configure_display

    local studio_bin="$JASPERSOFT_STUDIO_BIN"
    if ! docker exec "$CONTAINER_NAME" test -x "$studio_bin"; then
        for candidate in \
            "${JASPERSOFT_STUDIO_HOME}/Jasper Studio" \
            "${JASPERSOFT_STUDIO_HOME}/Jaspersoft Studio" \
            "${JASPERSOFT_STUDIO_HOME}/jaspersoft-studio"; do
            if docker exec "$CONTAINER_NAME" test -x "$candidate"; then
                studio_bin="$candidate"
                break
            fi
        done
    fi
    if ! docker exec "$CONTAINER_NAME" test -x "$studio_bin"; then
        echo "Jaspersoft Studio is not installed in this image." >&2
        echo "Rebuild with: $0 --build" >&2
        exit 1
    fi

    echo "Launching Jaspersoft Studio in '$CONTAINER_NAME'..."
    docker exec -d \
        -u developer \
        -e DISPLAY="${DISPLAY:-host.docker.internal:0}" \
        -w "$REPORTS_DIR" \
        "$CONTAINER_NAME" \
        "$studio_bin" \
        -data "$JASPERSOFT_WORKSPACE"
}

cmd_build() {
    load_env
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
}

cmd_migrate() {
    if [ "$START_CONTAINER" = true ]; then
        start_stack
    fi

    wait_for_container

    echo "Running RUN_SyncDBDev.sh in '$CONTAINER_NAME'..."
    docker exec \
        -w "$IDEMPIERE_HOME" \
        "$CONTAINER_NAME" \
        bash "$SYNC_SCRIPT" "${MIGRATE_ARGS[@]+"${MIGRATE_ARGS[@]}"}"
}


cmd_wait_ready() {
    load_env
    local port="${IDEMPIERE_HTTP_PORT:-8080}"
    local timeout="${WAIT_READY_TIMEOUT:-300}"
    local interval="${WAIT_READY_INTERVAL:-5}"
    local url="http://localhost:${port}/"
    local elapsed=0

    echo "Waiting for iDempiere at ${url} (timeout ${timeout}s, interval ${interval}s)..."
    while true; do
        if curl -sf -o /dev/null "$url"; then
            echo "iDempiere is ready at ${url}"
            return 0
        fi
        if (( elapsed >= timeout )); then
            echo "Timed out after ${timeout}s waiting for ${url}" >&2
            exit 1
        fi
        sleep "$interval"
        elapsed=$((elapsed + interval))
    done
}

cmd_test() {
    cd "$SCRIPT_DIR"
    if [[ ! -f .env && -f .env.example ]]; then
        echo "Missing .env in repo root. Create it from the example:" >&2
        echo "  cp .env.example .env" >&2
        exit 1
    fi
    docker compose up "$@"
}

cmd_download_jasper() {
    load_env
    bash "${DOCKER_DEV_DIR}/scripts/download-jaspersoft-studio.sh"
}

cmd_push() {
    load_env
    resolve_capture_image
    local full_image="${CAPTURE_IMAGE_REPO}:${CAPTURE_IMAGE_TAG}"
    if ! docker image inspect "$full_image" >/dev/null 2>&1; then
        echo "Local image not found: $full_image" >&2
        echo "Run ./dev.sh capture first (or set IDEMPIERE_DEV_IMAGE in dev-docker/.env)." >&2
        exit 1
    fi
    echo "Pushing $full_image ..."
    docker push "$full_image"
}

cmd_capture() {
    load_env
    if ! docker container inspect "$CONTAINER_NAME" >/dev/null 2>&1; then
        echo "Container '$CONTAINER_NAME' does not exist." >&2
        echo "Start the dev stack first (e.g. $0 --build during image setup)." >&2
        exit 1
    fi
    resolve_capture_image
    echo "Capture target: ${CAPTURE_IMAGE_REPO}:${CAPTURE_IMAGE_TAG}"
    if [[ -n "${IDEMPIERE_DEV_IMAGE:-}" && "${CAPTURE_IMAGE_REPO}:${CAPTURE_IMAGE_TAG}" != "$IDEMPIERE_DEV_IMAGE" ]]; then
        echo "(from IDEMPIERE_DEV_IMAGE with IMAGE_REPO/IMAGE_TAG override)"
    elif [[ -n "${IDEMPIERE_DEV_IMAGE:-}" ]]; then
        echo "(from IDEMPIERE_DEV_IMAGE in dev-docker/.env)"
    fi
    CONTAINER_NAME="$CONTAINER_NAME" \
        IMAGE_REPO="$CAPTURE_IMAGE_REPO" \
        IMAGE_TAG="$CAPTURE_IMAGE_TAG" \
        bash "${DOCKER_DEV_DIR}/scripts/capture-container-state.sh"
}

parse_global_options() {
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
                return 0
                ;;
            *)
                return 0
                ;;
        esac
    done
}

parse_build_options() {
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
                return 0
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
}

parse_migrate_options() {
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
                return 0
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
}

if [[ $# -eq 0 ]]; then
    load_env
    cmd_up
    exit 0
fi

case "$1" in
    up|start|eclipse)
        ACTION="$1"
        shift
        load_env
        parse_global_options "$@"
        cmd_up
        ;;
    down)
        shift
        cmd_down
        ;;
    jasper)
        shift
        load_env
        parse_global_options "$@"
        cmd_jasper
        ;;
    build)
        shift
        load_env
        parse_build_options "$@"
        cmd_build
        ;;
    migrate)
        shift
        load_env
        parse_migrate_options "$@"
        cmd_migrate
        ;;
    download-jasper)
        shift
        cmd_download_jasper
        ;;
    capture|capture-snapshot)
        shift
        cmd_capture
        ;;
    push)
        shift
        cmd_push
        ;;
    wait-ready)
        shift
        cmd_wait_ready
        ;;
    test)
        shift
        cmd_test "$@"
        ;;
    -h|--help|help)
        usage
        ;;
    --snapshot|-s|--build|-b|--down|--no-start)
        # Backward compatibility: flags without a command (e.g. ./dev.sh --build)
        load_env
        parse_global_options "$@"
        if [[ "$ACTION" == "down" ]]; then
            cmd_down
        else
            cmd_up
        fi
        ;;
    *)
        echo "Unknown command: $1" >&2
        usage >&2
        exit 1
        ;;
esac
