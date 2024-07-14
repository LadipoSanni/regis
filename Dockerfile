# First stage: Build the application
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the builder container
WORKDIR /app

# Copy the Maven project files to the container
COPY . .

# Build the application
RUN mvn -B clean package -DskipTests -e

# Second stage: Create the final image
FROM openjdk:17-jdk

# Set the working directory inside the final container
WORKDIR /app

# Copy the built JAR file from the builder stage to the final image
COPY --from=build /app/target/regis-0.0.1-SNAPSHOT.jar regis.jar

# Make port 9524 available to the world outside this container
EXPOSE 9090

# Run the JAR file
ENTRYPOINT ["sh", "-c", "java -Xmx128m -jar regis.jar"]

