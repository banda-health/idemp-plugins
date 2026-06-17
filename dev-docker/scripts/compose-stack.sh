#!/usr/bin/env bash
# Shared compose -f arguments for the dev stack (./dev.sh).
# Source from dev.sh after cd into dev-docker/.

POSTGRES_OVERLAY_FILE="docker-compose.postgres.yml"
HEADLESS_OVERLAY_FILE="docker-compose.headless.yml"

# Run docker compose with the standard dev stack file merge order.
# Usage: run_compose_stack <base-compose.yml> <compose-subcommand> [args...]
# Set HEADLESS=true to merge docker-compose.headless.yml (no Eclipse GUI).
run_compose_stack() {
    local base_file="$1"
    shift

    local -a compose_args=(-f "$base_file")
    if [[ "${DB_TARGET:-compose}" == "compose" ]]; then
        compose_args+=(-f "$POSTGRES_OVERLAY_FILE")
    fi
    if [[ "${HEADLESS:-false}" == "true" ]]; then
        compose_args+=(-f "$HEADLESS_OVERLAY_FILE")
    fi

    docker compose "${compose_args[@]}" "$@"
}

# Tear down using compose files recorded on the running container (handles DB_TARGET changes).
# Usage: run_compose_down <fallback-base-compose.yml>
run_compose_down() {
    local fallback_base_file="$1"
    local container="${CONTAINER_NAME:-idempiere-development}"
    local config_files
    config_files="$(docker inspect -f '{{index .Config.Labels "com.docker.compose.project.config_files"}}' "$container" 2>/dev/null || true)"

    if [[ -n "$config_files" && "$config_files" != "<no value>" ]]; then
        local -a compose_args=()
        IFS=',' read -ra files <<< "$config_files"
        for f in "${files[@]}"; do
            compose_args+=(-f "$f")
        done
        docker compose "${compose_args[@]}" down
        return
    fi

    run_compose_stack "$fallback_base_file" down
}
