#---------Firts Phase - Build -----------------
FROM maven AS builder
COPY pom.xml /usr/src/app/
WORKDIR /usr/src/app/
RUN mvn -f ./pom.xml dependency:resolve
COPY src/ /usr/src/app/src/
RUN mvn -f ./pom.xml package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","./target/touch-go.jar"]