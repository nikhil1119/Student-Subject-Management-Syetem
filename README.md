# Student and Subject Management System

## Description

This project is a basic Spring Boot application that demonstrates the use of Spring MVC, Spring Security, and Spring Data JPA. The application manages students and subjects with a many-to-many relationship between them. The project includes a REST API for creating students, getting a list of all students, and getting a list of all subjects. It also uses JWT for authentication and authorization with two roles: student and admin.

## Technologies Used

- Spring Boot 3.3.2
- Spring MVC
- Spring Security 6
- Spring Data JPA
- JWT (jjwt-api, jjwt-impl, jjwt-jackson)
- H2 In-Memory Database

## Features

- Create a student
- Get a list of all students
- Get a list of all subjects
- JWT-based authentication and authorization
- Role-based access control for student and admin

## API Endpoints

### User Endpoints()
#### (First sign in before accessing any api endpoint as they require authorization)

- **Login (Obtain JWT Token)**
    - **URL:** `/signin`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "username": "admin",
        "password": "admin"
      }
      ```
    - **Response:**
      ```json
      {
        "jwtToken": "<JWT_TOKEN>",
        "username": "admin",
        "roles": ["ROLE_ADMIN"] 
      }
      ```

### Student Endpoints

- **Create a Student (Admin only)**
    - **URL:** `/api/students/create`
    - **Method:** POST
    - **Headers:**
        - `Authorization: Bearer <JWT_TOKEN>`
    - **Request Body:**
      ```json
      {
        "name": "Jane Doe",
        "address": "456 Elm St",
        "subjects": [
          {"name": "English"},
          {"name": "History"}
        ]
      }
      ```
    - **Response:**
      ```json
      {
        "id": 1,
        "name": "Jane Doe",
        "address": "456 Elm St",
        "subjects": [
          {"id": 1, "name": "English"},
          {"id": 2, "name": "History"}
        ]
      }
      ```

- **Get List of All Students (Admin only)**
    - **URL:** `/api/students/get-all`
    - **Method:** GET
    - **Headers:**
        - `Authorization: Bearer <JWT_TOKEN>`
    - **Response:**
      ```json
      [
        {
          "id": 1,
          "name": "Jane Doe",
          "address": "456 Elm St",
          "subjects": [
            {"id": 1, "name": "English"},
            {"id": 2, "name": "History"}
          ]
        },
        ...
      ]
      ```

### Subject Endpoints

- **Get List of All Subjects (Student and Admin)**
    - **URL:** `/api/subjects/get-all`
    - **Method:** GET
    - **Headers:**
        - `Authorization: Bearer <JWT_TOKEN>`
    - **Response:**
      ```json
      [
        {"id": 1, "name": "English"},
        {"id": 2, "name": "History"},
        ...
      ]
      ```

- **Create a Subject (Admin only)**
    - **URL:** `/api/subjects/create`
    - **Method:** POST
    - **Headers:**
        - `Authorization: Bearer <JWT_TOKEN>`
    - **Request Body:**
      ```json
      {
        "name": "Physics"
      }
      ```
    - **Response:**
      ```json
      {
        "id": 3,
        "name": "Physics"
      }
      ```

## Security

### Roles and Permissions

- **Student Role**
    - Can view the list of subjects

- **Admin Role**
    - Can create a student
    - Can view the list of subjects
    - Can view the list of students

### JWT Authentication

- JWT is used for securing the API endpoints.
- Users can log in with their credentials to obtain a JWT token, which should be included in the `Authorization` header of subsequent requests.
- Select `Bearer Token` in `Auth Type`

## Database Configuration

- The project uses an H2 in-memory database for simplicity.
- The `schema.sql` file is used to initialize the database schema.

## Setup and Running the Application

1. **Clone the repository:**
   ```js
   git clone <repository_url>
   cd <repository_directory>
   ```

2. **Build Command**
    ```js
    ./mvnw clean install
   ```

3. **Run Command**
    ```js
    ./mvnw spring-boot:run
   ```
   
