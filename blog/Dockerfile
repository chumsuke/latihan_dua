# Use the official OpenJDK base image
FROM openjdk 17.0.9 2023-10-17

# Set the working directory
WORKDIR /BlogSwaggerApplication

# Copy the JAR file into the container
COPY target/blog_swagger-0.0.1-SNAPSHOT.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]


# docker build -t your-application-image .

# docker run -p 8080:8080 -t your-application-image