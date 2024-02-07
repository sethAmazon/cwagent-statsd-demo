# Install cert and binaries
FROM ubuntu:latest

# Need to repeat the ARG after each FROM
ARG TARGETARCH

RUN mkdir -p /opt
COPY statsd.jar statsd.jar
RUN apt-get update && apt-get install -y ca-certificates openjdk-17-jdk openjdk-17-jre

ENTRYPOINT java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=2020 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=localhost -jar statsd.jar