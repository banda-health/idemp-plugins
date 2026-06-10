#!/usr/bin/env bash
# Verify the GraphQL Vitest client exists in ad_client (created by graphql-test SOAP population).
set -euo pipefail

client_name="${IDEMPIERE_GRAPHQL_TEST_CLIENT:-GraphQL Test Client}"
soap_client_name="GraphQL Test Client"

if ! command -v psql >/dev/null 2>&1; then
    echo "Warning: psql not available; skipping GraphQL test client check." >&2
    exit 0
fi

if [[ -z "${PGHOST:-}" || -z "${PGDATABASE:-}" ]]; then
    echo "Warning: PGHOST/PGDATABASE not set; skipping GraphQL test client check." >&2
    exit 0
fi

client_name_sql="${client_name//\'/\'\'}"
exists="$(
    psql -v ON_ERROR_STOP=1 -tAc \
        "SELECT EXISTS(SELECT 1 FROM ad_client WHERE name = '${client_name_sql}' AND isactive = 'Y');"
)"

if [[ "$exists" == "t" ]]; then
    exit 0
fi

{
    echo "GraphQL test client not found in database: \"${client_name}\""
    echo
    echo "Vitest tests require this client. On a new database, run the GraphQL SOAP data"
    echo "population first (it creates the test client and related org/warehouse data):"
    echo
    echo "  ./dev.sh test graphql"
    echo
    echo "Or run SOAP only from graphql-test/testing (with iDempiere up and DB env configured):"
    echo
    echo "  cd graphql-test/testing && ./runTests.sh"
    echo
    echo "Client name for Vitest: IDEMPIERE_GRAPHQL_TEST_CLIENT in .env"
    echo "(current value: \"${client_name}\")"
    if [[ "$client_name" != "$soap_client_name" ]]; then
        echo
        echo "Note: the SOAP populator currently creates \"${soap_client_name}\"."
        echo "Set IDEMPIERE_GRAPHQL_TEST_CLIENT to that name, or align the SOAP test data."
    fi
} >&2

exit 1
