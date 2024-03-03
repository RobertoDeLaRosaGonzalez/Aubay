FROM eclipse-temurin:21-jdk

RUN adduser --disabled-password --gecos '' appuser && \
    adduser appuser sudo && \
    echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
RUN chown -R appuser:appuser /app   # Cambia el propietario y grupo de los archivos copiados

USER appuser

RUN ./mvnw dependency:go-offline

CMD ["./mvnw", "spring-boot:run"]
