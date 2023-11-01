# demoKsrtc
# Selenium WebDriver Project - KSRTC Bus Booking

This project demonstrates a Selenium WebDriver test script using the Page Object Model (POM) design pattern to automate the booking process on the KSRTC website. Applying data driven Testing (DDT).
The script performs the following actions:

1. Opens the KSRTC website.
2. Selects the popular route from "CHIKKAMAGALURU" to "BENGALURU".
3. Chooses the arrival date.
4. Clicks "Search for bus".
5. Selects a seat.
6. Chooses the boarding and dropping points.
7. Fills in customer and passenger details that provided by Excelsheet.
8. Clicks "Make Payment" and fills all payment fields without submitting the payment.

## Prerequisites

Before running the test script, make sure you have the following installed:

- Java Development Kit (JDK)
- Maven
- WebDriver executable (e.g., ChromeDriver for Google Chrome)
- TestNG (Test framework)

  
## Test Data
The test data for the scenarios can be found in the src/resources/testdata directory as customerdata. You can modify this data (in the order that been used) to test different scenarios.

## KSRTC Login page scenario 
## Failed login 
1. Fills username and password with wrong credentails 
2. Agrees on terms
3. Clicks login
4. Assert that error message has been shown
    
## Successful login
1. Fills username and password with correct credentails 
2. Agrees on terms
3. Clicks login
4. Assert that directed to the right page

## Running 
The loginTest runs as a standalone file

## Test Data
The test data for the scenarios can be found in the src/resources/testdata directory as testdata. You can modify this data (in the order that been used) to test different scenarios.

   
