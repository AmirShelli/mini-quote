FROM openjdk:17

EXPOSE 80

WORKDIR /app

COPY target/mini-quote-app.jar mini-quote-app.jar

ENTRYPOINT ["java", "-cp", "java", "-cp", "mini-quote-app.jar", "-Dloader.main=com.example.kameleoon.KameleoonApplication", "org.springframework.boot.loader.PropertiesLauncher"]