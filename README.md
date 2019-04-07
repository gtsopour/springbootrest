# Spring Boot REST API project (spring-data-rest, spring-data-jpa, h2 database)
Spring Boot REST API project (spring-data-rest, spring-data-jpa, h2 database)

    'org.springframework.boot:spring-boot-starter-data-rest'
    'org.springframework.boot:spring-boot-starter-data-jpa'
    'com.h2database:h2'
    

## CRUD Operations (Postman collection is included)
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

## Places Array (@Id @GenericGenerator(name="system-uuid", strategy = "uuid2"))
    [
        {
            "id": "cfdafea1-5b8f-4b67-9a28-206e21ae30e1",
            "name": "Zurich",
            "description": "Zurich description"
        },
        {
            "id": "9ede8e67-20e3-46a3-8ac2-6e2430f1af78",
            "name": "St. Gallen",
            "description": "St. Gallen description"
        },
        {
            "id": "3ef27384-3753-46b2-b610-6e7ff2eb636b",
            "name": "Bern",
            "description": "Bern description"
        },
        {
            "id": "698e574a-d129-45b6-b38a-002485b70c13",
            "name": "Luzern",
            "description": "Luzern description"
        },
        {
            "id": "60b963a2-1476-4953-a282-cb24ad11815c",
            "name": "Basel",
            "description": "Basel description"
        },
        {
            "id": "3dacb04f-3c36-4646-814a-fb9069bdcabf",
            "name": "Geneva (Updated)",
            "description": "Geneva description (Updated)"
        }
    ]
