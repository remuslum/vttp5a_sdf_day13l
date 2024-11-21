# the base image with JDK used to build and run your Java application
FROM eclipse-temurin:23-jdk

# labelling the docker file
LABEL MAINTAINER="remus"
LABEL description="This is vttp ssf day 14 docker image walkthrough"
LABEL name="vttp-5a-day13l"

ARG APP_DIR=/app

# directory where your src will reside in
WORKDIR ${APP_DIR}

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copy the required files/directories into the image 
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY src src

# Package the application using the RUN directive
# This will download the dependencies defined in pom.xml
# Compile and package to JAR
RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT=3000

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp5a_day13l-0.0.1-SNAPSHOT.jar