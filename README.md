# Sales API

Sales API is a project...

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)

## Installation

### Prerequisites

- Java 8+
- PostgreSQL
- Spring Boot 3
- Maven or Gradle (for building the project)

### Clone the repository:

```bash
git clone https://github.com/MatPeretti/Sales-Restful-API
```

### Build the project:

```bash
mvn clean install
```

### Configure the database connection
Edit `application.properties` to configure the database connection.

## Usage
To run the application, use the following command:

``` bash 
java -jar spring-sales-api.jar 
```
The application runs by default in port 8080.

## API Documentation

POST `/auth/register`
```bash
{
  "cpf": "string",
  "firstname": "string",
  "lastname": "string",
  "username": "string",
  "password": "string"
}
```
Upon the successful registration of a new user, the system generates a JWT token, which is subsequently utilized for the authentication process.

<hr>

POST `/auth/authenticate`
```bash
{
  "username": "string",
  "password": "string"
}
```
The generated JWT token is utilized for authenticating the user in the API, and the newly created JWT token will be employed to initiate the request.

<hr>






