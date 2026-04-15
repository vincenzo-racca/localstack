# Usa la versione di Java con cui hai compilato (es. Java 21)
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia il JAR e la cache generata dalla pipeline
COPY target/localstack-0.0.1-SNAPSHOT.jar app.jar
COPY application.jsa application.jsa

# Esponi la porta
EXPOSE 8080

# Avvia l'applicazione dicendo alla JVM di usare la cache
ENTRYPOINT ["java", "-XX:SharedArchiveFile=application.jsa", "-jar", "app.jar"]