FROM tomcat:latest
ADD /target/weather-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
