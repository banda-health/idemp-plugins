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
  wait-ready      Poll OSGi console until Banda plugins are ACTIVE/RESOLVED (telnet, CI-style).
  test            Ensure iDempiere is running; run tests (default: GraphQL Vitest only).
  test-ci         Run CI test stack (root docker compose up; uses gitignored ./testing/ folder).
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
  $0 test                              # GraphQL Vitest only (default)
  $0 test -- visitReceiptReport.test.ts
  $0 test graphql                      # graphql SOAP + Vitest
  $0 test --all                        # base + graphql + reports
  $0 test --rebuild                    # restart server before tests
  $0 test-ci                 # CI workflow: pre-built image + ./testing/ staging
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
    # Bidirectional sync of shared keys between dev-docker/.env and root .env.
    bash "${DOCKER_DEV_DIR}/scripts/sync-env.sh" --quiet
    if [[ -f "${DOCKER_DEV_DIR}/.env" ]]; then
        set -a
        # shellcheck disable=SC1091
        source "${DOCKER_DEV_DIR}/.env"
        set +a
    fi
}

load_root_env() {
    if [[ -f "${SCRIPT_DIR}/.env" ]]; then
        set -a
        # shellcheck disable=SC1091
        source "${SCRIPT_DIR}/.env"
        set +a
    fi
}

idempiere_osgi_ready() {
    docker exec \
        -e IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}" \
        "$CONTAINER_NAME" \
        bash /usr/local/bin/wait-idempiere-ready.sh --once >/dev/null 2>&1
}

ensure_dev_idempiere() {
    local restart_server="${1:-false}"

    if [[ "$restart_server" != "true" ]] && idempiere_osgi_ready; then
        echo "iDempiere OSGi plugins already ready in '$CONTAINER_NAME'."
        return 0
    fi

    if docker container inspect "$CONTAINER_NAME" >/dev/null 2>&1; then
        local running
        running="$(docker inspect -f '{{.State.Running}}' "$CONTAINER_NAME" 2>/dev/null || echo false)"
        if [[ "$running" != "true" ]]; then
            HEADLESS=true start_stack
            wait_for_container
        fi
    else
        HEADLESS=true start_stack
        wait_for_container
    fi

    echo "Starting iDempiere server headlessly in '$CONTAINER_NAME'..."
    docker exec "$CONTAINER_NAME" bash /usr/local/bin/start-idempiere-server.sh
    cmd_wait_ready
}

run_dev_compose_up() {
    docker compose -f docker-compose.dev.yml up -d --build

    local test_container
    test_container="$(docker compose -f docker-compose.dev.yml ps -q test)"
    if [[ -z "$test_container" ]]; then
        echo "Dev test container did not start." >&2
        exit 1
    fi
}

exec_in_test_container() {
    docker compose -f docker-compose.dev.yml exec -T test bash -lc "$1"
}

