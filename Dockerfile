FROM eclipse-temurin:21-alpine AS build
WORKDIR /app
COPY . .
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests
