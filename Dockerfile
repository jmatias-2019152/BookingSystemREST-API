FROM amazoncorretto:21-alpine-jdk

COPY target/bookingSystemAPI-Build.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]