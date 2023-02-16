FROM openjdk:17

EXPOSE 80

WORKDIR /app

COPY target/mini-quote-app.jar mini-quote-app.jar

ENTRYPOINT ["java", "-jar", "/mini-quote-app.jar"]