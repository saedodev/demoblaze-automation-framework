# 🚀 Demoblaze Automation Framework

An end-to-end automation testing framework built with **Java**, **Selenium WebDriver**, **Rest Assured**, **Cucumber (BDD)**, **JUnit 5**, and **Maven**.

This project automates both **Web UI Testing** and **API Testing** while following industry best practices such as **Page Object Model (POM)**, reusable utilities, shared test data, and Continuous Integration using **GitHub Actions**.

---

# 📖 Table of Contents

- Project Overview
- Technology Stack
- Framework Architecture
- Project Structure
- Web Automation
- API Automation
- Test Execution
- Git Workflow
- GitHub Actions
- Future Improvements
- Author

---

# 📌 Project Overview

This automation framework consists of two major modules.

## 🌐 Web Automation

Automates the user journey on the Demoblaze website.

### Covered Features

- User Registration
- User Login
- Product Detail
- Add Product to Cart
- Remove Product from Cart
- Checkout
- Purchase Confirmation

---

## 🔗 API Automation

Automates REST API testing using Rest Assured.

### Covered Features

- GET Request
- POST Request
- PUT Request
- DELETE Request
- Status Code Validation
- Response Body Validation
- Header Validation
- Response Time Validation

---

# 🛠 Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Build Tool | Maven |
| Web Automation | Selenium WebDriver |
| API Automation | Rest Assured |
| BDD | Cucumber |
| Testing | JUnit 5 |
| Driver Management | WebDriverManager |
| CI/CD | GitHub Actions |
| Version Control | Git |

---

# 🏗 Framework Architecture

## Web Automation

```text
Feature File
      │
      ▼
Step Definition
      │
      ▼
Page Object
      │
      ▼
Wait Utility
      │
      ▼
WebDriver
      │
      ▼
Browser
```

---

## API Automation

```text
Feature File
      │
      ▼
Step Definition
      │
      ▼
API Request
      │
      ▼
Rest Assured
      │
      ▼
API Endpoint
      │
      ▼
Response Validation
```

---

## Overall Framework

```text
                     Automation Framework
                             │
          ┌──────────────────┴──────────────────┐
          │                                     │
          ▼                                     ▼
   🌐 Web Automation                    🔗 API Automation
          │                                     │
     Selenium WebDriver                  Rest Assured
          │                                     │
     Page Object Model                  Request Builder
          │                                     │
     Cucumber Feature                   Cucumber Feature
          └──────────────────┬──────────────────┘
                             ▼
                     GitHub Actions CI
```


---

# 🌐 Web Automation

## Sign Up

- Register New User
- Existing Username
- Blank Username
- Blank Password
- Blank Username & Password

---

## Login

- Valid Login
- Wrong Password
- User Does Not Exist
- Blank Username
- Blank Password
- Blank Username & Password

---

## Product

- View Product Detail
- Add Product to Cart
- Add Multiple Products

---

## Cart

- Verify Products
- Delete Products

---

## Checkout

- Successful Purchase
- Blank Name
- Blank Credit Card
- Purchase Validation

---

# 🔗 API Automation

## GET

- Get All Data
- Get Single Data

---

## POST

- Create Resource

---

## PUT

- Update Resource

---

## DELETE

- Delete Resource

---

## Response Validation

- Status Code
- Response Body
- Headers
- Response Time

---

# ▶ Running Test

Run all tests

```bash
./gradlew clean test
```

Run only Web Automation

```bash
./gradlew webTest
```

Run only API Automation

```bash
./gradlew apiTest
```

---

# 🔄 Git Workflow

This project follows a simple Git Flow.

```text
main
 │
 └── dev
      │
      ├── feature/signup
      ├── feature/login
      ├── feature/product
      ├── feature/cart
      ├── feature/checkout
      └── feature/api
```

Development Process

```text
Create Feature Branch
        │
        ▼
Develop Feature
        │
        ▼
Commit Changes
        │
        ▼
Push Feature Branch
        │
        ▼
Pull Request
        │
        ▼
Code Review
        │
        ▼
Merge to dev
        │
        ▼
Regression Testing
        │
        ▼
Merge dev → main
```

---

# ⚙ GitHub Actions

Every push and pull request automatically triggers the CI pipeline.

```text
Push / Pull Request
          │
          ▼
Checkout Repository
          │
          ▼
Setup JDK 21
          │
          ▼
Install Maven Dependencies
          │
          ▼
Run Web Automation
          │
          ▼
Run API Automation
          │
          ▼
Generate Test Report
          │
          ▼
Upload Build Artifacts
```

Workflow File

```
.github/workflows/automation.yml
```

---

[//]: # (# 🚀 Future Improvements)

[//]: # ()
[//]: # (- Allure Report)

[//]: # (- Extent Report)

[//]: # (- Screenshot on Failure)

[//]: # (- Parallel Execution)

[//]: # (- Cross Browser Testing)

[//]: # (- Docker Integration)

[//]: # (- Jenkins Pipeline)

[//]: # (- API JSON Schema Validation)

[//]: # (- Retry Mechanism)

[//]: # (- Database Validation)

---

# 👨‍💻 Author

**saedodev**

QA Automation Engineer Portfolio

GitHub Repository

https://github.com/saedodev/demoblaze-automation-framework

GitHub Profile

https://github.com/saedodev

---