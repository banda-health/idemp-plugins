#!/usr/bin/env bash
# Bidirectional sync between dev-docker/.env and repo root .env.
#
# PRECEDENCE (when shared values disagree):
#   Compare file modification times. The newer file wins and its shared values
#   are propagated to the other file. If mtimes are equal, dev-docker/.env wins.
#   After a sync, the updated file's mtime is aligned to the winner so the
#   next run stays idempotent until a file is edited again.
#
# SHARED KEY MAPPINGS (same keys or derived pairs):
#   dev-docker                    ↔ root
#   IDEMPIERE_HTTP_PORT           ↔ IDEMPIERE_ENDPOINT (http://host.docker.internal:<port>)
#   DB_UPSTREAM_DATABASE          ↔ DB_NAME
#   DB_UPSTREAM_PASSWORD          ↔ IDEMPIERE_DATABASE_PASSWORD
#   DB_UPSTREAM_ADMIN_PASSWORD    ↔ POSTGRES_PASSWORD
#   DB_HOST_PORT (DB_TARGET=host) ↔ POSTGRES_PORT
#   DB_TARGET=host                ↔ POSTGRES_HOST=host.docker.internal
#   DB_TARGET=compose             ↔ POSTGRES_HOST=postgres
#   IDEMPIERE_USER                ↔ IDEMPIERE_USER
#   IDEMPIERE_USER_PASSWORD       ↔ IDEMPIERE_USER_PASSWORD
#   IDEMPIERE_GRAPHQL_TEST_CLIENT ↔ IDEMPIERE_GRAPHQL_TEST_CLIENT
#   EXTERNAL_MOCKS_PORT           ↔ EXTERNAL_MOCKS_PORT
#
# DEV-ONLY (never copied): IDEMPIERE_HOME, PLUGINS_*, RUN_MIGRATIONS_ON_START,
#   DB_COMPOSE_HOST, IDEMPIERE_DEV_IMAGE, IDEMPIERE_DB_IMAGE, HOST_UID/GID, ...
#
# ROOT-ONLY (never copied): CONTAINER_NAME, IDEMPIERE_FRESH_DB, IDEMPIERE_VERSION,
#   IDEMPIERE_PORT, EXTERNAL_MOCKS_ENDPOINT, OCL_*, YOUTRACK_TOKEN, ...
#
# Invoked automatically (silent) from dev.sh load_env and scripts/compose.sh.
# Diagnostics: ./dev-docker/scripts/sync-env.sh --dry-run | --check
#
# See dev-docker/.env.example and root .env.example for cross-references.

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
DEV_DOCKER_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"
REPO_ROOT="$(cd "${DEV_DOCKER_DIR}/.." && pwd)"
DEV_ENV="${DEV_DOCKER_DIR}/.env"
ROOT_ENV="${REPO_ROOT}/.env"
DEV_EXAMPLE="${DEV_DOCKER_DIR}/.env.example"
ROOT_EXAMPLE="${REPO_ROOT}/.env.example"

DRY_RUN=false
CHECK_ONLY=false
QUIET=false

while [[ $# -gt 0 ]]; do
    case "$1" in
        --dry-run|-n) DRY_RUN=true; shift ;;
        --check) CHECK_ONLY=true; shift ;;
        --quiet|-q) QUIET=true; shift ;;
        -h|--help)
            sed -n '1,34p' "$0" | tail -n +2
            exit 0
            ;;
        *)
            echo "Unknown option: $1" >&2
            exit 1
            ;;
    esac
done

