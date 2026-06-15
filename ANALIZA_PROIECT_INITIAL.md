# Analiza proiectului inițial: Medical Appointment System

Proiectul încărcat este o aplicație Java Spring Boot construită cu Maven. Tema lui este un sistem medical, însă implementarea efectivă conține o singură resursă principală: `Patient`.

## Tehnologii folosite

- Java 21
- Maven
- Spring Boot 3.1.5
- Spring Web pentru endpoint-uri REST
- Spring Data JPA pentru lucrul cu baza de date
- PostgreSQL ca bază de date
- Postman pentru testarea endpoint-urilor

## Structura proiectului inițial

```text
src/main/java/org/example/App.java
src/main/java/org/example/controller/PatientController.java
src/main/java/org/example/entity/Patient.java
src/main/java/org/example/repository/PatientRepository.java
src/main/java/org/example/service/PatientService.java
src/main/resources/application.properties
```

## Funcționalități identificate

### 1. Pornirea aplicației

`App.java` pornește aplicația Spring Boot prin `SpringApplication.run(...)`.

### 2. Entitatea principală

`Patient.java` este o entitate JPA. Are câmpurile:

- `id`
- `name`
- `email`
- `phone`

### 3. Repository

`PatientRepository` extinde `JpaRepository<Patient, Long>`, deci oferă metode standard pentru salvare și citire din baza de date.

### 4. Service

`PatientService` conține logica simplă:

- `getAllPatients()` — întoarce toate înregistrările
- `savePatient(patient)` — salvează o înregistrare nouă

### 5. Controller REST

`PatientController` expune două endpoint-uri:

- `GET /patients` — listează toți pacienții
- `POST /patients` — creează un pacient nou

### 6. Configurarea bazei de date

În `application.properties`, proiectul inițial folosește PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/medical_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

## Observație

Proiectul inițial are doar operații de creare și afișare. Nu există endpoint-uri pentru update, delete sau căutare după id. Din acest motiv, copia pe tema nouă păstrează aceleași funcții: creare și listare.
