FROM openjdk:17-jdk-alpine
LABEL maintainer="itsdevelopernic22@gmail.com"
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ./target/PezeshaSimpleMoneyTransferSystem-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "/app.jar"]