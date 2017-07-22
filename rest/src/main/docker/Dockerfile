FROM openjdk

VOLUME /tmp
ADD maven/rest-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/ ./urandom", "-jar","/myapp.jar"]