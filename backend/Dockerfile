FROM eclipse-temurin:latest AS build

COPY . .

ENV SPRING_PROFILES_ACTIVE=prod

RUN ./mvnw clean package --no-transfer-progress -DskipTests

LABEL org.opencontainers.image.source=https://github.com/valentine195/curio

ENTRYPOINT ["java","-jar","/target/curio.jar"]