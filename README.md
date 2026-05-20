# University Management System - WM2 Lab8

This repository contains a small university management system built as two Spring Boot microservices:

- `student-service` manages student records.
- `course-service` manages courses, enrollments, prerequisite validation, and course lookup by student name.

## Technologies

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Cloud OpenFeign
- Springdoc OpenAPI / Swagger UI
- PostgreSQL
- Gradle
- Docker Compose

## Services and Ports

| Service | Port | Swagger |
| --- | --- | --- |
| student-service | `9090` | `http://localhost:9090/swagger-ui/index.html` |
| course-service | `8081` | `http://localhost:8081/swagger-ui/index.html` |
| studentDB | `5432` | PostgreSQL |
| courseDB | `5433` | PostgreSQL mapped to container port `5432` |

## Run with Docker Compose

Start databases and both services:

```bash
docker compose up --build
```

Stop services:

```bash
docker compose down
```

Remove database volumes for a clean restart:

```bash
docker compose down -v
```

## Run Locally with Gradle

Start PostgreSQL first:

```bash
docker compose up student-db course-db
```

The default local application properties expect:

- `studentDB` on `localhost:5432`
- `courseDB` on `localhost:5432`

If you use the Docker Compose database containers, run each service from a separate terminal with explicit datasource settings.

Run student-service:

```bash
$env:SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/studentDB"
$env:SPRING_DATASOURCE_USERNAME="postgres"
$env:SPRING_DATASOURCE_PASSWORD="password"
.\gradlew.bat :student-service:bootRun
```

Run course-service:

```bash
$env:SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5433/courseDB"
$env:SPRING_DATASOURCE_USERNAME="postgres"
$env:SPRING_DATASOURCE_PASSWORD="password"
$env:STUDENT_SERVICE_BASE_URL="http://localhost:9090"
.\gradlew.bat :course-service:bootRun
```

Clear the environment variables in a terminal when needed:

```bash
Remove-Item Env:SPRING_DATASOURCE_URL,Env:SPRING_DATASOURCE_USERNAME,Env:SPRING_DATASOURCE_PASSWORD,Env:STUDENT_SERVICE_BASE_URL -ErrorAction SilentlyContinue
```

## Test and Build

Run all tests:

```bash
.\gradlew.bat test
```

Build both services:

```bash
.\gradlew.bat build
```

## Main API Examples

Create a student:

```bash
curl -X POST http://localhost:9090/api/v1/students ^
  -H "Content-Type: application/json" ^
  -d "{\"firstName\":\"Nicat\",\"lastName\":\"Aliyev\",\"email\":\"nicat.aliyev@example.com\",\"age\":20}"
```

Create a course without prerequisite:

```bash
curl -X POST http://localhost:8081/api/v1/courses ^
  -H "Content-Type: application/json" ^
  -d "{\"title\":\"Programming I\",\"code\":\"CS101\",\"credits\":6,\"prerequisiteCourseId\":null}"
```

Create a course with prerequisite:

```bash
curl -X POST http://localhost:8081/api/v1/courses ^
  -H "Content-Type: application/json" ^
  -d "{\"title\":\"Data Structures\",\"code\":\"CS201\",\"credits\":6,\"prerequisiteCourseId\":1}"
```

Enroll a student into a course:

```bash
curl -X POST http://localhost:8081/api/v1/courses/1/students/1
```

The enrollment response includes `enrollmentDate`.

Get students enrolled in a course:

```bash
curl http://localhost:8081/api/v1/courses/1/students
```

Search students by name:

```bash
curl "http://localhost:9090/api/v1/students/search?name=Nicat"
```

Get courses by student name:

```bash
curl "http://localhost:8081/api/v1/courses/by-student?name=Nicat"
```

## Lab8 Features

- Enrollment date is stored on each enrollment and returned in enrollment/course lookup responses.
- Courses can have an optional `prerequisiteCourseId`; use `null` when there is no prerequisite.
- Enrollment is rejected if the student has not completed the prerequisite course.
- Course lookup by student name is available through `GET /api/v1/courses/by-student?name=...`.
- Swagger/OpenAPI descriptions are written in Azerbaijani for endpoints and DTO fields.

## Notes

- `course-service` validates student existence by calling `student-service`.
- If `student-service` is unavailable, course enrollment and student-name course lookup return meaningful gateway errors.
- Hibernate uses `ddl-auto=update`, so database tables are created/updated automatically during development.
