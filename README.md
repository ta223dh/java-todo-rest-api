# Java Todo Test API

A simple REST service for a task board that allows users to create and manage different lists of tasks, with data persisted across devices.

Please see the project board for current issues:  
https://github.com/users/ta223dh/projects/1

## Project architecture

The project is based on Spring boot initializr (https://start.spring.io) with the following dependencies 
- Spring Web
- MySQL Driver
- Spring Data JPA
- Spring Boot DevTools

It runs the spring application directly on the local machine, and a MySQL database in docker.

## Developer Setup

### Prerequisites

- Java 17  
- Docker  

### Configure the environment

Copy the example environment file and adjust values as needed:

    cp .example.env .env

### Start mysql db

    docker compose up

### Run the application

    ./gradlew bootRun      # macOS / Linux
    .\gradlew.bat bootRun  # Windows

### Run the tests

    ./gradlew test         # macOS / Linux
    .\gradlew.bat test     # Windows

---

## API Overview

Base path:

- `/api` (implemented)

Status legend:

- `[✓]` Implemented  
- `[~]` In progress  
- `[✗]` Not implemented  

---

## Endpoints

The application is available on localhost:8080/

### Lists

Base resource: `/api/lists`

| Method | Endpoint       | Status        | Notes            |
|--------|----------------|---------------|------------------|
| GET    | /lists         | [~] In progress | List all lists   |
| POST   | /lists         | [✗] Not implemented | Create a list |
| PATCH  | /lists/{id}    | [✗] Not implemented | Update a list |
| DELETE | /lists/{id}    | [✗] Not implemented | Delete a list |

### Items

Base resource: `/api/items`

| Method | Endpoint       | Status            | Notes              |
|--------|----------------|-------------------|--------------------|
| GET    | /items         | [✗] Not implemented | List all items  |
| POST   | /items         | [✗] Not implemented | Create an item  |
| PATCH  | /items/{id}    | [✗] Not implemented | Update an item  |
| DELETE | /items/{id}    | [✗] Not implemented | Delete an item  |

---

Readme generated with ChatGPT.
