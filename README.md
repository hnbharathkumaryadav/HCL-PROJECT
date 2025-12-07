# HCL-PROJECT
EMPLOYEE RETENTION PREDICTOR


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
