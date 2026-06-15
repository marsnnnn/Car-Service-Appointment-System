# Car Service Booking System

Car Service Booking System este o aplicație web backend dezvoltată în Java cu Spring Boot, destinată gestionării programărilor pentru un service auto. Aplicația permite înregistrarea programărilor clienților, salvarea datelor în baza de date și afișarea tuturor programărilor existente prin endpoint-uri REST.

Proiectul folosește o arhitectură simplă, organizată pe straturi: controller, service, repository și entity. Comunicarea cu baza de date se realizează prin Spring Data JPA, iar testarea endpoint-urilor se poate face cu Postman.

## Tehnologii folosite

- Java
- Maven
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Postman
- Swagger / OpenAPI

## Scopul proiectului

Scopul aplicației este de a oferi o soluție simplă pentru administrarea programărilor într-un service auto. Prin intermediul aplicației, un client poate fi înregistrat cu datele sale de contact, modelul mașinii, tipul serviciului solicitat, data programării și statusul programării.

Aplicația poate fi folosită ca bază pentru un sistem mai complex de management al unui service auto, unde pot fi adăugate ulterior funcționalități precum editarea programărilor, anularea acestora, autentificarea utilizatorilor sau administrarea mecanicilor.

## Structura proiectului

```text
src/main/java/org/example
├── App.java
├── controller
│   └── ServiceBookingController.java
├── entity
│   └── ServiceBooking.java
├── repository
│   └── ServiceBookingRepository.java
└── service
    └── ServiceBookingService.java
```

### Rolul componentelor principale

- `App.java` — clasa principală care pornește aplicația Spring Boot.
- `ServiceBooking.java` — entitatea care reprezintă o programare pentru service auto.
- `ServiceBookingRepository.java` — interfața care permite lucrul cu baza de date.
- `ServiceBookingService.java` — clasa care conține logica aplicației.
- `ServiceBookingController.java` — controllerul REST care expune endpoint-urile aplicației.

## Funcționalități

Aplicația oferă următoarele funcționalități principale:

1. Afișarea tuturor programărilor existente.
2. Crearea unei programări noi pentru service auto.
3. Salvarea programărilor în baza de date PostgreSQL.
4. Setarea automată a statusului `NEW` dacă statusul nu este transmis în request.
5. Testarea endpoint-urilor cu Postman.
6. Vizualizarea documentației API prin Swagger.

## Modelul de date

Entitatea principală a proiectului este `ServiceBooking`. Aceasta conține următoarele câmpuri:

| Câmp | Descriere |
|---|---|
| `id` | Identificator unic generat automat |
| `customerName` | Numele clientului |
| `email` | Adresa de email a clientului |
| `phone` | Numărul de telefon al clientului |
| `carModel` | Modelul automobilului |
| `serviceType` | Tipul serviciului solicitat |
| `appointmentDate` | Data și ora programării |
| `status` | Statusul programării |

Tabela generată în baza de date se numește:

```text
service_bookings
```

## Endpoint-uri REST

### 1. Listarea tuturor programărilor

```http
GET http://localhost:8080/bookings
```

Acest endpoint returnează lista tuturor programărilor salvate în baza de date.

### 2. Crearea unei programări noi

```http
POST http://localhost:8080/bookings
Content-Type: application/json
```

Exemplu de body JSON:

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

Dacă valoarea pentru `status` nu este transmisă, aplicația setează automat statusul la:

```text
NEW
```

## Configurarea bazei de date

Proiectul folosește PostgreSQL. Înainte de rularea aplicației, trebuie creată baza de date:

```sql
CREATE DATABASE car_service_db;
```

Configurația bazei de date se află în fișierul:

```text
src/main/resources/application.properties
```

Configurație implicită:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/car_service_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

Dacă parola pentru PostgreSQL este diferită, aceasta trebuie modificată în `application.properties`.

## Rularea proiectului

Din folderul principal al proiectului, aplicația poate fi pornită cu Maven:

```bash
mvn spring-boot:run
```

Alternativ, se poate face build și apoi se poate rula fișierul `.jar` generat:

```bash
mvn clean package
java -jar target/car-service-booking-system-1.0-SNAPSHOT.jar
```

După pornire, aplicația rulează implicit pe portul:

```text
8080
```

## Testare în Postman

În folderul `postman/` există o colecție Postman care poate fi importată pentru testarea endpoint-urilor:

```text
Car_Service_Booking_System.postman_collection.json
```

Colecția conține request-uri pentru:

- `GET All Bookings`
- `POST Create Booking`

## Swagger / OpenAPI

După pornirea aplicației, documentația API poate fi accesată în browser la adresa:

```text
http://localhost:8080/swagger-ui/index.html
```

## Concluzie

Car Service Booking System este o aplicație backend simplă și funcțională pentru gestionarea programărilor într-un service auto. Proiectul demonstrează utilizarea tehnologiilor Java, Spring Boot, Maven, PostgreSQL și Postman pentru dezvoltarea și testarea unui API REST conectat la o bază de date relațională.
