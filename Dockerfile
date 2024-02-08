# Install cert and binaries
FROM amazoncorretto:21

# Need to repeat the ARG after each FROM
ARG TARGETARCH

RUN mkdir -p /opt
COPY statsd.jar statsd.jar
RUN yum update -y && yum install -y ca-certificates

ENTRYPOINT java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=2020 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=localhost -jar statsd.jar