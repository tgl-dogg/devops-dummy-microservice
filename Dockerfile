# Start with a base image containing Java runtime
FROM mcr.microsoft.com/java/jdk:11-zulu-ubuntu

# Add Maintainer Info
LABEL maintainer="tgl-dogg"

# Add a volume pointing to /tmp
VOLUME /tmp
# Copy the application's jar to the container
COPY build/libs/apocalyptic*.jar /tmp/app.jar
WORKDIR /tmp

# Set timezone BR
ENV TZ=GMT-3

# Run the jar file 
ENTRYPOINT java -jar app.jar

EXPOSE ${SERVER_PORT} 1433
