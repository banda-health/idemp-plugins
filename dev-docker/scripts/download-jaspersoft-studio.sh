#!/usr/bin/env bash
# Optional: pre-download Studio into dev-docker/vendor/ for offline Docker rebuilds.
# Normal ./dev.sh --build downloads Studio inside the Dockerfile automatically.
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
VENDOR_DIR="${SCRIPT_DIR}/../vendor"
STUDIO_VERSION="6.20.3"
DEFAULT_URL="https://jasper-schulungen.de/jasperstudio-standalone/${STUDIO_VERSION}/com.jaspersoft.studio.rcp.product-linux.gtk.x86_64.zip"
ARCHIVE_NAME="jaspersoft-studio-${STUDIO_VERSION}-linux.x86_64.zip"
ARCHIVE_PATH="${VENDOR_DIR}/${ARCHIVE_NAME}"

if [[ -f "${ARCHIVE_PATH}" ]]; then
    if file -b "${ARCHIVE_PATH}" | grep -qiE 'zip archive|Zip archive'; then
        echo "Jaspersoft Studio ${STUDIO_VERSION} archive already present: ${ARCHIVE_PATH}"
        exit 0
    fi
    echo "Found ${ARCHIVE_PATH} but it is not a zip archive." >&2
    file -b "${ARCHIVE_PATH}" >&2
    rm -f "${ARCHIVE_PATH}"
fi

if [[ -f "${SCRIPT_DIR}/../.env" ]]; then
    set -a
    # shellcheck disable=SC1091
    source "${SCRIPT_DIR}/../.env"
    set +a
fi

mkdir -p "${VENDOR_DIR}"

URL="${JASPERSOFT_STUDIO_URL:-$DEFAULT_URL}"
echo "Downloading Jaspersoft Studio ${STUDIO_VERSION}..."
wget -q --show-progress -O "${ARCHIVE_PATH}.partial" "${URL}"
mv "${ARCHIVE_PATH}.partial" "${ARCHIVE_PATH}"
echo "Saved to ${ARCHIVE_PATH}"
