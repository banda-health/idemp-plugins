#!/bin/sh
# PgBouncer on localhost:5432 inside the idempiere network namespace.
# iDempiere uses fixed dev settings in the UI; upstream host/db/user/password come from .env.

set -eu

DB_TARGET="${DB_TARGET:-host}"
DB_UPSTREAM_USER="${DB_UPSTREAM_USER:-adempiere}"
DB_UPSTREAM_PASSWORD="${DB_UPSTREAM_PASSWORD:-adempiere}"
DB_UPSTREAM_DATABASE="${DB_UPSTREAM_DATABASE:-idempiere}"
DB_UPSTREAM_ADMIN_USER="${DB_UPSTREAM_ADMIN_USER:-postgres}"
DB_UPSTREAM_ADMIN_PASSWORD="${DB_UPSTREAM_ADMIN_PASSWORD:-postgres}"
DB_UPSTREAM_ADMIN_DATABASE="${DB_UPSTREAM_ADMIN_DATABASE:-template1}"

case "$DB_TARGET" in
  host)
    UPSTREAM_HOST="host.docker.internal"
    UPSTREAM_PORT="${DB_HOST_PORT:-5432}"
    ;;
  compose)
    UPSTREAM_HOST="${DB_COMPOSE_HOST:-postgres}"
    UPSTREAM_PORT="5432"
    ;;
  *)
    echo "Unknown DB_TARGET='$DB_TARGET' (use 'host' or 'compose')" >&2
    exit 1
    ;;
esac

CONFIG_DIR="/tmp/pgbouncer"
mkdir -p "$CONFIG_DIR"

# Only quote values that break PgBouncer conninfo (not hyphens/dots in db names).
quote_conn_value() {
  value=$1
  case "$value" in
    *[\"\'\ \\=]*)
      escaped=$(printf '%s' "$value" | sed 's/"/\\"/g')
      printf '"%s"' "$escaped"
      ;;
    *)
      printf '%s' "$value"
      ;;
  esac
}

APP_USER=$(quote_conn_value "$DB_UPSTREAM_USER")
APP_PASSWORD=$(quote_conn_value "$DB_UPSTREAM_PASSWORD")
APP_DATABASE=$(quote_conn_value "$DB_UPSTREAM_DATABASE")
ADMIN_USER=$(quote_conn_value "$DB_UPSTREAM_ADMIN_USER")
ADMIN_PASSWORD=$(quote_conn_value "$DB_UPSTREAM_ADMIN_PASSWORD")
ADMIN_DATABASE=$(quote_conn_value "$DB_UPSTREAM_ADMIN_DATABASE")

cat >"$CONFIG_DIR/pgbouncer.ini" <<EOF
[databases]
template1 = host=${UPSTREAM_HOST} port=${UPSTREAM_PORT} dbname=${ADMIN_DATABASE} user=${ADMIN_USER} password=${ADMIN_PASSWORD}
postgres = host=${UPSTREAM_HOST} port=${UPSTREAM_PORT} dbname=postgres user=${ADMIN_USER} password=${ADMIN_PASSWORD}
idempiere = host=${UPSTREAM_HOST} port=${UPSTREAM_PORT} dbname=${APP_DATABASE} user=${APP_USER} password=${APP_PASSWORD}
* = host=${UPSTREAM_HOST} port=${UPSTREAM_PORT} dbname=${APP_DATABASE} user=${APP_USER} password=${APP_PASSWORD}

[pgbouncer]
listen_addr = 127.0.0.1
listen_port = 5432
auth_type = any
pool_mode = session
max_client_conn = 100
default_pool_size = 20
server_tls_sslmode = disable
ignore_startup_parameters = extra_float_digits
log_connections = 1
log_disconnections = 1
admin_users = pgbouncer
EOF

chown -R pgbouncer:pgbouncer "$CONFIG_DIR"

echo "PgBouncer: 127.0.0.1:5432 -> ${UPSTREAM_HOST}:${UPSTREAM_PORT} (DB_TARGET=${DB_TARGET})"
echo "  app  (idempiere/*) -> db=${DB_UPSTREAM_DATABASE} user=${DB_UPSTREAM_USER}"
echo "  admin (template1)   -> db=${DB_UPSTREAM_ADMIN_DATABASE} user=${DB_UPSTREAM_ADMIN_USER}"
echo "UI db/user/password are ignored on localhost; set upstream values in .env."

exec su-exec pgbouncer pgbouncer "$CONFIG_DIR/pgbouncer.ini"
