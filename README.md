# SEN402 Business Management System

A comprehensive business management system built with Spring Boot and JPA, designed to handle core business operations including customer management, product inventory, supplier relationships, and payment tracking.

## Table of Contents
1. [Project Overview](#project-overview)
2. [System Architecture](#system-architecture)
3. [Features](#features)
4. [Technology Stack](#technology-stack)
5. [Project Structure](#project-structure)
6. [Installation](#installation)
7. [Configuration](#configuration)
8. [Usage Guide](#usage-guide)
9. [API Documentation](#api-documentation)
10. [Database Schema](#database-schema)
11. [Contributing](#contributing)

## Project Overview

The SEN402 Business Management System is a web-based application that provides a centralized platform for managing various aspects of business operations. It offers an intuitive interface for handling customers, products, suppliers, and financial transactions.

### Key Benefits
- Centralized business data management
- Real-time inventory tracking
- Customer relationship management
- Payment tracking and history
- Supplier management and product sourcing
- User-friendly dashboard interface

## System Architecture

The application follows a layered architecture pattern:

1. **Presentation Layer**
   - Thymeleaf templates for server-side rendering
   - Bootstrap 5 for responsive UI design
   - Interactive web forms and tables

2. **Application Layer**
   - Spring MVC controllers for request handling
   - Business logic implementation
   - Data validation and processing

3. **Data Access Layer**
   - Spring Data JPA repositories
   - Entity mappings and relationships
   - Transaction management

4. **Database Layer**
   - H2 in-memory database
   - JPA/Hibernate for ORM

## Features

### 1. Dashboard
- Overview of system statistics
- Quick navigation to all modules
- Recent activity summary

### 2. Customer Management
- Add new customers
- View customer details
- Track customer payments
- Customer purchase history
- Fields:
  - Customer ID (auto-generated)
  - Name
  - Email
  - Associated payments
  - Purchased products

### 3. Product Management
- Product inventory tracking
- Add new products
- Link products to suppliers
- Fields:
  - Product ID (auto-generated)
  - Name
  - Price
  - Supplier association

### 4. Supplier Management
- Supplier registration
- View supplier details
- Track supplied products
- Fields:
  - Supplier ID (auto-generated)
  - Name
  - Contact Information
  - Associated products

### 5. Payment System
- Record customer payments
- Payment history tracking
- Fields:
  - Payment ID (auto-generated)
  - Amount
  - Payment Date
  - Associated Customer

## Technology Stack

### Backend
- Java 17
- Spring Boot 3.1.0
- Spring Data JPA
- Jakarta Persistence (JPA)
- Hibernate ORM

### Frontend
- Thymeleaf 3.x
- Bootstrap 5.1.3
- HTML5
- CSS3
- JavaScript

### Database
- H2 Database (In-memory)
- JPA/Hibernate

### Build Tools
- Maven
- Spring Boot Maven Plugin

## Project Structure

```
sen402-business-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── business/
│   │   │           ├── BusinessApplication.java
│   │   │           ├── controller/
│   │   │           │   ├── CustomerController.java
│   │   │           │   ├── HomeController.java
│   │   │           │   ├── PaymentController.java
│   │   │           │   ├── ProductController.java
│   │   │           │   └── SupplierController.java
│   │   │           ├── entity/
│   │   │           │   ├── Customer.java
│   │   │           │   ├── Payment.java
│   │   │           │   ├── Product.java
│   │   │           │   └── Supplier.java
│   │   │           └── repository/
│   │   │               ├── CustomerRepository.java
│   │   │               ├── PaymentRepository.java
│   │   │               ├── ProductRepository.java
│   │   │               └── SupplierRepository.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── dashboard.html
│   │       │   ├── customers.html
│   │       │   ├── products.html
│   │       │   ├── suppliers.html
│   │       │   └── payments.html
│   │       ├── application.properties
│   │       └── META-INF/
│   │           └── persistence.xml
└── pom.xml
```

## Installation

1. Prerequisites:
   - Java 17 or higher
   - Maven 3.6 or higher
   - Git

2. Clone the repository:
```bash
git clone https://github.com/jvc-byte/sen402-business-app.git
cd sen402-business-app
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
java -jar target/sen402-business-app-1.0-SNAPSHOT.jar
```

## Configuration

### Application Properties
```properties
# Server Configuration
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:h2:mem:businessdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## Usage Guide

### Accessing the Application
1. Start the application
2. Open a web browser
3. Navigate to `http://localhost:8080`

### Main Features

1. **Dashboard Navigation**
   - Access all modules from the main dashboard
   - View system overview and statistics

2. **Managing Customers**
   - Click "Customers" in the navigation bar
   - Use the form to add new customers
   - View customer list in the table below

3. **Product Management**
   - Navigate to "Products" section
   - Add new products with supplier associations
   - View and manage product inventory

4. **Supplier Operations**
   - Access "Suppliers" section
   - Register new suppliers
   - Track supplier products

5. **Payment Processing**
   - Go to "Payments" section
   - Record new payments
   - View payment history

### Database Access
1. Navigate to `http://localhost:8080/h2-console`
2. Enter the following credentials:
   - JDBC URL: `jdbc:h2:mem:businessdb`
   - Username: `sa`
   - Password: (leave empty)

## API Documentation

### Entity Relationships
1. **Customer**
   - Has many Payments
   - Has many Products (purchased)

2. **Product**
   - Belongs to one Supplier
   - Belongs to many Customers

3. **Supplier**
   - Has many Products

4. **Payment**
   - Belongs to one Customer

### Database Schema

```sql
CREATE TABLE customer (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price DECIMAL(19,2),
    supplier_id BIGINT
);

CREATE TABLE supplier (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    contact_info VARCHAR(255)
);

CREATE TABLE payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DECIMAL(19,2),
    payment_date TIMESTAMP,
    customer_id BIGINT
);
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

---

For questions or support, please open an issue in the GitHub repository.
