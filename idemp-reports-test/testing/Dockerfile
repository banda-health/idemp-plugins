FROM alpine:latest
RUN apk add --no-cache wget libxml2-utils bash
WORKDIR /app
COPY . .
HEALTHCHECK --interval=1s --timeout=1s CMD ["sh", "-c", "[ ! -f \".unhealthy\" ] && exit 0 || exit 1"]
CMD ["sleep", "infinity"]
ENTRYPOINT ["./runTests.sh"]
