# ABSA QA Automation Assessment

# README #

This README would normally document whatever steps are necessary to get your application up and running.

## Set up

clone the repository into Intellij IDEA using version control from the below link:
https://github.com/TechieVats/QAAutomationAssessment.git

## What is this repository for? ###

ABSA QA AUTOMATION ASSESSMENT

## Task 1 - API:

1. API Test scenarios has been mentioned in the feature file named dog_api.feature
2. path for feature file : src/test/resources/apifeatures/dog_api.feature

## Task 2: Web Table UI Automation

1. Test scenarios has been mentioned in the feature file named webtables_ui.feature
2. path for feature file : src/test/resources/uifeatures/webtables_ui.feature   
   for feature file : src/test/resources/features/WeatherMap.feature
3. Browser independent- It can work on any browser- currently working functionality has been coded for Chrome and Firefox, it can be enhanced.
   How to change browser? - Go to Environment.properties files -> Browser=chrome and by default it will work on firefox.
   Browser Compatible for this framework:
   Chrome: Version 114.0.5735.133

## Excecution

Use TestRunner to execute the test and generate the extent report for both API and UI tests
1. There are two test runner focused on UI and API both named as below:
    * UI Test Runner: src/test/java/ui/uirunner/TestRunner.java
    * API Test Runner: src/test/java/api/apirunner/TestRunner.java

    
## Validations performed

1. API: Status code validation for each call.
2. API: headers validation for each call.
3. API: Message validation for response wherever required.
4. API: Applicable assertions has been placed using AssertJ.
5. UI: All the required validations has been performed.

## Test Data

1. Test data has been used via feature file by using scenario outline examples.
2. Environment.properties file has been used to store few global variables e.g. Browser, urls etc.

## Coding Standards and Style:

1. Use consistent indentation, spacing, and brace placement throughout the codebase.
2. Adhere to the naming conventions and code style guidelines of the chosen programming language or framework.
   named meaningfully to avoid unnecessary comments within the code.
3. Use meaningful and descriptive names for variables, functions, classes, and methods.
4. Follow the SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation,
   Dependency Inversion) to design modular and maintainable code.

## Logging

log4j2 has been used to perform logging in the framework to showcase the flow the tests which are running. We can find
the logs under logs folder.

## Test Reporting

1. Utilize reporting frameworks and tools like Extent Reports and log4j:
2. Generate comprehensive and visually appealing test reports with detailed information about test execution, status,
   screenshots, and log messages.

## WebDriver
   1. chromedriver -  driver is compatible with MACOS with version 114.0.5735.133
   2. geckodriver -   driver is compatible with MACOS with version v0.33.0

## Properties file

These files are stored under resources folder to store data for various purpose. 

## Screenshots
This directory has been created to store the screenshots for test evidence purpose.

## Tools

* UI Automation : Selenium
* API Automation : Rest Assured
* Reporting: Extent Reports
* Build Tool: Maven
* BDD: Cucumber
* IDE: Intellij IDEA
* Testing Framework: Junit
* Language : Java
* Logging : log4j2
* OS: MAC OS
* Reporting: Extent Reports

