# Geo Shapes API

## Project Overview

Geo Shapes API is a RESTful application built with Java 21 and Spring Boot. It allows users to add and retrieve geometric shapes such as squares, rectangles, and circles.

Supported shape types:
- Square
- Rectangle
- Circle

Each shape is stored with parameters and can be retrieved based on its type.

## Tech/framework used

- Java 21  
- Spring Boot  
- Spring Web
- Spring Data JPA 
- Spring Validation
- Database PostgreSQL
- JUnit 5  
- Mockito   
- Maven  

## Installation and Running

1. Clone the repository:

```bash
git clone https://github.com/krzysztofKolodziej/geo-shapes.git
cd geo-shapes
```

2. Build the project:

```bash
mvn clean install
```

3. Run the application:

```bash
mvn spring-boot:run
```

By default, the application will start on port `8080`.

## API Endpoints

### POST /api/v1/shapes

Add a new geometric shape.

**Request body example:**
```json
{
  "type": "rectangle",
  "parameters": {
    "a": 5,
    "b": 10
  }
}
```

**Response:**
- `201 Created` – if the shape was successfully added
- `400 Bad Request` – if the input is invalid

---

### GET /api/v1/shapes?type={type}

Retrieves a list of shapes of the given type.

**Example:**
```bash
curl http://localhost:8080/api/v1/shapes?type=rectangle
```

**Response:**
```json
[
  {
    "type": "RECTANGLE",
    "parameters": {
      "a": 5,
      "b": 10
    }
  }
]
```

---

## Error Handling

For unsupported shape types or invalid input, an error message is returned:

```json
{
  "message": "Unsupported shape type"
}
```

## Testing

Run tests:

```bash
mvn test
```

The project includes:
- Unit tests for services and handlers
- Integration tests for the controller using `MockMvc`

---

