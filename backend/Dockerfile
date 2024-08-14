FROM eclipse-temurin:latest AS build

RUN ./mvnw clean install

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

LABEL org.opencontainers.image.source https://github.com/valentine195/curio

ENTRYPOINT ["java","-jar","/app.jar"]