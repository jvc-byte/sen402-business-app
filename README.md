# SEN402 Business Management System

A comprehensive business management system built with Spring Boot and JPA.

## Features

- Customer Management
- Product Management
- Supplier Management
- Payment Tracking
- Interactive Dashboard
- H2 Database Integration

## Technology Stack

- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- H2 Database
- Thymeleaf
- Bootstrap 5

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/jvc-byte/sen402-business-app.git
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
java -jar target/sen402-business-app-1.0-SNAPSHOT.jar
```

4. Access the application:
- Main application: http://localhost:8080
- H2 Console: http://localhost:8080/h2-console

## Database Configuration

H2 Console credentials:
- JDBC URL: `jdbc:h2:mem:businessdb`
- Username: `sa`
- Password: (empty)
