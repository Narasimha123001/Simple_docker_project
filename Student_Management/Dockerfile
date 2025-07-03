FROM openjdk:21-jdk
WORKDIR /app
COPY target/student_app.jar student_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student_app.jar"]