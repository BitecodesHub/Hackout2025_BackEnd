# Spring Boot Project (Java 21)

This is a Spring Boot project configured to run with **Java 21** and **Maven**.

## Prerequisites

- **Java 21** installed and configured (check with `java -version`)
- **Maven 3.9+** installed (check with `mvn -version`)
- **PostgreSQL/MySQL** (if using a database)

## Project Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the project**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - By default, the application runs on: `http://localhost:8080`

## Folder Structure

- **src/main/java**: Java source code
- **src/main/resources**: Configuration files
- **pom.xml**: Maven configuration

## Notes

- Update `application.properties` or `application.yml` to configure your database or external services.
- Use profiles like `dev`, `test`, and `prod` for better environment management.

## License

This project is licensed under the DAU Scholars.
