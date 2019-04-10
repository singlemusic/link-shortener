#!/bin/sh
#
#    link-shortener
#    Copyright (C) 2019  Single LLC
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <https://www.gnu.org/licenses/>.
#
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