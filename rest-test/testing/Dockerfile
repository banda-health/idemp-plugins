FROM node:current-alpine
RUN apk update && apk add --no-cache wget libxml2-utils bash postgresql-client
RUN npm install jest ts-jest typescript ts-node --global

WORKDIR /app
COPY package.json .
RUN npm install

COPY . .

HEALTHCHECK --interval=1s --timeout=1s --retries=600 CMD ["sh", "-c", "[ ! -f \".unhealthy\" ] && exit 0 || exit 1"]
CMD ["tail", "-f", "/dev/null"]
ENTRYPOINT ["./runTests.sh"]
