#!/bin/sh
set -e

TRAEFIK_CONF_DIR=${TRAEFIK_CONF_DIR:-/etc/traefik}

if [[ ! -z ${SWARM_MODE+x} ]]; then
    conf_file="${TRAEFIK_CONF_DIR}/default.toml"
else
    conf_file="${TRAEFIK_CONF_DIR}/local.toml"
fi

echo ">> running \`traefik "-c" "${conf_file}"\`"
echo ">> configuration: "
cat ${conf_file}

exec traefik "-c" "${conf_file}"