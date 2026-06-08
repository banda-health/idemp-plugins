#!/usr/bin/env bash
# Freeze the current container filesystem into a reusable image tag.
# Run from docker-dev/ after interactive setup (Eclipse cache, builds, workspace metadata).

set -euo pipefail

CONTAINER_NAME="${CONTAINER_NAME:-idempiere-development}"
IMAGE_REPO="${IMAGE_REPO:-docker-dev-idempiere}"
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
echo "  cd docker-dev && IDEMPIERE_DEV_IMAGE=$FULL_IMAGE docker compose -f docker-compose.snapshot.yml up -d"
echo
echo "Share with others (registry):"
echo "  docker tag $FULL_IMAGE <registry>/<repo>:<tag>"
echo "  docker push <registry>/<repo>:<tag>"
echo
echo "Share offline (tar file):"
echo "  docker save $FULL_IMAGE -o idempiere-dev-snapshot.tar"
echo "  docker load -i idempiere-dev-snapshot.tar"
