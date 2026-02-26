# LearnSphere CLI

LearnSphere CLI is a Java-based command-line application that connects to the LearnSphere REST API and answers four key business questions about the online learning platform.

This application was built for **Sprint Week – Winter 2026** and demonstrates:

- HTTP communication from a Java client
- Clean separation of concerns
- JSON parsing with Jackson
- Unit testing with JUnit 5
- Mocking with Mockito
- GitHub Actions CI integration

---

## Project Purpose

The CLI consumes report endpoints from the LearnSphere API and presents the results in a clean, readable console format.

The CLI answers the following 4 required questions:

1. What courses are in each category?
2. What courses has each student enrolled in?
3. What instructor teaches each course?
4. What instructors has each student learned from?

---

## 🏗️ Project Structure

```
learnsphere-cli
│
|── http/
│   └── ApiClient.java
|
|-- config/
│   └── AppConfig.java
|
├── service/
│   └── ReportService.java
│
├── ui/
│   └── ConsoleRenderer.java
│
├── model/
│   ├── CoursesByCategory.java
│   ├── CoursesByStudent.java
│   ├── InstructorByCourse.java
│   ├── InstructorsByStudent.java
│   ├── SimpleCourse.java
│   └── SimpleInstructor.java
│
├── Main.java
│
└── test/
    ├── service
    |       |__ReportServiceTest.java
    |
    |── ui
         |__ConsoleRendererTest.java
    
```

---

## API Integration

The CLI communicates with the LearnSphere API via HTTP GET requests.

Base URL:
```
http://localhost:8080/api/v1/reports
```

Endpoints consumed:

```
GET /courses-by-category
GET /courses-by-student
GET /instructor-by-course
GET /instructors-by-student
```

---

## Architecture Overview

### AppConfig
Responsible for:
- Storing configuration values (e.g., base URL)
- Providing access to configuration throughout the app

### ApiClient
Responsible for:
- Making HTTP GET requests
- Returning raw JSON

### ReportService
Responsible for:
- Calling report endpoints
- Parsing JSON using Jackson
- Returning strongly-typed model objects

### ConsoleRenderer
Responsible for:
- Formatting output
- Printing readable console reports
- Handling null and empty cases gracefully

### Main
Responsible for:
- Displaying menu
- Handling user input
- Routing to correct report method

---

## Example CLI Menu

```
=== LearnSphere Reports ===

1. Courses by Category
2. Courses by Student
3. Instructors by Course
4. Instructors by Student
0. Exit

Select an option:
```

---

## Example Output

### Courses By Category
```
=== Courses By Category ===

==>> Computer Science (2 courses)
  - CS102 | Data Structures
  - CS201 | Algorithms
```

### Instructors By Student
```
=== Instructors By Student ===

==>> Temi Oyedele (2 instructors)
  - Jamie Kells | jamie.kells@keyin.ca
  - Sarah Ng | sarah.ng@keyin.ca
```

---

## Testing Strategy

### Unit Tests Included

- ReportServiceTest
    - Mocks ApiClient
    - Verifies correct endpoints are called
    - Verifies JSON parsing
    - Handles invalid JSON

- ConsoleRendererTest
    - Captures System.out
    - Verifies formatted output
    - Tests null and empty cases
    - Tests placeholder behavior ("-")

### Tools Used
- JUnit 5
- Mockito
- Jackson

---

## Technologies Used

- Java 25
- Maven
- JUnit 5
- Mockito
- Jackson Databind
- GitHub Actions (CI)

---

## How to Run

### 1. Start Backend API
Make sure LearnSphere API is running:
```
http://localhost:8080
```

### 2. Run CLI

Using Maven:
```
mvn clean install
mvn exec:java -Dexec.mainClass="org.codewithmagret.Main"
```

Or run `Main.java` directly in IntelliJ.

---

## Run Tests

```
mvn test
```

GitHub Actions automatically runs tests on:
- Pull Requests
- Merges to main

---

## Dependencies

Key dependencies:

```
JUnit 5
Mockito
Jackson Databind
```

---

## Sprint Requirements Covered

- Separate CLI repository
- Connects to API via HTTP
- Answers all 4 required questions
- Strong unit test coverage
- Mocking implemented
- GitHub Actions CI
- Clear separation of responsibilities

---

## API Documentation

Full Javadoc documentation can be found here:

[View Javadoc Documentation](https://magret1730.github.io/learnsphere/)

---

## Author

Abiodun Magret Oyedele  
Software Development – Keyin College  
Sprint Week – Winter 2026

---