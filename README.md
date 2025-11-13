# University Management System (UMS) Microservices

This project implements a complete University Management System using a **microservices architecture** built with **Spring Boot 3** and **Spring Cloud**. It features a centralized **Eureka Discovery Server**, an **API Gateway** with **JWT-based authentication**, and several domain-specific services.

## 🚀 Technology Stack

| Component | Technology | Version | Notes |
| :--- | :--- | :--- | :--- |
| **Backend** | Spring Boot | 3.x | Java 17, Maven |
| **Microservices** | Spring Cloud | 2023.x | Eureka, Gateway, OpenFeign |
| **Authentication** | Spring Security, JWT | JJWT | Access and Refresh Tokens |
| **Database** | MySQL | 8.0 | Dedicated database per service |
| **Persistence** | Spring Data JPA | Hibernate | |
| **Documentation** | SpringDoc OpenAPI | Swagger UI | API documentation for each service |
| **Containerization** | Docker | Docker Compose | Full environment setup |

## 🏛️ Microservices Architecture

The system is composed of 8 distinct microservices:

| Service Name | Port | Description |
| :--- | :--- | :--- |
| `eureka-server` | 8761 | Service Discovery (Netflix Eureka) |
| `api-gateway` | 8080 | Entry point, routing, and JWT authentication filter |
| `auth-service` | 8081 | Handles user registration, login, JWT generation, and token validation. |
| `department-service` | 8083 | CRUD operations for university departments. |
| `faculty-service` | 8084 | CRUD operations for faculty members. |
| `student-service` | 8085 | CRUD operations for students. |
| `course-service` | 8086 | CRUD operations for courses, including assignment to faculty/department. |
| `enrollment-service` | 8087 | Handles student enrollment in courses. Uses Feign clients to communicate with `student-service` and `course-service`. |

## 🛠️ Setup and Run Instructions

The entire system is designed to be run using Docker Compose.

### Prerequisites

1.  Docker and Docker Compose installed.
2.  Maven (optional, for local development).

### 1. Build the Docker Images

Navigate to the root directory of the project (`ums-microservices`) and run the following command to build all service images:

```bash
docker-compose build
```

### 2. Run the System

Start all services and the MySQL databases using Docker Compose:

```bash
docker-compose up -d
```

**Note:** The services are configured to wait for the Eureka server and their respective MySQL databases to be available.

### 3. Accessing the System

| Component | URL |
| :--- | :--- |
| **API Gateway** | `http://localhost:8080` |
| **Eureka Dashboard** | `http://localhost:8761` |
| **Swagger UI (Auth Service)** | `http://localhost:8080/auth/v3/api-docs/swagger-ui.html` |
| **Swagger UI (Department Service)** | `http://localhost:8080/departments/v3/api-docs/swagger-ui.html` |
| **Swagger UI (Student Service)** | `http://localhost:8080/students/v3/api-docs/swagger-ui.html` |
| ... and so on for all services | |

### 4. Sample API Commands (using `curl`)

#### A. Register an Admin User

```bash
curl -X POST "http://localhost:8080/auth/register" \
-H "Content-Type: application/json" \
-d '{
  "username": "admin",
  "password": "password",
  "role": "ADMIN"
}'
```

#### B. Login and Get JWT Token

```bash
curl -X POST "http://localhost:8080/auth/login" \
-H "Content-Type: application/json" \
-d '{
  "username": "admin",
  "password": "password"
}'
# Save the 'accessToken' from the response
```

#### C. Create a Department (Requires JWT)

Replace `YOUR_ACCESS_TOKEN` with the token obtained in step B.

```bash
curl -X POST "http://localhost:8080/departments" \
-H "Content-Type: application/json" \
-H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
-d '{
  "name": "Computer Science",
  "code": "CS"
}'
```

## 🛑 Stop and Clean Up

To stop the running containers:

```bash
docker-compose down
```

To stop and remove all containers, networks, and volumes (database data):

```bash
docker-compose down -v
```
# University_Management_System_Microservices
