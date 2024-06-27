FROM openjdk:22-jdk-slim AS build

WORKDIR /app

COPY . .

RUN ./mvnw package -DskipTests

FROM openjdk:22-jdk-slim

WORKDIR /app

COPY --from=build /app/target/Book_Ranker_KIII-0.0.1-SNAPSHOT.jar booker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "booker.jar"]
