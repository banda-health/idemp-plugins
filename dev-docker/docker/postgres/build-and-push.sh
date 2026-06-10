#!/usr/bin/env bash
# Build (and optionally push) the baked Postgres dev DB image from a CI export dump.
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "${SCRIPT_DIR}/../../.." && pwd)"

DUMP_PATH="${1:-${REPO_ROOT}/idocker-${IDEMPIERE_VERSION:-12}/idempiere-db.dmp}"
IMAGE_REPO="${IMAGE_REPO:-ghcr.io/banda-health/idempiere-db}"
IMAGE_TAG="${IMAGE_TAG:-develop}"
VERSION_TAG="${VERSION_TAG:-}"

if [ ! -f "$DUMP_PATH" ]; then
	echo "Dump not found: $DUMP_PATH" >&2
	echo "Usage: $0 [path/to/idempiere-db.dmp]" >&2
	exit 1
fi

if [ -z "$VERSION_TAG" ] && [ -f "${REPO_ROOT}/VERSION.conf" ]; then
	# shellcheck disable=SC1091
	source "${REPO_ROOT}/VERSION.conf"
	VERSION_TAG="${IDEMPIERE_VERSION:-12}-dev-${VERSION}"
fi

export DOCKER_BUILDKIT=1
DUMP_DIR="$(cd "$(dirname "$DUMP_PATH")" && pwd)"
DUMP_FILE="$(basename "$DUMP_PATH")"

TAGS=(-t "${IMAGE_REPO}:${IMAGE_TAG}")
if [ -n "$VERSION_TAG" ]; then
	TAGS+=(-t "${IMAGE_REPO}:${VERSION_TAG}")
fi

docker build \
	-f "${SCRIPT_DIR}/Dockerfile" \
	--build-context "dump=${DUMP_DIR}" \
	--build-arg "DUMP_FILENAME=${DUMP_FILE}" \
	"${TAGS[@]}" \
	"${SCRIPT_DIR}"

if [ "${PUSH:-false}" = true ]; then
	for tag in "$IMAGE_TAG" ${VERSION_TAG:+"$VERSION_TAG"}; do
		echo "Pushing ${IMAGE_REPO}:${tag} ..."
		docker push "${IMAGE_REPO}:${tag}"
	done
fi
