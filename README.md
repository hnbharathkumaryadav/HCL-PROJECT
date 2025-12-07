# HCL-PROJECT
EMPLOYEE RETENTION PREDICTOR

Employee retention is one of the most critical challenges faced by organizations today. High employee turnover leads to increased recruitment costs and loss of productivity. The Employee Retention Predictor system is designed to help organizations analyze employee data and predict the likelihood of employees staying or leaving the company.

structure:
employeeretentionpredictor/
│   employeeretentionpredictor.java
│
└── libs/
    ├── bson-4.10.2.jar
    ├── mongodb-driver-core-4.10.2.jar
    └── mongodb-driver-sync-4.10.2.jar

for compiling:
javac -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor.java

to run the code:
java -cp "libs\mongodb-driver-sync-4.10.2.jar;libs\mongodb-driver-core-4.10.2.jar;libs\bson-4.10.2.jar;." employeeretentionpredictor
