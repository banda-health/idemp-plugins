#!/usr/bin/env bash
# TeamCity: build and push ghcr.io/banda-health/idempiere-db from initial-db.dmp.
#
# Prerequisite: TeamCity artifact dependency on Build - Develop (same pattern as
# develop's idempiere / idocker artifact deps — no REST token in this script):
#
#   Depend on:  BHGO_IDempiereBanda_BuildDevelop
#   From:       Build from the same chain (when snapshot-dep on Build - Develop)
#   Rule:       +:initial-db.dmp => initial-db.dmp
#
# Also requires a VCS checkout (develop) for VERSION.conf and build-and-push.sh.
#
# Env:
#   DUMP_PATH   default: initial-db.dmp
#   IMAGE_TAG   default: develop
#   VERSION_TAG default: <IDEMPIERE_VERSION>-dev-<VERSION from VERSION.conf>
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

DUMP="${DUMP_PATH:-initial-db.dmp}"
IMAGE_REPO="${IMAGE_REPO:-ghcr.io/banda-health/idempiere-db}"
IMAGE_TAG="${IMAGE_TAG:-develop}"

if [[ ! -s "$DUMP" ]]; then
	echo "Missing or empty dump: $DUMP" >&2
	echo "Add an artifact dependency on Build - Develop:" >&2
	echo "  +:initial-db.dmp => initial-db.dmp  (build from the same chain)" >&2
	exit 1
fi

if [[ ! -f VERSION.conf ]]; then
	echo "Missing VERSION.conf in checkout" >&2
	exit 1
fi
# shellcheck disable=SC1091
source VERSION.conf

IDEMPIERE_VERSION="${IDEMPIERE_VERSION:-$(grep '^IDEMPIERE_VERSION=' .env.example | sed 's/IDEMPIERE_VERSION=//')}"
export VERSION_TAG="${VERSION_TAG:-${IDEMPIERE_VERSION}-dev-${VERSION}}"

echo "Building and pushing ${IMAGE_REPO}:${IMAGE_TAG} and ${IMAGE_REPO}:${VERSION_TAG}"
echo "  dump: $(du -h "$DUMP" | awk '{print $1}')"

export DOCKER_BUILDKIT=1
export PUSH=true
chmod +x dev-docker/docker/postgres/build-and-push.sh
dev-docker/docker/postgres/build-and-push.sh "$DUMP"
