FROM alpine:3.20

RUN apk add --no-cache pgbouncer su-exec \
    && addgroup -S pgbouncer \
    && adduser -S -G pgbouncer pgbouncer

COPY scripts/db-proxy.sh /db-proxy.sh
RUN chmod +x /db-proxy.sh

CMD ["/bin/sh", "/db-proxy.sh"]
