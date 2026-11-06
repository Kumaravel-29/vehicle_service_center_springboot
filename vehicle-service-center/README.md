# Vehicle Service Center Management System

A Java 17 / Spring Boot 3 REST API project for managing customers, vehicles, service jobs, mechanics, spare parts, invoices and service documents.

## Requirements
- JDK 17+
- Maven 3.8+
- MySQL 8+
- Postman (optional)

## Run in IntelliJ / Eclipse / VS Code
1. Extract this ZIP.
2. Create a MySQL user/database, or use a user that can create databases.
3. Open `src/main/resources/application.properties` and replace `YOUR_MYSQL_PASSWORD` with your MySQL password. Update username if needed.
4. Import the folder as an existing Maven project and wait for dependencies to download.
5. Run `VehicleServiceCenterApplication.java`.
6. Open Swagger: http://localhost:8080/swagger-ui/index.html

Or run from a terminal in this folder: `mvn spring-boot:run`.

Hibernate creates/updates the tables automatically (`ddl-auto=update`). For a real deployment, use Flyway/Liquibase migrations and set `ddl-auto=validate`.

## REST API examples
Base URL: `http://localhost:8080`

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/customers` | Register customer |
| GET | `/api/customers` | List customers |
| POST | `/api/vehicles` | Register vehicle |
| GET | `/api/vehicles` | List vehicles |
| POST | `/api/mechanics` | Add mechanic |
| GET | `/api/mechanics/available` | Available mechanics |
| POST | `/api/parts` | Add spare part |
| GET | `/api/parts/available` | Parts with stock |
| POST | `/api/service-requests` | Book a service job |
| PUT | `/api/service-requests/{id}/mechanic/{mechanicId}` | Assign mechanic |
| PATCH | `/api/service-requests/{id}/status?value=IN_PROGRESS` | Update job status |
| GET | `/api/service-requests/vehicle/{vehicleId}/history` | Vehicle service history |
| GET | `/api/service-requests?status=BOOKED&page=0&size=10&sortBy=createdAt` | Filter, paginate and sort |
| POST | `/api/service-requests/{id}/invoice` | Generate invoice after completion |
| POST | `/api/files/upload` | Upload service document (multipart form field `file`) |
| GET | `/api/files/{fileName}` | Download uploaded document |

## Postman request bodies

Register customer `POST /api/customers`:
```json
{"name":"Arun Kumar","email":"arun@example.com","phone":"9876543210"}
```
Register vehicle `POST /api/vehicles` (use the customer ID returned above):
```json
{"registrationNumber":"TN01AB1234","brand":"Hyundai","model":"i20","customerId":1}
```
Add mechanic `POST /api/mechanics`:
```json
{"name":"Ravi","specialization":"Engine service"}
```
Add part `POST /api/parts`:
```json
{"name":"Oil filter","unitPrice":450.00,"stock":20}
```
Book job `POST /api/service-requests` (use actual vehicle and part IDs):
```json
{"vehicleId":1,"description":"Periodic service and oil filter replacement","partIds":[1]}
```

## Concepts from the second photo
- **Config:** application properties, cache and security configuration.
- **Entity relationships:** Customer–Vehicle, Vehicle–ServiceRequest, ServiceRequest–Part, ServiceRequest–Invoice, Mechanic–ServiceRequest.
- **DTO + validation:** request records use Jakarta validation annotations; response DTO hides entity internals.
- **Mapper:** `ServiceRequestMapper` maps entity to response DTO.
- **Service:** business logic, pagination and sorting.
- **Repository:** derived methods, JPQL query and native SQL query examples.
- **Exception:** global REST exception handler.
- **Scheduler:** daily scheduled job at 9 AM (change cron as needed).
- **File upload/download:** `/api/files` endpoints; files are stored in local `uploads/` directory.
- **Connection pool:** HikariCP settings in properties.
- **Cache:** vehicle service history uses Spring Cache.
- **ResponseEntity:** controllers return meaningful HTTP status codes.
- **Logger + AOP:** service execution time is logged by `LoggingAspect`.
- **Transaction management:** booking, mechanic assignment, status updates and invoice generation use `@Transactional`.
- **Actuator + OpenAPI:** health/metrics and Swagger UI.
- **SpEL:** cache key `#vehicleId` is a Spring Expression Language expression in `@Cacheable`.

## Important production notes
This is an educational starter project. Security is intentionally configured to permit API calls so you can test easily in Postman; add authentication/authorization before deployment. Add role-based access, stronger file validation/storage, invoice labour charges/tax, stock deduction and audit fields before production. The scheduler currently logs a reminder job; connect it to actual due-service data and a notification provider for real reminders.
