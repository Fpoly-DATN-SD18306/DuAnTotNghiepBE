FROM openjdk:24-jdk

WORKDIR /usr/app

COPY /target/CodeBase-DATN-0.0.1-SNAPSHOT.jar /usr/app/DATN.jar

EXPOSE 8080

ENTRYPOINT ["java",  "-jar", "DATN.jar"]

#docker run -e SPRING_DATASOURCE_URL=jdbc:mysql://junction.proxy.rlwy.net:58967/railway?useSSL=false -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=qwFRxQddCqWbwxMnbEUdILeVBiLqOXKk -p 8080:8080 test-aftere-connectdb2
