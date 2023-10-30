# Use the official OpenJDK base image
FROM openjdk:11-jre-slim

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/flashfood-0.0.1-SNAPSHOT-plain.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]