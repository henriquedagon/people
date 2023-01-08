# https://www.baeldung.com/spring-boot-docker-images
# docker build -t java-app .; docker run -it --rm --name data-utilities java-app
FROM maven:3-eclipse-temurin-11-alpine as builder
COPY . .
RUN mvn install -DskipTests
RUN java -Djarmode=layertools -jar target/*.jar extract

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]