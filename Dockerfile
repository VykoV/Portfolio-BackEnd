FROM amazoncorretto:19-alpine-jdk
MAINTAINER VykoV
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT.jar"]