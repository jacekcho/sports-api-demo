# Sports API Demo

This project demonstrates a simple RESTful API for managing sports data.

## Requirements

- Java 17

## Getting Started

To run the project, you can follow these steps:

1. Clone the repository to your local machine.
2. Build the project using Maven.
```
cd sports-api-demo
./mvnw clean install
```
3. Run the application  
```
java -jar target/sports-api-demo-0.0.1.jar
```

## Usage

Once the application is running, you can interact with the API using HTTP requests. Here are some example requests:

- **GET http://localhost:8080/sports**: Retrieve all sports.
- **POST http://localhost:8080/sports/:id**: Add a new sport.
- **GET http://localhost:8080/sports/:id**: Retrieve a sport by ID.

Make sure to replace `:id` with the actual ID of the sport when making requests.

## Configuration

The project uses a configuration file `config.properties` to manage application settings. You can configure properties such as the Spark port and the file path for default sports data.
