# selenium-web-testing

Professional Selenium Web UI automation project using **Java + Maven + TestNG + Selenium 4 + WebDriverManager** and the **Page Object Model (POM)** pattern.

## Tech stack

- Java 17
- Maven (Surefire)
- Selenium 4
- TestNG
- WebDriverManager (no manual ChromeDriver setup)

## Project structure

```
selenium-web-testing
├── pom.xml
├── src
│   └── test
│       ├── java
│       │   ├── com/example/framework
│       │   │   ├── config/Config.java
│       │   │   ├── driver/DriverFactory.java
│       │   │   ├── pages/BasePage.java
│       │   │   └── tests/BaseTest.java
│       │   └── com/example/tests
│       │       ├── FormValidationTest.java
│       │       ├── GoogleSearchTest.java
│       │       ├── LoginTest.java
│       │       └── pages
│       │           ├── FormValidationPage.java
│       │           ├── GoogleHomePage.java
│       │           ├── GoogleResultsPage.java
│       │           ├── HerokuLoginPage.java
│       │           └── SecureAreaPage.java
│       └── resources
│           └── testng.xml
└── .gitignore
```

## Test cases included

- **Google Search test**: searches for “Selenium WebDriver” and verifies results appear.
- **Login page test (demo site)**: logs in to `the-internet.herokuapp.com/login` with known demo credentials.
- **Form validation test**: submits a demo form on `practice.expandtesting.com/form-validation` and verifies a success message.

## Prerequisites

- Java 17+
- Maven 3.9+
- Google Chrome installed

## How to run

Run all tests:

```bash
mvn test
```

If you're running in a restricted environment where Maven cannot write to `~/.m2`, use a project-local Maven repo:

```bash
mvn -Dmaven.repo.local=.m2 test
```

Run headless:

```bash
mvn test -Dheadless=true
```

Override timeout (seconds):

```bash
mvn test -DtimeoutSeconds=15
```

Run a single test class:

```bash
mvn -Dtest=GoogleSearchTest test
```

Run using the TestNG suite explicitly:

```bash
mvn -DsuiteXmlFile=src/test/resources/testng.xml test
```

## Notes

- WebDriver is created in `BaseTest` and closed in `@AfterMethod` to ensure isolation between tests.
- The project uses explicit waits via `BasePage` (implicit wait is set to 0 to avoid mixing strategies).

