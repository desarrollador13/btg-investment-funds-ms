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

# Variable de entorno para MongoDB
ENV MONGODB_URI="mongodb+srv://jdesarrollador13_db_user:db_user_jp@cluster0.ctuzal8.mongodb.net/mi_base_de_datos?retryWrites=true&tls=true&tlsAllowInvalidCertificates=false"
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]