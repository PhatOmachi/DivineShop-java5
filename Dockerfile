# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar

# Kiểm tra sự tồn tại của file JAR
RUN ls -l /app/app.jar

# Đảm bảo quyền truy cập đúng
RUN chmod +x /app/app.jar

ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "/app/app.jar"]