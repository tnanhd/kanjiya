# --- Step 1: Build the application ---
FROM docker.io/library/gradle:9-jdk26 AS build
WORKDIR /app

# Copy Gradle configuration files first to cache dependencies
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle .
COPY gradle.properties .
COPY settings.gradle .

# Download dependencies (this layer is cached unless build files change)
RUN ./gradlew dependencies --no-daemon

# Copy the actual source code
COPY src ./src

# Build the project into a bootable JAR file
RUN ./gradlew bootJar --no-daemon -x test

# --- Step 2: Run the application ---
FROM eclipse-temurin:26-jre
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

# Run the app with Java 26 preview features enabled (optional)
ENTRYPOINT ["java", "-jar", "app.jar"]
