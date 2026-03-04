FROM eclipse-temurin:11
WORKDIR /app
#copying the exe JAR which is built by jenkins and maven
COPY target/scientific-calculator-1.0-SNAPSHOT.jar /app/calculator.jar
#running the application
CMD ["java", "-jar", "calculator.jar"]