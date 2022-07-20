FROM node:current-alpine
RUN apk add --no-cache wget libxml2-utils bash
RUN npm install jest ts-jest typescript ts-node --global

WORKDIR /app
COPY package.json .
RUN npm install

COPY . .

HEALTHCHECK --interval=1s --timeout=1s CMD ["sh", "-c", "[ ! -f \".unhealthy\" ] && exit 0 || exit 1"]
CMD ["sleep", "infinity"]
ENTRYPOINT ["./runTests.sh"]
