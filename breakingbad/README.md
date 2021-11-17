## Breaking Bad API

An application to consume Breaking Bad API and to favorite characters from that.

## Requirements
- JDK-11
- Lombok plugin for your IDE
- git

or

- Docker properly installed if you want to run using the available docker image

## Install and run the app

With the source code:
```bash
git clone git@github.com:bclaud/arquitetura-hexagonal.git
cd arquitetura-hexagonal/breakingbad
./mvnw spring-boot:run
```

With docker image 
```bash
docker run -p 8080:8080 -d --name breakingbadApi baclaud/breakingbad:latest
```

## Endpoints

GET in /api/v1/characters: returns a list of all characters from breaking bad

GET in /api/v1/characters/{id}: returns the character from given ID

POST in /api/v1/favorites/{id}: favorites and returns a character from given ID

PATCH in /api/v1/favorites: Receives a json body with id(int) and favorite(boolean) to updated a favorited character

GET in /api/v1/favorites: returns a list with all favorited characters

GET in /api/v1/favorites/{id}: returns the favorite character from given ID

## Specifications 

You can check and test every specification in {{baseURL}}/swagger-ui/ while the app is running.

There is also a postman collection available in resources package of the project