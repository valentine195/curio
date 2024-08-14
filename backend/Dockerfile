FROM eclipse-temurin:latest AS build

COPY . .

RUN ./mvnw clean install --no-transfer-progress


RUN ls -ltr

LABEL org.opencontainers.image.source=https://github.com/valentine195/curio

ENTRYPOINT ["java","-jar","/target/curio.jar"]