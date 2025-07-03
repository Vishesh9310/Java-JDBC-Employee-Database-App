# Java-JDBC-Employee-Database-App (Java + JDBC + MySQL)

A **console-based Employee Management System** using **Java** and **JDBC** for interacting with a **MySQL** database. This mini-project supports all basic CRUD operations with a simple text-based menu.

---

## 📌 Features

- ✅ Add new employees
- 📄 View all employee records
- ✏️ Update employee salary
- ❌ Delete employee entries
- 🧾 Menu-driven interface via console

---

## 🛠️ Tech Stack

- **Java** (JDK 8 or higher)
- **MySQL** (Database server)
- **JDBC API** (MySQL Connector/J)

---

## 🏗️ Database Setup

### 🔸 Step 1: Create Database & Table

Run the following SQL in MySQL Workbench or CMD:

```sql
CREATE DATABASE employeedb;

USE employeedb;

CREATE TABLE employee (
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  phone VARCHAR(15),
  department VARCHAR(50),
  salary DOUBLE
);
````

---

## 🧑‍💻 Run Instructions

### 🔸 Step 2: Update Credentials

In `Main.java`, update the following constants:

```java
private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
private static final String USERNAME = "username";          // Your MySQL username
private static final String PASSWORD = "password";      // Your MySQL password
```

### 🔸 Step 3: Compile and Run

Using terminal/command prompt:

```bash
javac Main.java Employee.java
java Main
```

> ⚠️ Ensure `mysql-connector-java-X.X.X.jar` is included in your classpath.

---

## 📂 Project Structure

```
📁 EmployeeManagementSystem
│
├── Main.java             # Main application logic & menu
├── Employee.java         # POJO class for Employee entity
├── README.md             # This file
```


## 🔐 Security Note

Never hardcode real credentials in production code. Use environment variables or configuration files for security.

---

## 🎓 Learning Goals

* Understanding Java-MySQL integration using JDBC
* Using `PreparedStatement` for safe SQL execution
* Implementing a complete CRUD system in Java

---

## 🤝 Contributing

Pull requests are welcome! Open issues to report bugs or suggest features.

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 🙌 Author

Built with 💻 by **\Vishesh**
🌐 GitHub: [@Vishesh9310](https://github.com/Vishesh9310)