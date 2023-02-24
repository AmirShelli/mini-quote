FROM openjdk:17-jdk-alpine

EXPOSE 8000

RUN mkdir ./app

COPY ./target/kameleoon-0.0.1-SNAPSHOT.jar ./app

ENTRYPOINT ["java", "-jar", "./app/kameleoon-0.0.1-SNAPSHOT.jar"]