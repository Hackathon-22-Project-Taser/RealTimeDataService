FROM maven:3.8.5-jdk-11 AS maven-build

RUN mkdir /opt/app/
COPY . /opt/app/
WORKDIR /opt/app/
RUN mvn clean compile package


FROM adoptopenjdk/openjdk11:alpine-slim

COPY --from=maven-build /opt/app/target/RealTimeDataService-0.0.1-SNAPSHOT.jar /opt/app/RealTimeDataService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/opt/app/RealTimeDataService-0.0.1-SNAPSHOT.jar"]

