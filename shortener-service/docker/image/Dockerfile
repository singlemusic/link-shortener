FROM registry.hub.docker.com/library/openjdk:11-jre-stretch

ADD maven/shortener-service*.jar shortener-service.jar

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/urandom -jar /shortener-service.jar

HEALTHCHECK --interval=15s --timeout=5s --start-period=300s \
  CMD curl -f http://localhost:8081/actuator/health || exit 1
