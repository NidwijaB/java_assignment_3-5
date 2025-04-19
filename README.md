# Java Assignment 3

This is a Maven-based Java project using **SQLite**, **Selenium**, and **Apache Commons CSV** to manage and analyze employee salary data.

---

## Features

- Creates and manages an SQLite database (`salary.db`)
- Inserts random employee records
- Performs salary-based operations and exports results to CSV
- Uses POJO for structured data handling

---

## Requirements

Make sure the following tools are installed:

- **Java 17**
- **Maven 3.6.3 or newer**
- **Any IDE** (IntelliJ IDEA recommended)

---

## How to Run

1. Open the project in IntelliJ IDEA
2. Ensure Maven dependencies are downloaded
3. Run `Main.java`

---

## Dependencies

The project uses the following dependencies. These are defined in the `pom.xml` file:

- **SQLite JDBC Driver**: For connecting and querying SQLite database
- **Selenium**: For any potential browser interaction
- **Apache Commons CSV**: For exporting data to CSV format
- **Maven Compiler Plugin**: Set for Java 17 compatibility

---

## Technologies Used

- Java  
- SQLite  
- Selenium  
- Apache Commons CSV  
- Maven

---

## Project Structure

```
Java_Assignment3/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── org/
        │       └── example/
        │           ├── Main.java
        │           ├── database/
        │           │   └── DBManager.java
        │           ├── model/
        │           │   └── Salary.java
        │           └── util/
        │               └── CSVExporter.java
        └── resources/
            └── salary.db
```

---

## Output

- **salary.db**: SQLite database created under `src/main/resources/`
- **high_earners.csv**: List of employees with salary > 10000
- **recent_joinees.csv**: Employees who joined in the last month

---

## License

This project is for educational purposes.
