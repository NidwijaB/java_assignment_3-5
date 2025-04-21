# Java Assignment 3 and Assignment 5

Assignment Task 3: JDBC + POJO
	This is a Maven-based Java project using **SQLite**, **Selenium**, and **Apache Commons CSV** to manage and analyze employee salary data.
Assignment Task 5: Critical Thinking
	Write your thoughts over the role and future of QA in AI dominant tech market. 
	located:: java_assignments_remaining/assignment5_critical_thinking

---

## Features

- Creates and manages an SQLite database (`salary.db`)
- Inserts random employee records
- Performs salary-based operations and exports results to CSV
- Uses POJO for structured data handling
- Assignment 3 info::
	- Create SQLite Database and Table:
	- Connect to SQLite database.
	- Create Salary table with columns: employee_name, join_date, salary.
	- Insert Random Data:
	- Insert 100 random records into the Salary table.
	- POJO Class:
		-Create a Salary POJO class with fields: employeeName, joinDate, salary.
	- Operations:
		Print employee with the highest salary.
		Export employees with salary greater than 10000 to CSV.
		Export employees who joined in the last month to CSV.
		Print employees in ascending order by name.

---

## Requirements

Make sure the following tools are installed:

- **Java 17**
- **Maven 3.6.3 or newer**
- **IntelliJ IDEA IDE** 

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

