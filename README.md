# WESTERN GOVERNORS UNIVERSITY 
## D288 – BACK-END PROGRAMMING


## E-commerce Backend with Java Spring Boot

This repository contains the backend code for an e-commerce application developed as part of a school project. Built with Java Spring Boot, the backend is designed to handle customer management, order processing, and inventory tracking. This back end interacts with a MySQL database and is fully equipped to support CRUD operations, custom exception handling, and integration with an Angular front end (not included in this repository).

The backend’s REST APIs are configured to work seamlessly with the Angular front end, which provides users with an interactive experience for managing orders and customer profiles. This project serves as a showcase of best practices in backend development, database management, and Java Spring Boot architecture.

# Key Features

    Customer Management: Users can add, view, and update customer profiles, including address, phone number, and associated division.
    Order Processing: Implements checkout functionality that captures cart details, processes orders, and assigns tracking numbers.
    Inventory and Division Management: Links customers to divisions (e.g., regional or departmental) and manages cart contents.

# Technologies Used

    Back End: Java Spring Boot for REST APIs, JPA for data persistence, and custom exception handling with @RestControllerAdvice.
    Front End: Angular for an interactive user interface and seamless communication with the back end.
    Database: MySQL database managed through MySQL Workbench, configured with relevant entity classes (e.g., Customer, Cart, Division) and JPA mappings.
    Other Tools: Lombok for reducing boilerplate code, Hibernate for ORM, and Slf4j for logging.

# Getting Started
#  - Prerequisites

    Java 17 (or higher) and Maven
    Node.js and Angular CLI
    MySQL: Ensure you have MySQL Server running and MySQL Workbench installed for database management.
