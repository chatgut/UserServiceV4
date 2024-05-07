FROM maven:3.9.6-eclipse-temurin-22-alpine as build
RUN mkdir /app
WORKDIR /app
COPY target/UserServiceV4-0.0.1-SNAPSHOT.jar /app

FROM maven:3.9.6-eclipse-temurin-22-alpine
WORKDIR /app
COPY --from=build /app/UserServiceV4-0.0.1-SNAPSHOT.jar /app/UserServiceV4-0.0.1-SNAPSHOT.jar
CMD java -jar /app/UserServiceV4-0.0.1-SNAPSHOT.jar
