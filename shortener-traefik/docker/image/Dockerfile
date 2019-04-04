FROM registry.hub.docker.com/library/traefik:1.7.4-alpine

RUN apk --no-cache --no-progress add bash

COPY entrypoint.sh /entrypoint.sh
COPY config/*.toml /etc/traefik/

RUN chmod a+x /entrypoint.sh

ENTRYPOINT [ "/entrypoint.sh" ]
