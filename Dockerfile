FROM amazoncorretto:17-alpine-jdk

COPY target/bookingSystemAPI-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/app.jar"]