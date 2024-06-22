# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Package the application (replace 'mvnw' with 'mvn' if you use Maven Wrapper)
RUN ./mvnw package -DskipTests

# Second stage: Run the application
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/sticky-notes-kiii-0.0.1-SNAPSHOT.jar sticky-notes-kiii.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "sticky-notes-kiii.jar"]
