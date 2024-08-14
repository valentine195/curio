FROM eclipse-temurin:latest AS build

COPY . .
RUN ./mvnw clean install

LABEL org.opencontainers.image.source https://github.com/valentine195/curio

RUN ./mvnw spring-boot:run