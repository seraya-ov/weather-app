#FROM tomcat:latest
#ADD /target/weather-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#CMD ["catalina.sh", "run"]

FROM anapsix/alpine-java
COPY /target/weather-1.0-SNAPSHOT.jar /usr/local/tomcat/webapps/weather-1.0-SNAPSHOT.jar
CMD ["java","-jar","/usr/local/tomcat/webapps/weather-1.0-SNAPSHOT.jar"]