# Build Java minimal docker image base file
FROM alpine:latest as packager

RUN apk --no-cache add openjdk11-jdk openjdk11-jmods

ENV JAVA_MINIMAL="/opt/java-minimal"

# build minimal JRE
RUN /usr/lib/jvm/java-11-openjdk/bin/jlink \
    --verbose \
    --add-modules \
        java.base,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --compress 2 --strip-debug --no-header-files --no-man-pages \
    --release-info="add:IMPLEMENTOR=radistao:IMPLEMENTOR_VERSION=radistao_JRE" \
    --output "$JAVA_MINIMAL"

# Start with a base image containing Java runtime
#FROM mcr.microsoft.com/java/jdk:11u11-zulu-alpine

# Start from alpine to build lightweight image
FROM alpine:latest

ENV JAVA_HOME=/opt/java-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"

COPY --from=packager "$JAVA_HOME" "$JAVA_HOME"

# Add Maintainer Info
LABEL maintainer="tgl-dogg"

# Add a volume pointing to /tmp
VOLUME /tmp
# Copy the application's jar to the container
COPY build/libs/apocalyptic*.jar /tmp/app.jar
WORKDIR /tmp

# Set timezone to BR
ENV TZ=GMT-3

# Run the jar file 
ENTRYPOINT java -jar app.jar

EXPOSE ${SERVER_PORT} 1433
