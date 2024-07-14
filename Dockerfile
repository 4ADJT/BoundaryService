FROM ubuntu:latest AS builder

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install openjdk-17-jdk -y
RUN apt-get install curl -y
RUN apt-get install maven -y

WORKDIR /app

COPY . .

RUN mvn clean package -q -e -DskipTests

FROM openjdk:17-jdk-slim AS runner

ENV MONGO_URI="mongo-blue"
ENV SPRING_PROFILES_ACTIVE=prod

WORKDIR /app

COPY --from=builder /app/target/*.jar BoundaryService.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "/app/BoundaryService.jar"]