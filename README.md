
# Employee Retention Predictor

## 📌 Project Overview
The Employee Retention Predictor is a Java-based data analysis application that predicts whether an employee is likely to stay or leave a company based on input parameters. The application integrates with MongoDB for storing employee records and uses analytical logic to calculate retention outcomes. It demonstrates full data processing and Java–MongoDB connectivity using the official MongoDB driver.

This project was developed as part of the GUVI Technical Upskilling Program and serves as a real-world demonstration of employee analytics and database-driven prediction systems.

---

## 📁 Project Structure

```
B:/employeeretentionpredictor/
│── employeeretentionpredictor.java      # Main source file
│── employeeretentionpredictor.class     # Compiled class file
│── libs/                                # Required JAR 
│     ├── bson-4.10.2.jar
│     ├── mongodb-driver-core-4.10.2.jar
│     └── mongodb-driver-sync-4.10.2.jar
│── .dist/                               # Distribution folder (if packaging)
```

---

## 🛠 Requirements

- Java 17 or above
- MongoDB Server (Local or Remote)

---

## ⚙️ How to Compile the Project

```sh
javac -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor.java
```

---

## ▶️ How to Run the Project

```sh
java -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor
```

> **Note (Windows):** Use `;` as separator in classpath.  
> **Note (Linux/Mac):** Use `:` instead.

---

## 📊 Visualizations & Summary Statistics

Learners must:
- Generate visual charts for retention outcomes
- Provide dataset-level descriptive statistics
- Ensure consistency and completeness in reporting

These can be done using:
- Python (Matplotlib, Seaborn, Pandas)
- PowerBI, Tableau, or Excel Charts

---

## 🧾 Submission Guidelines

✔ Upload complete source code to a **public GitHub repository**  
✔ Include a detailed README (this file)  
✔ Ensure clear folder structure and instructions  
✔ Provide visual outputs and statistical summaries separately  
✔ Maintain data consistency and integrity

---

## 🏁 Final Submission Checklist

- [ ] GitHub repo is public
- [ ] README.md is present and complete
- [ ] Code is commented and modular
- [ ] MongoDB connection is functioning
- [ ] Visualizations are attached separately
- [ ] Submission form link is filled before deadline

---

## 👨‍💻 Author / Team

- H N BHARATH KUMAR
- 22781A0545
- COMPUTER SCIENCE AND ENGINEERING
- SRI VENKATESWARA COLLEGE OF ENGINEERING AND TECHNOLOGY
