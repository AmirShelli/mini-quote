FROM openjdk:17-jdk-alpine

COPY . /app

WORKDIR /app

COPY target/kameleoon-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-cp", "app.jar", "-Dloader.main=com.example.kameleoon.KameleoonApplication", "org.springframework.boot.loader.PropertiesLauncher"]