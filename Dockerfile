FROM openjdk:17
ADD target/Bookmyshow-0.0.1-SNAPSHOT.jar bookmyshow-docker.jar
ENTRYPOINT ["java","-jar","bookmyshow-docker.jar"]