FROM openjdk:11
COPY phones.db phones.db
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} phoneApp.jar
ENTRYPOINT ["java","-jar","/phoneApp.jar"]