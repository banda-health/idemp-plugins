FROM alpine:latest
RUN apk update && apk add --no-cache wget libxml2-utils bash postgresql-client nodejs npm jq
RUN npm install jest ts-jest typescript ts-node --global

WORKDIR /app
COPY ./docker-entrypoint.sh .

#Copy files that don't really change
COPY ./base-test/testing ./base-test
COPY ./reports-test/testing ./reports-test

#Rest test files will change frequently, so now handle those
WORKDIR /app/rest-test
COPY ./rest-test/testing/package.json .
RUN npm install

COPY ./rest-test/testing .

WORKDIR /app

HEALTHCHECK --interval=1s --timeout=1s --retries=1200 CMD ["sh", "-c", "[ ! -f \".unhealthy\" ] && exit 0 || exit 1"]
CMD ["tail", "-f", "/dev/null"]
ENTRYPOINT ["./docker-entrypoint.sh"]
