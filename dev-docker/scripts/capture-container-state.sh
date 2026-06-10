#!/usr/bin/env bash
# Freeze the current container filesystem into a reusable image tag.
# Run from dev-docker/ after the manual Eclipse setup in IMAGE-SETUP.md
# (target platform, Banda plugins, install, server verify).

set -euo pipefail

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"
# IMAGE_REPO/IMAGE_TAG are set by dev.sh from IDEMPIERE_DEV_IMAGE; defaults for direct script use.
IMAGE_REPO="${IMAGE_REPO:-dev-docker-idempiere}"
IMAGE_TAG="${IMAGE_TAG:-snapshot}"
FULL_IMAGE="${IMAGE_REPO}:${IMAGE_TAG}"

if ! docker container inspect "$CONTAINER_NAME" >/dev/null 2>&1; then
  echo "Container '$CONTAINER_NAME' does not exist."
  echo "Start it first, make your changes, then run this script again."
  exit 1
fi

echo "Committing container '$CONTAINER_NAME' -> '$FULL_IMAGE' ..."
docker commit "$CONTAINER_NAME" "$FULL_IMAGE"

echo
echo "Saved image: $FULL_IMAGE"
echo
echo "Start from this frozen state:"
echo "  IDEMPIERE_DEV_IMAGE=$FULL_IMAGE ./dev.sh"
echo "  (set IDEMPIERE_DEV_IMAGE in dev-docker/.env for the team)"
echo
echo "Share with others (registry — includes Eclipse workspace and /opt/idempiere):"
echo "  ./dev.sh push"
echo "  Teammates: set IDEMPIERE_DEV_IMAGE in dev-docker/.env, docker pull, ./dev.sh"
echo
echo "Share offline (tar file):"
echo "  docker save $FULL_IMAGE -o idempiere-dev-snapshot.tar"
echo "  docker load -i idempiere-dev-snapshot.tar"
