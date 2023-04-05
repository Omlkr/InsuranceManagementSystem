# InsuranceManagementSystem

This is a sample insurance management platform built with Spring Boot, Spring Data JPA, and an embedded H2 database. The platform allows users to manage clients, insurance policies, and claims.

Features
The platform provides the following features:

Create, read, update, and delete clients
Create, read, update, and delete insurance policies
Create, read, update, and delete claims
Associate insurance policies with clients and claims with insurance policies
Exception handling and validation for proper API usage and data integrity
Project Structure
The project structure is as follows:

css
Copy code
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.example.insurance
│   │   │   │   ├── controller
│   │   │   │   │   ├── ClientController.java
│   │   │   │   │   ├── InsurancePolicyController.java
│   │   │   │   │   └── ClaimController.java
│   │   │   │   ├── exception
│   │   │   │   │   ├── ClientNotFoundException.java
│   │   │   │   │   ├── InsurancePolicyNotFoundException.java
│   │   │   │   │   └── ClaimNotFoundException.java
│   │   │   │   ├── model
│   │   │   │   │   ├── Client.java
│   │   │   │   │   ├── InsurancePolicy.java
│   │   │   │   │   └── Claim.java
│   │   │   │   ├── repository
│   │   │   │   │   ├── ClientRepository.java
│   │   │   │   │   ├── InsurancePolicyRepository.java
│   │   │   │   │   └── ClaimRepository.java
│   │   │   │   ├── service
│   │   │   │   │   ├── ClientService.java
│   │   │   │   │   ├── InsurancePolicyService.java
│   │   │   │   │   └── ClaimService.java
│   │   │   │   └── InsuranceApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── data.sql
│   │       └── schema.sql
│   └── test
│       ├── java
│       │   └── com.example.insurance
│       │       ├── controller
│       │       │   ├── ClientControllerTest.java
│       │       │   ├── InsurancePolicyControllerTest.java
│       │       │   └── ClaimControllerTest.java
│       │       ├── service
│       │       │   ├── ClientServiceTest.java
│       │       │   ├── InsurancePolicyServiceTest.java
│       │       │   └── ClaimServiceTest.java
│       │       └── InsuranceApplicationTests.java
│       └── resources
│           └── application.properties
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

The com.example.insurance package contains the main application code, including controllers, services, and repositories. The model package contains the domain models, while the exception package contains custom exception classes. The resources directory contains the schema.sql and data.sql files for initializing the embedded H2 database.
