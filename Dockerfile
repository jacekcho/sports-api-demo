# Use a Java base image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the application using Maven wrapper
RUN ./mvnw clean package

# Run the application
CMD ["java", "-jar", "target/sports-api-demo-0.0.1.jar"]