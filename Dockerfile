FROM amazoncorretto:17
VOLUME /zpt
ADD target/zptapi-0.0.1-SNAPSHOT.jar zptapi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/zptapi.jar"]