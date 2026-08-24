# --- Step 1: Build the application ---
FROM docker.io/library/gradle:9-jdk26 AS build
WORKDIR /app

# Copy Gradle configuration files first to cache dependencies
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY gradle.properties .
COPY settings.gradle .

# Copy sub-modules build.gradle files
COPY infra/build.gradle infra/
COPY features/build.gradle features/
COPY application/build.gradle application/
COPY domain/build.gradle domain/

# Download dependencies (this layer is cached unless build files change)
RUN ./gradlew dependencies --no-daemon

# Copy the actual source code
COPY infra/src infra/src
COPY features/src features/src
COPY application/src application/src
COPY domain/src domain/src

# Build the project into a bootable JAR file
RUN ./gradlew :infra:bootJar --no-daemon -x test

# --- Step 2: Run the application ---
FROM eclipse-temurin:26-jre
WORKDIR /app

# Copy the built JAR from the build stage
RUN useradd -m springuser
USER springuser

COPY --from=build /app/infra/build/libs/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

# Run the app with Java 26 preview features enabled (optional)
ENTRYPOINT ["java", "-jar", "app.jar"]
