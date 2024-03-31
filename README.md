# lets-build-a-spring-boot-app
Let's build a simple Spring Boot application w/REST API

# What does this application do?
This application provides a couple of GET and POST REST API endpoints. The POST `/foo/spam` endpoint allows the user to provide a message. The application would take this message and publish a message to a Kafka topic "spam-topic". Then, the application also demonstrates the subsequent consuming of the message from the Kafka topic and uses JPA repository to store the message in a PostgreSQL database.

## Run this application locally:
1. run `mvn clean install`
2. run `mvn spring-boot:run`
