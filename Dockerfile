FROM openjdk:21
LABEL authors="cerso"
ADD target/demo-api-rest-0.0.1-SNAPSHOT.jar demo-api-rest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-api-rest-0.0.1-SNAPSHOT.jar"]
