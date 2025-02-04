# Use a base image that has Java installed
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/rest-api-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to access the app
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
