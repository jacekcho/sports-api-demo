# Sports API Demo

This project demonstrates a simple RESTful API for managing sports data.

## Requirements

- Java 17

## Getting Started

To run the project, you can follow these steps:

1. Clone the repository to your local machine.
2. Build the project using Maven.

Unix:
```
./mvnw clean install
```

Windows:
```
./mvnw.cmd clean install
```

3. Run the application  
```
java -jar target/sports-api-demo-0.0.1.jar
```

## Usage

Once the application is running, you can interact with the API using HTTP requests.

- **GET http://localhost:8080/sports**: Retrieve all sports.

- **GET http://localhost:8080/sports/{id}**: Retrieve a sport by ID.<br>

- **POST http://localhost:8080/sports/{id}**: Create a new sport.<br>
  Request body:

  ```yaml 
  {
    "name": "SPORT_NAME",
    "active": true,
    "competitions": [
      {
        "id": "COMPETITON_ID",
        "name": "COMPETITON_NAME"
      }
    ]
  }
  ```
- **PUT http://localhost:8080/sports/{id}**: Update an existing sport with the given ID.<br>
  Request body:

  ```yaml 
  {
    "name": "UPDATED_SPORT_NAME",
    "active": false,
    "competitions": [
      {
        "id": "UPDATED_COMPETITON_ID",
        "name": "UPDATED_COMPETITON_NAME"
      }
    ]
  }
  ```

Make sure to replace `{id}` with the actual ID of the sport when making requests.<br>