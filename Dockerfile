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

#GraphQL test files will change frequently, so now handle those
WORKDIR /app/graphql-test
COPY ./graphql-test/testing/package.json .
RUN npm install

WORKDIR /app
COPY ./graphql-test/testing ./graphql-test
COPY ./rest-test/testing ./rest-test


HEALTHCHECK --interval=1s --timeout=1s --retries=1800 CMD ["sh", "-c", "[ ! -f \".unhealthy\" ] && exit 0 || exit 1"]
CMD ["tail", "-f", "/dev/null"]
ENTRYPOINT ["./docker-entrypoint.sh"]
