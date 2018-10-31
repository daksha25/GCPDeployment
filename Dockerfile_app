FROM tomcat:8.5
COPY /target/infybank.war /usr/local/tomcat/webapps
WORKDIR /usr/local/tomcat
RUN chmod +x bin/catalina.sh
CMD ["bin/catalina.sh", "run"]