FROM maven:3.9.5-openjdk-21 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

COPY --from=build /target/Ecom-0.0.1-SNAPSHOT.jar Ecom.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Ecom.jar"]
