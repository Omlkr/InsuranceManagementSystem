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

Implement RESTful APIs for the following actions:

a. Clients:
    i. GET /api/clients: Fetch all clients.
    ii. GET /api/clients/{id}: Fetch a specific client by ID.
    iii. POST /api/clients: Create a new client.
    iv. PUT /api/clients/{id}: Update a client's information.
    v. DELETE /api/clients/{id}: Delete a client.

b. Insurance Policies:
    i. GET /api/policies: Fetch all insurance policies.
    ii. GET /api/policies/{id}: Fetch a specific insurance policy by ID.
    iii. POST /api/policies: Create a new insurance policy.
    iv. PUT /api/policies/{id}: Update an insurance policy.
    v. DELETE /api/policies/{id}: Delete an insurance policy.

c. Claims:
    i. GET /api/claims: Fetch all claims.
    ii. GET /api/claims/{id}: Fetch a specific claim by ID.
    iii. POST /api/claims: Create a new claim.
    iv. PUT /api/claims/{id}: Update a claim's information.
    v. DELETE /api/claims/{id}: Delete a claim.


The com.example.insurance package contains the main application code, including controllers, services, and repositories. The model package contains the domain models, while the exception package contains custom exception classes. The resources directory contains the schema.sql and data.sql files for initializing the embedded H2 database.



