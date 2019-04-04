FROM registry.hub.docker.com/library/mysql:5.7.19

ENV MYSQL_ROOT_PASSWORD_FILE=/etc/mysql/mysql_root_password

COPY container/ /

RUN chmod -R 600 /etc/mysql/conf.d/*
