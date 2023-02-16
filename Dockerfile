FROM openjdk:17

WORKDIR /app

COPY target/mini-quote-app.jar mini-quote-app.jar

ENTRYPOINT ["java", "-cp", "mini-quote-app.jar", "-Dloader.main=com.example.kameleoon.KameleoonApplication", "org.springframework.boot.loader.PropertiesLauncher", "--host", "0.0.0.0:8000"]