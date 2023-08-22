FROM gradle:8.2-jdk17-jammy as builder

WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src /app/src
# Skip tests, otherwise the build process is gonna FAIL!
RUN gradle clean build --no-daemon -x test 

FROM eclipse-temurin:17-jdk-jammy as runner

WORKDIR /app
EXPOSE 80
COPY --from=builder /app/build/libs/spring-boot-application.jar /app/spring-boot-application.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app/spring-boot-application.jar" ]
