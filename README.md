# 🏦 Bank Transaction Management System
 
A reliable Core Java application that simulates a real-world banking system, securely connected to a **MySQL** database using **JDBC**.
 
The primary focus of this project is to handle financial transactions safely, ensuring data accuracy and security during money transfers.
 
---
 
## ✨ Features
 
* **Account Management:** Supports creating accounts, checking balances, and viewing customer details.
* **Safe Funds Transfer:** Moves money between accounts seamlessly with strict balance verification.
* **Transaction Safety (ACID):** Uses explicit `commit()` and `rollback()` mechanisms. If a transfer fails midway (e.g., network issue), the system automatically rolls back to prevent any money loss.
* **SQL Injection Security:** Implemented `PreparedStatement` instead of regular statements to protect user data from unauthorized database attacks.
 
---
 
## 🛠️ Tech Stack
 
* **Programming Language:** Java (Core Java)
* **Database:** MySQL
* **Database API:** JDBC (Java Database Connectivity)
 
---
 
## 💻 How to Run This Project
 
1. **Clone the repository:**
```bash
git clone [https://github.com/TMadhvi/TransactionJDBC.git](https://github.com/TMadhvi/TransactionJDBC.git)
 

2.) 📂 Open MySQL Workbench / Command Line.
 Create a database and set up your accounts and transactions tables.

3.) Configure Connection:
 Update the database URL, username, and password in your Java connection file.

 4.) Run the App:
 Open the project in Eclipse or IntelliJ IDEA and execute the main Java file.


 💡  What I Learned From This Project
 
*  How to establish a secure bridge between Java and MySQL using JDBC drivers.
*  Handling SQL exceptions gracefully without crashing the application.
* Implementing ACID properties practically to ensure that financial data remains 100% accurate and consistent.
