# FraudDetectHospitalReceptionist

A desktop-based fraud detection and claims management system designed for hospital reception environments. The application streamlines insurance claim processing while helping administrators identify suspicious claim activities through automated fraud analysis and reporting.

## Key Highlights

* Secure user authentication
* Insurance claim registration and management
* Automated fraud detection engine
* Interactive fraud monitoring dashboard
* PDF report generation
* MySQL-backed data persistence
* Layered enterprise architecture using Java and JDBC

---

## Problem Statement

Healthcare insurance systems frequently face challenges such as duplicate claims, unusually high claim amounts, and suspicious claim patterns. Manual verification is time-consuming and prone to oversight.

FraudDetectHospitalReceptionist addresses this problem by providing a centralized platform where hospital staff can manage claims efficiently while automatically flagging potentially fraudulent activities for further review.

---

## Solution

The application combines claim management and fraud analysis into a single workflow.

Claims submitted through the reception dashboard are stored in a MySQL database. The fraud analysis module evaluates claim records against predefined business rules and highlights suspicious entries through a dedicated monitoring dashboard.

This helps hospital administrators improve operational efficiency and reduce the risk of insurance fraud.

---

## Core Features

### Authentication System

* Secure login interface
* User validation through database authentication
* Controlled system access

### Claim Management

* Create and manage insurance claims
* Store claim information in MySQL
* Retrieve and update claim records

### Fraud Analysis

* Rule-based fraud detection
* Detection of suspicious claim behavior
* Fraud monitoring dashboard

### Reporting

* PDF report generation using iText
* Claim summaries and fraud reports
* Audit-friendly documentation

### User Interface

* Java Swing desktop application
* Dedicated dashboards for claim processing and fraud monitoring
* Simple workflow designed for reception staff

---

## Technology Stack

| Layer        | Technology          |
| ------------ | ------------------- |
| Frontend     | Java Swing          |
| Backend      | Java                |
| Database     | MySQL               |
| Connectivity | JDBC                |
| Reporting    | iText PDF           |
| Architecture | DAO + Service Layer |

---

## System Architecture

```text
User Interface (Swing)
          │
          ▼
 Business Logic Layer
   (FraudAnalyzer)
          │
          ▼
      DAO Layer
 (ClaimDAO, UserDAO)
          │
          ▼
   JDBC Connection
          │
          ▼
       MySQL
```

---

## Project Structure

```text
src/main/java/com/hospital
│
├── dao
│   ├── ClaimDAO.java
│   └── UserDAO.java
│
├── gui
│   ├── SplashScreen.java
│   ├── LoginScreen.java
│   ├── ClaimEntryDashboard.java
│   └── FraudDashboard.java
│
├── model
│   └── Claim.java
│
├── service
│   └── FraudAnalyzer.java
│
└── util
    └── DBConnection.java
```

---

## Application Workflow

1. User logs into the system.
2. Claims are entered through the Claim Entry Dashboard.
3. Claim records are stored in MySQL.
4. FraudAnalyzer evaluates submitted claims.
5. Suspicious claims are flagged automatically.
6. Results are displayed in the Fraud Dashboard.
7. Reports can be exported as PDF documents.

---

## Libraries Used

* MySQL Connector/J
* iText PDF 5.5.13

---

## Future Improvements

* Machine Learning based fraud prediction
* Role-based authorization
* Real-time notifications
* REST API integration
* Cloud deployment
* Analytics and visualization dashboard

---
