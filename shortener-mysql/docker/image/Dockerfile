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
FROM registry.hub.docker.com/library/mysql:5.7.19

ENV MYSQL_ROOT_PASSWORD_FILE=/etc/mysql/mysql_root_password

COPY container/ /

RUN chmod -R 600 /etc/mysql/conf.d/*
