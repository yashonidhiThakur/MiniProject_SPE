FROM eclipse-temurin:11
WORKDIR /app
COPY /src/main/ScientificCalc.java /app/ScientificCalc.java
RUN javac ScientificCalc.java
CMD ["java","ScientificCalc"]