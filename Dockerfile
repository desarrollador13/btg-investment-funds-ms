# Etapa 1: compilar el proyecto
FROM maven:3.9.6-eclipse-temurin-11 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: imagen final liviana
FROM eclipse-temurin:11-jre

WORKDIR /app

COPY --from=builder /app/target/btg-investment-funds-ms-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]