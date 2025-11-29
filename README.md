# Marriage Compatibility Calculator (Ashtakoot)

A Java-based application for calculating marriage compatibility using the Vedic Astrology **Ashtakoot** system. This application provides a REST API to evaluate the compatibility between a bride and groom based on their birth details.

## Features

- **Ashtakoot Matching**: Calculates scores for all 8 Kootas:
  - Varna
  - Vaisya
  - Tara
  - Yoni
  - Maitri
  - Gana
  - Bahkut
  - Nadi
- **Swiss Ephemeris Integration**: Uses the high-precision Swiss Ephemeris library for accurate planetary position calculations.
- **REST API**: Exposes an endpoint to easily integrate with other applications.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven** 3.6 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Marriage-Compatibility-Asthakoot.git
   cd Marriage-Compatibility-Asthakoot
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

### Docker

1. Build the Docker image:
   ```bash
   docker build -t marriage-compatibility .
   ```

2. Run the container:
   ```bash
   docker run -p 8080:8080 marriage-compatibility
   ```

## Usage

### Running the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### API Documentation

#### Calculate Compatibility

**Endpoint**: `POST /api/compatibility/calculate`

**Request Body**:

```json
{
    "boy": {
        "name": "Boy Name",
        "birthDate": "1990-01-01",
        "birthTime": "10:00",
        "latitude": "17.3850",
        "longitude": "78.4867"
    },
    "girl": {
        "name": "Girl Name",
        "birthDate": "1992-02-02",
        "birthTime": "11:00",
        "latitude": "17.3850",
        "longitude": "78.4867"
    }
}
```

**Response**:

```json
{
    "boy": {
        "name": "Boy Name",
        "nakshatra": "Ashwini",
        "raasi": "Aries"
    },
    "girl": {
        "name": "Girl Name",
        "nakshatra": "Bharani",
        "raasi": "Aries"
    },
    "varna": { "max": 1.0, "obtained": 1.0 },
    "vaisya": { "max": 2.0, "obtained": 2.0 },
    "tara": { "max": 3.0, "obtained": 1.5 },
    "yoni": { "max": 4.0, "obtained": 2.0 },
    "maitri": { "max": 5.0, "obtained": 5.0 },
    "gana": { "max": 6.0, "obtained": 0.0 },
    "bahkut": { "max": 7.0, "obtained": 7.0 },
    "nadi": { "max": 8.0, "obtained": 8.0 },
    "totalScore": 26.5
}
```

## Testing

Run the unit and integration tests using Maven:

```bash
mvn test
```

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Swiss Ephemeris** (via local repository)
- **Maven**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
