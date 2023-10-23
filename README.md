# Sales API

The Sales API is a Java project developed using Spring Boot, designed to serve as a learning resource for REST API fundamentals and basic security implementation. It provides a platform to explore user authentication, product management, and order processing.

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

### Usage
To run the application, use the following command:

``` bash 
java -jar Sales-0.0.1-SNAPSHOT.jar
```
The application runs by default in port 8080.

## API Documentation


**POST** `/auth/register` <br>

**Status Code:** 200 OK

```json
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

**POST** `/auth/authenticate` <br>

**Status Code:** 200 OK

```json
{
  "username": "string",
  "password": "string"
}
```
The generated JWT token is utilized for authenticating the user in the API, and the newly created JWT token will be employed to initiate the request.

<hr>

**GET** `/client` or `/client/{id}`<br>

**Status Code:** 200 ok
```json
{
    "id": 1,
    "username": "string",
    "firstname": "string",
    "lastname": "string",
    "cpf": "string",
    "role": "USER",
    "enabled": true,
    "authorities": [
        {
            "authority": "USER"
        }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true
}
```

This endpoint retrieves client information you can either specify a particular client by providing its unique `id` as a path parameter or retrieve a list of all clients by omitting the `id`.


- `accountNonExpired` (boolean): Indicates if the client's account has not expired (true or false).
- `accountNonLocked` (boolean): Indicates if the client's account is not locked (true or false).
- `credentialsNonExpired` (boolean): Indicates if the client's credentials have not expired (true or false).

<hr>

**PUT** `/client/{id}` <br>

**Status Code:** 204 No Content

```json
{
  "id": 1,
  "username": "string",
  "firstname": "string",
  "lastname": "string",
  "cpf": "string",
  "password": "string",
  "role": "USER"
```
Make sure to replace {id} in the path with the actual ID of the client you want to update.
The client's role, which can be one of the following values: "user" (for regular users) or "admin" (for administrators).

<hr>

**DELETE** `/client/{id}`<br>

This endpoint allows you to delete a client by sending a `DELETE` request to `/client/{id}`.
Upon successful deletion, the server will respond with a `204 No Content` status code. This indicates that the client has been deleted, and there is no response body.

**Status Code:** 204 No Content

<hr>

**POST** `/product` <br>

**Status Code:** 201 Created

```json
{
    "id": 1,
    "description": "string",
    "price": 0
}
```

This endpoint allows you to add a new product to the system.

<hr>

**GET** `/product` or `/product/{id}`

**Status Code:** 200 OK

```json
{
    "id": 1,
    "description": "string",
    "price": 0
}
```

This endpoint retrieves product information. You can either specify a particular product by providing its unique `id` as a path parameter or retrieve a list of all products by omitting the `id`.

<hr>

**PUT** `/product/{id}`

**Status Code:** 204 No Content

```json
{
    "id": 1,
    "description": "string",
    "price": 0
}
```

This endpoint allows you to update an existing product by specifying its unique `id` as a path parameter.

<hr>

**DELETE** `/product/{id}`

**Status Code:** 204 No Content

This endpoint allows you to delete an existing product by specifying its unique `id` as a path parameter. the server responds with a `204 No Content` status code, indicating that the product has been successfully removed. There is no response body for this status code.

<hr>

**POST** `/clientorder`

**Status Code:** 201 Created

```json
{
  "client": 1,
  "total": 0,
  "items": [
    {
      "product": 1,
      "quantity": 0
    }
  ]
}
```

This endpoint allows you to create a new order. The request should include a JSON object with the following properties:
- `client` (integer): The unique identifier of the client placing the order.
- `total` (number): The total cost of the order.
- `items` (array of objects): An array of items in the order, each containing:
    - `product` (integer): The unique identifier of the product.
    - `quantity` (integer): The quantity of the product in the order.

<hr>

**GET** `/clientorder/{id}`

**Status Code:** 200 OK

```json
{
    "orderId": 1,
    "username": "string",
    "cpf": "string",
    "clientFirstName": "string",
    "clientLastName": "string",
    "total": 0,
    "orderDate": "10/23/2023",
    "orderStatus": "COMPLETED",
    "items": [
        {
            "productDescription": "string",
            "unitPrice": 0,
            "quantity": 0
        }
    ]
}
```

This endpoint retrieves client order information based on the provided order ID.

<hr>

**PATCH** `/clientorder/{id}`

**Status Code:** 204 No Content

```json
{
  "newStatus": "string"
}
```

This endpoint allows you to update the status of a client order based on the provided order ID. 
- `newStatus` (string): The new status for the client order. It can be "completed" or "canceled."























