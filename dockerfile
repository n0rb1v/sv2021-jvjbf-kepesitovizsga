FROM adoptopenjdk:14-jre-hotspot
RUN mkdir /opt/app
COPY target/sv2021-jvjbf-kepesitovizsga-1.0-SNAPSHOT.jar /opt/app/kepesitovizsga-1.jar
CMD ["java", "-jar", "/opt/app/kepesitovizsga-1"]