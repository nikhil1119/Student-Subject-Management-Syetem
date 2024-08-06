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

### Student Endpoints

- **Create a Student**
    - **URL:** `/api/students`
    - **Method:** POST
    - **Request Body:**
      ```json
      {
        "name": "John Doe",
        "address": "123 Main St",
        "subjects": [
          {"name": "Math"},
          {"name": "Science"}
        ]
      }
      ```

- **Get List of All Students**
    - **URL:** `/api/students`
    - **Method:** GET

### Subject Endpoints

- **Get List of All Subjects**
    - **URL:** `/api/subjects`
    - **Method:** GET

## Security

### Roles and Permissions

- **Student Role**
    - Can view the list of subjects
    - Can view the list of students

- **Admin Role**
    - Can create a student
    - Can view the list of subjects
    - Can view the list of students

### JWT Authentication

- JWT is used for securing the API endpoints.
- Users can log in with their credentials to obtain a JWT token, which should be included in the `Authorization` header of subsequent requests.

## Database Configuration

- The project uses an H2 in-memory database for simplicity.
- No additional setup is required for the database.

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

2. **Run Command**
    ```js
    ./mvnw spring-boot:run
   ```
   
