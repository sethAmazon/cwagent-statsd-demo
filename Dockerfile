# Install cert and binaries
FROM ubuntu:latest

# Need to repeat the ARG after each FROM
ARG TARGETARCH

COPY build/libs/statsd-0.0.1-SNAPSHOT.jar /tmp/statsd-0.0.1-SNAPSHOT.jar
RUN apt-get update && apt-get install -y ca-certificates

ENTRYPOINT ["java -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=2020 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.rmi.port=2021 -Djava.rmi.server.hostname=127.0.0.1 -jar /tmp/statsd-0.0.1-SNAPSHOT.jar"]


java -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=2020 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.rmi.port=2021 -Djava.rmi.server.hostname=127.0.0.1 -jar build/libs/statsd-0.0.1-SNAPSHOT.jar