# Spring Boot REST API
Spring Boot REST API project

    'org.springframework.boot:spring-boot-starter-data-rest'
    'org.springframework.boot:spring-boot-starter-data-jpa'
    'com.h2database:h2'
    

## CRUD Operations (Postman Collection included)
* Get all places<br/>
`GET http://localhost:8080/places`

* Get place by name<br/>
`GET http://localhost:8080/places/name/Bern`

* Get place by id<br/>
`GET http://localhost:8080/places/{id}`

* Create new place<br/>
`POST http://localhost:8080/places`

* Update a place by id<br/>
`PUT http://localhost:8080/places/{id}`

* Delete a place by id<br/>
`DELETE http://localhost:8080/places/{id}`