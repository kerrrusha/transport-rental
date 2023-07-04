[![CircleCI](https://dl.circleci.com/status-badge/img/gh/kerrrusha/transport-rental/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/kerrrusha/transport-rental/tree/master)

# Transport Rental - Spring Web App
Spring Web Application that logs renting company transport by customers, writing down all the necessary information.
### Microservices
- **data**
- **web**

### Getting Started
- Install MySQL
- Manually create DB from `resources/schema.sql` file
- Properly configure DB connection credentials at `resources/application.properties`
- Start application

Default URL is `localhost:8080/`, unless you specify custom port in `application.properties`.

### Used technologies
- Java 17
- Spring Boot 3.1.0
- Spring Web (MVC / REST API)
- Spring Data
- Thymeleaf
- Mockito
- JPA Validation