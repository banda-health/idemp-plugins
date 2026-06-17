# syntax=docker/dockerfile:1
# Route C: restore dump in a builder stage; final image contains only PGDATA (no .dmp layer).
#
# Build (dump is a separate BuildKit context — not shipped in the final image):
#   export DOCKER_BUILDKIT=1
#   docker build -f dev-docker/docker/postgres/Dockerfile \
#     --build-context dump=idocker-12 \
#     -t ghcr.io/banda-health/idempiere-db:develop \
#     dev-docker/docker/postgres

FROM postgres:16 AS builder

# Must match POSTGRES_PASSWORD in idempiere-docker / root .env.example (migration stack).
ARG POSTGRES_SUPERUSER_PASSWORD=7d%opWw2N0^f3mG5OmH%
ENV POSTGRES_PASSWORD=${POSTGRES_SUPERUSER_PASSWORD}

ARG DUMP_FILENAME=idempiere-db.dmp
COPY --from=dump ${DUMP_FILENAME} /tmp/idempiere-db.dmp
COPY bake-pgdata.sh /tmp/bake-pgdata.sh
RUN chmod +x /tmp/bake-pgdata.sh && /tmp/bake-pgdata.sh /tmp/idempiere-db.dmp

FROM postgres:16

ARG POSTGRES_SUPERUSER_PASSWORD=7d%opWw2N0^f3mG5OmH%
ENV POSTGRES_PASSWORD=${POSTGRES_SUPERUSER_PASSWORD}

COPY --from=builder --chown=postgres:postgres /var/lib/postgresql/data /var/lib/postgresql/data
