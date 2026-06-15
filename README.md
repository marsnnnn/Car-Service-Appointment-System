# Car Service Booking System

Aceasta este o copie a proiectului inițial `Medical Appointment System`, dar tema a fost schimbată într-un sistem de programări pentru service auto.

Aplicația păstrează aceeași idee tehnică:

- Java
- Maven
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Postman pentru testare

## Transformarea temei

| Proiect inițial | Proiect nou |
|---|---|
| Medical Appointment System | Car Service Booking System |
| `Patient` | `ServiceBooking` |
| `PatientController` | `ServiceBookingController` |
| `PatientService` | `ServiceBookingService` |
| `PatientRepository` | `ServiceBookingRepository` |
| `/patients` | `/bookings` |
| `medical_db` | `car_service_db` |

## Funcționalități păstrate

Proiectul inițial avea două funcții REST principale. Acestea au fost păstrate:

### 1. Listarea tuturor programărilor

```http
GET http://localhost:8080/bookings
```

### 2. Crearea unei programări noi

```http
POST http://localhost:8080/bookings
Content-Type: application/json
```

Exemplu body JSON:

```json
{
  "customerName": "Ion Popescu",
  "email": "ion.popescu@example.com",
  "phone": "+37369123456",
  "carModel": "Volkswagen Golf 7",
  "serviceType": "Oil change",
  "appointmentDate": "2026-06-20 10:30",
  "status": "NEW"
}
```

Dacă `status` nu este trimis, aplicația îl setează automat la `NEW`.

## Baza de date

Proiectul folosește PostgreSQL, la fel ca proiectul inițial.

Creează baza de date:

```sql
CREATE DATABASE car_service_db;
```

Sau rulează fișierul:

```text
database/create_database.sql
```

Configurația se află în:

```text
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/car_service_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

Hibernate va crea automat tabela `service_bookings` la pornirea aplicației.

## Rulare proiect

Din folderul proiectului:

```bash
mvn spring-boot:run
```

Sau build:

```bash
mvn clean package
java -jar target/car-service-booking-system-1.0-SNAPSHOT.jar
```

## Testare în Postman

În folderul `postman/` există colecția:

```text
Car_Service_Booking_System.postman_collection.json
```

Importă colecția în Postman și testează request-urile:

- `GET All Bookings`
- `POST Create Booking`

## Swagger / OpenAPI

După pornirea aplicației, documentația API poate fi accesată la:

```text
http://localhost:8080/swagger-ui/index.html
```
