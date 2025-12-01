# 📚 Java + MySQL Integration (Bootcamp Project)

This repository contains a simple academic exercise developed during the **Talentotech2 programming bootcamp**. Several parts of the code and the database structure were created collaboratively, with guidance from professor **César Henao** and valuable input from my **classmates**.
The goal was to integrate **Java** with a **MySQL** database using **JDBC**, using **Aiven** as a remote MySQL server to apply basic **CRUD** operations and understand how backend applications communicate with relational databases.

The project uses a small library-style schema (books, patrons, employees, and checkouts) to practice queries and database interaction.

---

## 🚀 What Was Done

* A MySQL database was created with several tables used in the bootcamp exercises.
* A Java project was built using Maven and structured into layers (connection, models, DAO, main).
* JDBC was used to connect to the remote MySQL instance (Aiven in my case).
* CRUD operations were implemented to read and manipulate data.
* The project was tested inside IntelliJ to confirm the connection and functionality.

---

## 📁 Project Structure

```
src/
 ├── connection   → JDBC connection class  
 ├── models       → Java objects representing database tables  
 ├── dao          → CRUD operations using JDBC  
 └── main         → Test execution  
```

---

## 🔑 How to Run This Project Locally

Because this is an academic repository, **real database credentials are not included**.
To run this project on your machine, follow these steps:

1. Install MySQL locally OR create your own MySQL instance in the cloud.
2. Create a database with any name you prefer.
3. Import your own tables or reuse the structure from `biblioteca_db.sql` (provided in the project).
4. Open the file:

```
src/.../ConexionBD.java
```

5. Replace these placeholders with your own values:

```java
private static final String DB_URL  = "jdbc:mysql://HOST:PORT/YOUR_DATABASE";
private static final String DB_USER = "YOUR_USERNAME";
private static final String DB_PASS = "YOUR_PASSWORD";
```

6. Make sure the MySQL JDBC driver is active in your IntelliJ module
   (External Libraries → mysql-connector-j).
7. Run the main class to test the connection.

This allows any student to run the project without exposing private credentials publicly.

---

## 🎓 Bootcamp Context

This project was created as part of a backend learning module where we practiced:

* Basic Java development
* Connecting Java applications to databases
* Understanding SQL tables and relationships
* Applying CRUD operations with JDBC
* Managing database drivers in an IDE

It is a foundational academic exercise meant to demonstrate integration between Java and MySQL.

---

## 💻 For Recruiters

This repository shows:

* Ability to work with Java + SQL
* Understanding of project structure and separation of concerns
* Proper handling of credentials and repository hygiene
* Clear documentation for academic and practical purposes

---

## 📝 Optional Evidence for Students

You can add screenshots of:

* Successful connection
* SQL query output
* Table structure in MySQL
* CRUD operations running in IntelliJ

---
