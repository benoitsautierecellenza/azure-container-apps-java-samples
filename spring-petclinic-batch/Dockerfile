FROM mcr.microsoft.com/openjdk/jdk:17-mariner AS build

ARG JAR=spring-batch-football-0.0.1-SNAPSHOT.jar

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw
RUN ./mvnw package -DskipTests
COPY target/$JAR app.jar

FROM mcr.microsoft.com/openjdk/jdk:17-mariner

COPY --from=build /workspace/app/app.jar /workspace/app/app.jar

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=70", "-XX:+UseParallelGC", "-XX:ActiveProcessorCount=2", "-jar", "/workspace/app/app.jar"]
