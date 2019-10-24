FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/demo-app-1.0.jar
COPY ${JAR_FILE} "/demo-app-1.0.jar"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo-app-1.0.jar"]