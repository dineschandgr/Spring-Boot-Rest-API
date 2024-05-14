FROM openjdk:17
WORKDIR /app
COPY ./target/Rest-API-0.0.1-SNAPSHOT.jar /app
EXPOSE 8090
CMD ["java", "-jar", "Rest-API-0.0.1-SNAPSHOT.jar"]