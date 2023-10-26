FROM adoptopenjdk/openjdk16
VOLUME /tmp
COPY target/fmbApi-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]