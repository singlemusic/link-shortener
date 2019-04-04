#!/bin/sh
set -e

TRAEFIK_CONF_DIR=${TRAEFIK_CONF_DIR:-/etc/traefik}

conf_file="${TRAEFIK_CONF_DIR}/local.toml"

echo ">> running \`traefik "-c" "${conf_file}"\`"
echo ">> configuration: "
cat ${conf_file}

exec traefik "-c" "${conf_file}"