# Read KEY=value from an env file (last wins; strips optional quotes).
read_env_var() {
    local file="$1" key="$2"
    local line value
    line="$(grep -E "^${key}=" "$file" 2>/dev/null | tail -1 || true)"
    [[ -n "$line" ]] || return 1
    value="${line#*=}"
    if [[ "$value" == \"*\" && "$value" == *\" ]]; then
        value="${value:1:${#value}-2}"
    elif [[ "$value" == \'*\' && "$value" == *\' ]]; then
        value="${value:1:${#value}-2}"
    fi
    printf '%s' "$value"
}

# Escape a value for safe sourcing via `set -a; source .env`.
format_env_value() {
    local value="$1"
    if [[ "$value" =~ [[:space:]\"\'\$\\] ]]; then
        value="${value//\\/\\\\}"
        value="${value//\"/\\\"}"
        printf '"%s"' "$value"
    else
        printf '%s' "$value"
    fi
}

# Replace or append KEY=value in an env file, preserving other lines.
set_env_var() {
    local file="$1" key="$2" value="$3"
    local tmp replaced=false formatted

    formatted="$(format_env_value "$value")"

    if [[ ! -f "$file" ]]; then
        printf '%s=%s\n' "$key" "$formatted" >>"$file"
        return 0
    fi

    tmp="$(mktemp)"
    while IFS= read -r line || [[ -n "$line" ]]; do
        if [[ "$line" =~ ^${key}= ]]; then
            printf '%s=%s\n' "$key" "$formatted"
            replaced=true
        else
            printf '%s\n' "$line"
        fi
    done <"$file" >"$tmp"

    if [[ "$replaced" == false ]]; then
        printf '\n%s=%s\n' "$key" "$formatted" >>"$tmp"
    fi

    mv "$tmp" "$file"
}

endpoint_from_port() {
    printf 'http://host.docker.internal:%s' "${1:-8080}"
}

port_from_endpoint() {
    local endpoint="${1:-}"
    if [[ "$endpoint" =~ :([0-9]+)(/|$) ]]; then
        echo "${BASH_REMATCH[1]}"
    else
        echo "8080"
    fi
}

ensure_env_files() {
    if [[ ! -f "$DEV_ENV" && -f "$DEV_EXAMPLE" ]]; then
        if [[ "$DRY_RUN" == true || "$CHECK_ONLY" == true ]]; then
            [[ "$QUIET" == false ]] && echo "(would create ${DEV_ENV} from .env.example)"
        else
            cp "$DEV_EXAMPLE" "$DEV_ENV"
        fi
    fi
    if [[ ! -f "$ROOT_ENV" && -f "$ROOT_EXAMPLE" ]]; then
        if [[ "$DRY_RUN" == true || "$CHECK_ONLY" == true ]]; then
            [[ "$QUIET" == false ]] && echo "(would create ${ROOT_ENV} from .env.example)"
        else
            cp "$ROOT_EXAMPLE" "$ROOT_ENV"
        fi
    fi
}

file_mtime() {
    stat -c %Y "$1" 2>/dev/null || stat -f %m "$1"
}

# Populate associative array name with dev→root key/value pairs derived from dev file.
build_dev_to_root_plan() {
    local dev_file="$1"
    local -n _plan="$2"
    local db_target http_port host_port

    _plan=()
    db_target="$(read_env_var "$dev_file" DB_TARGET || echo compose)"
    http_port="$(read_env_var "$dev_file" IDEMPIERE_HTTP_PORT || echo 8080)"

    _plan[IDEMPIERE_ENDPOINT]="$(endpoint_from_port "$http_port")"

    if v="$(read_env_var "$dev_file" DB_UPSTREAM_DATABASE)"; then _plan[DB_NAME]="$v"; fi
    if v="$(read_env_var "$dev_file" DB_UPSTREAM_PASSWORD)"; then _plan[IDEMPIERE_DATABASE_PASSWORD]="$v"; fi
    if v="$(read_env_var "$dev_file" DB_UPSTREAM_ADMIN_PASSWORD)"; then _plan[POSTGRES_PASSWORD]="$v"; fi

    if [[ "$db_target" == host ]]; then
        _plan[POSTGRES_HOST]="host.docker.internal"
        if v="$(read_env_var "$dev_file" DB_HOST_PORT)"; then _plan[POSTGRES_PORT]="$v"; fi
    fi

    for key in IDEMPIERE_USER IDEMPIERE_USER_PASSWORD IDEMPIERE_GRAPHQL_TEST_CLIENT EXTERNAL_MOCKS_PORT; do
        if v="$(read_env_var "$dev_file" "$key")"; then _plan[$key]="$v"; fi
    done
}

# Populate associative array name with root→dev key/value pairs derived from root file.
build_root_to_dev_plan() {
    local root_file="$1"
    local -n _plan="$2"
    local endpoint postgres_host postgres_port

    _plan=()
    if endpoint="$(read_env_var "$root_file" IDEMPIERE_ENDPOINT)"; then
        _plan[IDEMPIERE_HTTP_PORT]="$(port_from_endpoint "$endpoint")"
    fi

    if v="$(read_env_var "$root_file" DB_NAME)"; then _plan[DB_UPSTREAM_DATABASE]="$v"; fi
    if v="$(read_env_var "$root_file" IDEMPIERE_DATABASE_PASSWORD)"; then _plan[DB_UPSTREAM_PASSWORD]="$v"; fi
    if v="$(read_env_var "$root_file" POSTGRES_PASSWORD)"; then _plan[DB_UPSTREAM_ADMIN_PASSWORD]="$v"; fi

    if postgres_host="$(read_env_var "$root_file" POSTGRES_HOST)"; then
        case "$postgres_host" in
            host.docker.internal|localhost|127.0.0.1)
                _plan[DB_TARGET]="host"
                if postgres_port="$(read_env_var "$root_file" POSTGRES_PORT)"; then
                    _plan[DB_HOST_PORT]="$postgres_port"
                fi
                ;;
            postgres|*)
                _plan[DB_TARGET]="compose"
                ;;
        esac
    fi

    for key in IDEMPIERE_USER IDEMPIERE_USER_PASSWORD IDEMPIERE_GRAPHQL_TEST_CLIENT EXTERNAL_MOCKS_PORT; do
        if v="$(read_env_var "$root_file" "$key")"; then _plan[$key]="$v"; fi
    done
}

plan_matches_file() {
    local file="$1"
    local -n _plan="$2"
    local key expected current

    for key in "${!_plan[@]}"; do
        expected="${_plan[$key]}"
        current="$(read_env_var "$file" "$key" 2>/dev/null || true)"
        if [[ "$current" != "$expected" ]]; then
            return 1
        fi
    done
    return 0
}

apply_plan() {
    local file="$1"
    local -n _plan="$2"
    local key expected current count=0

    for key in "${!_plan[@]}"; do
        expected="${_plan[$key]}"
        current="$(read_env_var "$file" "$key" 2>/dev/null || true)"
        if [[ "$current" != "$expected" ]]; then
            count=$((count + 1))
            if [[ "$CHECK_ONLY" == true ]]; then
                echo "out of sync: ${file##*/} ${key} (current=${current:-<unset>} expected=${expected})" >&2
            elif [[ "$DRY_RUN" == true ]]; then
                echo "would set ${file##*/} ${key}=${expected}" >&2
            else
                set_env_var "$file" "$key" "$expected"
            fi
        fi
    done
    echo "$count"
}

if [[ ! -f "$DEV_ENV" && ! -f "$ROOT_ENV" ]]; then
    exit 0
fi

ensure_env_files

if [[ ! -f "$DEV_ENV" || ! -f "$ROOT_ENV" ]]; then
    [[ "$CHECK_ONLY" == true ]] && echo "env files missing; cannot check sync" >&2 && exit 1
    exit 0
fi

declare -A DEV_TO_ROOT=()
declare -A ROOT_TO_DEV=()
build_dev_to_root_plan "$DEV_ENV" DEV_TO_ROOT
build_root_to_dev_plan "$ROOT_ENV" ROOT_TO_DEV

root_ok=false
dev_ok=false
plan_matches_file "$ROOT_ENV" DEV_TO_ROOT && root_ok=true
plan_matches_file "$DEV_ENV" ROOT_TO_DEV && dev_ok=true

if [[ "$root_ok" == true && "$dev_ok" == true ]]; then
    [[ "$CHECK_ONLY" == true && "$QUIET" == false ]] && echo "dev-docker/.env and root .env are in sync"
    exit 0
fi

dev_mtime="$(file_mtime "$DEV_ENV")"
root_mtime="$(file_mtime "$ROOT_ENV")"
winner="" loser="" plan_name=""

if (( dev_mtime > root_mtime )) || [[ "$dev_mtime" == "$root_mtime" ]]; then
    winner="$DEV_ENV"
    loser="$ROOT_ENV"
    plan_name="dev-docker/.env → root .env"
else
    winner="$ROOT_ENV"
    loser="$DEV_ENV"
    plan_name="root .env → dev-docker/.env"
fi

changes=0
if [[ "$winner" == "$DEV_ENV" ]]; then
    changes="$(apply_plan "$ROOT_ENV" DEV_TO_ROOT)"
else
    changes="$(apply_plan "$DEV_ENV" ROOT_TO_DEV)"
fi

if [[ "$CHECK_ONLY" == true ]]; then
    if [[ "$changes" -gt 0 ]]; then
        echo "env files out of sync (run any ./dev.sh command or scripts/compose.sh to refresh)" >&2
        exit 1
    fi
    exit 0
fi

if [[ "$DRY_RUN" == true ]]; then
    [[ "$changes" -eq 0 && "$QUIET" == false ]] && echo "no changes needed"
    exit 0
fi

if [[ "$changes" -gt 0 ]]; then
    touch -r "$winner" "$loser"
    if [[ "$QUIET" == true ]]; then
        echo "synced env: ${changes} key(s) (${plan_name})"
    else
        echo "synced ${changes} key(s): ${plan_name}"
    fi
fi