# Vitest include is src/tests/**/*.test.ts — accept bare filenames from ./dev.sh test -- login.test.ts
normalize_vitest_args() {
    local -a result=()
    local arg
    for arg in "$@"; do
        if [[ "$arg" == *.test.ts && "$arg" != src/tests/* ]]; then
            if [[ -f "${SCRIPT_DIR}/graphql-test/testing/src/tests/processes/${arg}" ]]; then
                result+=("src/tests/processes/${arg}")
            else
                result+=("src/tests/${arg}")
            fi
        else
            result+=("$arg")
        fi
    done
    echo "${result[@]}"
}

run_test_suite() {
    local suite="$1"
    shift
    local -a vitest_args=("$@")

    run_dev_compose_up

    case "$suite" in
        all)
            echo "Running all test suites (base, graphql, reports)..."
            exec_in_test_container 'cd /app/base-test && ./runTests.sh'
            exec_in_test_container 'cd /app/graphql-test && npm install --no-audit --no-fund && ./runTests.sh'
            exec_in_test_container 'cd /app/reports-test && ./runTests.sh'
            ;;
        base)
            echo "Running base-test..."
            exec_in_test_container 'cd /app/base-test && ./runTests.sh'
            ;;
        graphql)
            echo "Running graphql-test (SOAP + Vitest)..."
            exec_in_test_container 'cd /app/graphql-test && npm install --no-audit --no-fund && ./runTests.sh'
            ;;
        reports)
            echo "Running reports-test..."
            exec_in_test_container 'cd /app/reports-test && ./runTests.sh'
            ;;
        vitest)
            read -r -a vitest_args <<<"$(normalize_vitest_args "${vitest_args[@]+"${vitest_args[@]}"}")"
            local quoted=""
            if ((${#vitest_args[@]} > 0)); then
                quoted="$(printf '%q ' "${vitest_args[@]}")"
            fi
            echo "Running GraphQL Vitest..."
            exec_in_test_container "cd /app/graphql-test && npm install --no-audit --no-fund && bash ./check-graphql-test-client.sh && npm test -- --run --reporter=verbose ${quoted}"
            ;;
        *)
            echo "Unknown test suite: $suite" >&2
            echo "Use: base, graphql, reports, vitest, or --all" >&2
            exit 1
            ;;
    esac
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

    if [[ "${HEADLESS:-false}" != "true" ]]; then
        configure_display
    fi

    local -a up_args=(-d)
    if [[ "${HEADLESS:-false}" == "true" ]]; then
        up_args+=(--force-recreate)
    fi

    case "${MODE}" in
        snapshot)
            echo "Starting dev stack via Docker Compose (frozen snapshot image)..."
            run_compose_stack "$compose_file_name" up "${up_args[@]}"
            ;;
        build)
            echo "Starting dev stack via Docker Compose (build from Dockerfile)..."
            export HOST_UID="${HOST_UID:-$(id -u)}"
            export HOST_GID="${HOST_GID:-$(id -g)}"
            echo "Building with HOST_UID=$HOST_UID HOST_GID=$HOST_GID"
            run_compose_stack "$compose_file_name" up "${up_args[@]}" --build
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
    wait_for_container

    local timeout="${WAIT_READY_TIMEOUT:-300}"
    echo "Waiting for iDempiere OSGi readiness in '$CONTAINER_NAME' (timeout ${timeout}s)..."
    docker exec \
        -e IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}" \
        -e WAIT_READY_TIMEOUT="${WAIT_READY_TIMEOUT:-300}" \
        -e WAIT_READY_INTERVAL="${WAIT_READY_INTERVAL:-5}" \
        "$CONTAINER_NAME" \
        bash /usr/local/bin/wait-idempiere-ready.sh
}

cmd_test() {
    local restart_server=false
    local suite="vitest"
    local -a vitest_args=()

    while [[ $# -gt 0 ]]; do
        case "$1" in
            --rebuild)
                restart_server=true
                shift
                ;;
            --all)
                suite="all"
                shift
                ;;
            --)
                shift
                vitest_args=("$@")
                break
                ;;
            -h|--help)
                cat <<EOF
Usage: $0 test [suite] [--rebuild] [-- vitest-args...]

Ensures iDempiere is running, starts docker-compose.dev.yml, and runs tests.
Does not run mvn verify or migrations — run ./dev.sh build and ./dev.sh migrate separately.

Suites (default: vitest — GraphQL Vitest only):
  (none)     GraphQL Vitest only (requires GraphQL test client in DB; see below)
  --all      base-test + graphql-test + reports-test (full SOAP + Vitest where applicable)
  base       base-test/runTests.sh only
  graphql    graphql-test/runTests.sh (SOAP Java tests + Vitest)
  reports    reports-test/runTests.sh only
  vitest     GraphQL Vitest only (same as default)

New database: run "$0 test graphql" once before Vitest-only runs. Vitest checks that
IDEMPIERE_GRAPHQL_TEST_CLIENT exists in ad_client (SOAP populates it).

Vitest file/pattern filters go after --:
  $0 test -- visitReceiptReport.test.ts
  $0 test vitest -- src/tests/processes/visitReceiptReport.test.ts

Options:
  --rebuild  Restart the iDempiere server even when HTTP is already up
EOF
                exit 0
                ;;
            base|graphql|reports|vitest|all)
                suite="$1"
                shift
                ;;
            *)
                if [[ "$suite" == "vitest" ]]; then
                    vitest_args+=("$1")
                    shift
                else
                    echo "Unknown argument: $1 (extra args only allowed for vitest suite)" >&2
                    echo "Run: $0 test --help" >&2
                    exit 1
                fi
                ;;
        esac
    done

    load_env
    local dev_container_name="${CONTAINER_NAME:-idempiere-development}"
    load_root_env
    CONTAINER_NAME="$dev_container_name"

    if [[ ! -f "${SCRIPT_DIR}/.env" ]]; then
        echo "Missing .env in repo root (auto-created from .env.example when possible)." >&2
        exit 1
    fi

    local port="${IDEMPIERE_HTTP_PORT:-8080}"
    export IDEMPIERE_ENDPOINT="${IDEMPIERE_ENDPOINT:-http://host.docker.internal:${port}}"

    ensure_dev_idempiere "$restart_server"

    cd "$SCRIPT_DIR"
    run_test_suite "$suite" "${vitest_args[@]}"
}

cmd_test_ci() {
    cd "$SCRIPT_DIR"
    if [[ ! -f .env ]]; then
        echo "Missing .env in repo root (auto-created from .env.example when possible)." >&2
        exit 1
    fi
    bash "${SCRIPT_DIR}/scripts/compose.sh" up "$@"
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
    test-ci)
        shift
        cmd_test_ci "$@"
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
