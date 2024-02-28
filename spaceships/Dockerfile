FROM eclipse-temurin:21-jdk

#COPY --chown=1000:1000 ./ ./

#USER www-data

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
