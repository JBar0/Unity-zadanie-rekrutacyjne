FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} unity.jar
ENTRYPOINT ["java","-jar","/unity.jar"]