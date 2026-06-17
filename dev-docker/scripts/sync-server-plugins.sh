#!/usr/bin/env bash
# Copy freshly built Banda plugin JARs from the mounted repo into the iDempiere server product
# and register them in the p2 OSGi bundles.info (dropping JARs in plugins/ alone does not load them).
#
# Start levels match Eclipse server.product / Setup Guide conventions:
#   runtime plugins (base, graphql): level 4 — graphql autostart true, base false
#   test plugins + chuboe populate: level 5, autostart true (SOAP test services)
set -euo pipefail

IDEMPIERE_HOME="${IDEMPIERE_HOME:-/opt/idempiere}"
PLUGINS_DIR="${PLUGINS_DIR:-/workspace/idemp-banda}"
SERVER_HOME="${IDEMPIERE_SERVER_HOME:-${IDEMPIERE_HOME}/org.idempiere.p2/target/products/org.adempiere.server.product/linux/gtk/x86_64}"
DEST="${SERVER_HOME}/plugins"
BUNDLES_INFO="${SERVER_HOME}/configuration/org.eclipse.equinox.simpleconfigurator/bundles.info"

if [[ ! -d "$DEST" ]]; then
    echo "Server plugins directory not found: $DEST" >&2
    exit 1
fi

if [[ ! -f "$BUNDLES_INFO" ]]; then
    echo "Server bundles.info not found: $BUNDLES_INFO" >&2
    exit 1
fi

# Feature JARs are not OSGi bundles — do not deploy them to plugins/.
rm -f "${DEST}"/*.feature-*.jar 2>/dev/null || true

read_manifest_value() {
    local jar="$1"
    local key="$2"
    unzip -p "$jar" META-INF/MANIFEST.MF | tr -d '\r' | awk -v key="$key" '
        BEGIN { FS=": "; found=0 }
        $1 == key { print substr($0, index($0, ": ") + 2); found=1; next }
        found && /^ / { sub(/^ /, ""); printf "%s", $0; next }
        found { exit }
    '
}

register_bundle() {
    local jar="$1"
    local start_level="$2"
    local autostart="$3"
    local filename symbolic_name version

    filename="$(basename "$jar")"
    symbolic_name="$(read_manifest_value "$jar" "Bundle-SymbolicName")"
    symbolic_name="${symbolic_name%%;*}"
    version="$(read_manifest_value "$jar" "Bundle-Version")"

    if [[ -z "$symbolic_name" || -z "$version" ]]; then
        echo "Warning: could not read manifest from $filename — skipping bundles.info registration." >&2
        return 0
    fi

    grep -v "^${symbolic_name}," "$BUNDLES_INFO" > "${BUNDLES_INFO}.tmp"
    echo "${symbolic_name},${version},plugins/${filename},${start_level},${autostart}" >> "${BUNDLES_INFO}.tmp"
    mv "${BUNDLES_INFO}.tmp" "$BUNDLES_INFO"
    echo "Registered ${symbolic_name} (start=${start_level}, autostart=${autostart}) in bundles.info"
}

shopt -s nullglob
# module:start_level:autostart — same as Eclipse server.product plugin tab
module_specs=(
    "base:4:false"
    "graphql:4:true"
    "base-test:5:true"
    "graphql-test:5:true"
    "reports-test:5:true"
    "chuck-test-framework:5:true"
)
copied=0

for spec in "${module_specs[@]}"; do
    IFS=: read -r module start_level autostart <<<"$spec"
    for jar in "${PLUGINS_DIR}/${module}"/target/*SNAPSHOT.jar; do
        echo "Deploying $(basename "$jar") -> $DEST/"
        cp -f "$jar" "$DEST/"
        register_bundle "$jar" "$start_level" "$autostart"
        copied=$((copied + 1))
    done
done

if (( copied == 0 )); then
    echo "Warning: no *SNAPSHOT.jar files found under ${PLUGINS_DIR}/*/target — run mvn verify first." >&2
fi
