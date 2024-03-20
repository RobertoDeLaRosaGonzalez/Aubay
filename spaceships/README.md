# Spring boot technical test for company Aubay
This techical test lets you do a CRUD maintenance of a Spaceship database.
#### It uses these technologies:
* Docker
* Spring boot
* MySQL
* JPA
* Maven
* JUnit
### What I would add with more time?
* Security access
* API documentation with Swagger
* BDD with Cucumber
## Getting up and running
This application uses Docker, so in order to start the apllication we have to do the next steps:
```
1. cd Aubay/spaceships
2. docker-compose build
3. docker-compose up
```
## Testing
To launch the tests we have to edit the dockerfile before doing a docker-compose build and up:
```
#CMD ["./mvnw", "spring-boot:run"]
CMD ["./mvnw", "test"]
```
## Spaceships application 

The URL for the content is `http://localhost:8080/`

# REST API

Documentation for REST calls: [REST API](./REST.md)
