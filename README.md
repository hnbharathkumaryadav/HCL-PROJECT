# HCL-PROJECT

🧠 Employee Retention Predictor (Java + MongoDB)

📘 Project Overview
The Employee Retention Predictor is a Java-based data analysis application that predicts whether an employee is likely to stay or leave a company based on input parameters. The application integrates with MongoDB for storing employee records and uses analytical logic to calculate retention outcomes. It demonstrates full data processing and Java–MongoDB connectivity using the official MongoDB driver.

This project was developed as part of the GUVI Technical Upskilling Program and serves as a real-world demonstration of employee analytics and database-driven prediction systems.

🎯 Aim
To design and develop a prediction system that analyzes employee-related data (such as salary, department, work experience, etc.) and determines employee retention likelihood using Java logic and MongoDB storage.

⚙️ Features
Feature	Description
Java–MongoDB Integration	Uses official driver for DB operations
Employee Data Entry	Insert employee records into MongoDB
Retention Prediction	Logic to determine if employee is likely to stay/leave
Record Storage	All employee entries saved in MongoDB
View Records	Retrieve stored data from DB
Input Validation	Ensures consistent and correct data
Modularity & Comments	Structured, readable Java code

📂 Project Structure
employeeretentionpredictor/
├── .dist/
├── libs/
│   ├── bson-4.10.2.jar
│   ├── mongodb-driver-core-4.10.2.jar
│   └── mongodb-driver-sync-4.10.2.jar
├── employeeretentionpredictor.java
├── employeeretentionpredictor.class

🖥️ System Requirements
Software Requirements

Operating System: Windows / macOS / Linux

Java Development Kit: JDK 8 or higher (Recommended: JDK 11/17)

Database: MongoDB 4.4+ (Recommended: MongoDB 6.0)

IDE: VS Code, IntelliJ IDEA, Eclipse, or NetBeans

JAR Dependencies (included in /libs):

mongodb-driver-sync-4.10.2.jar

mongodb-driver-core-4.10.2.jar

bson-4.10.2.jar

Hardware Requirements

Processor: Dual Core or above

RAM: Minimum 4GB (Recommended: 8GB)

Storage: 2GB free

Network: Localhost access required

🧰 Installation & Setup (Windows/macOS/Linux)
Step 1: Install Java

Check installation:

java -version
javac -version


Expected Output Example:

java version "11.0.15"
Java HotSpot(TM) 64-Bit Server VM

Step 2: Install MongoDB
Windows

Install from MongoDB official site and run MongoDB Community Server.

macOS
brew tap mongodb/brew
brew install mongodb-community

🧾 Running MongoDB
Start MongoDB Server

Open Terminal / Command Prompt:

mongod


Once running successfully, it will show:

Waiting for connections on port 27017

Connect to Mongo Shell

Open another terminal and run:

mongosh


If successful, you'll see:

test>

🛠 Compile & Execute Project
Navigate to project directory
cd employeeretentionpredictor

Compile Source Code
javac -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor.java

Run the Program
java -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor

🧮 Functional Modules
Module	Description
Insert Employee	Add employee details and compute retention
Predict Retention	Logic to evaluate stay vs leave likelihood
Store Records	Save computed records in MongoDB
View Saved Records	Retrieve stored data from DB
Validation	Error handling for incorrect inputs

🧾 Example Output
Connected to MongoDB at mongodb://localhost:27017, Database: employeeDB
Choose: 1=create 2=read 3=update 4=delete 5=list 6=predict 7=exit 
1
Name: john 
Age: 21
Years at company: 4 
Satisfaction (0.0 - 1.0): 0.6 
Performance rating (1-5): 4 
Inserted with id: 68ebeb40e67f28333a1a047f

🧪 Testing

Method: Manual and Integration testing

Test Cases: Prediction logic, input validation, data storage, retrieval

Status: All modules tested successfully

🧩 Conclusion

The Employee Retention Predictor successfully demonstrates:

✔ Java + MongoDB system integration
✔ Analytical prediction logic
✔ Proper data validation and storage
✔ Real-world HR analytics use-case


🔗 GitHub Repository

(Replace with your actual repo link)

https://github.com/hnbharathkumaryadav/HCL-PROJECT

👨‍💻 Author

Name: H N BHARATH KUMAR
Regd. No.: 22781A0545
Department: Computer Science and Engineering
Institution: Sri Venkateswara College of Engineering and Technology

Under the Guidance of: P. Ragavan
