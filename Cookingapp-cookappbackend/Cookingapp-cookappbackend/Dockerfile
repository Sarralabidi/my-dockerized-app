# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot JAR file into the container
COPY target/cookingapp-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 8082

# Command to run the application
CMD ["java", "-jar", "app.jar"]

