FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY ./target/notification-service.jar /app
EXPOSE 8081
CMD ["java", "-jar", "notification-service.jar"]