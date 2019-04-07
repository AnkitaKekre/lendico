## Lendico

Repayment Plan Generator Application is a final repayment schedule having pre-calculated repayment plans throughout the lifetime of a loan.

## Requirements

Java along with Maven is required to run the application:

1. Java 8
2. Maven

## Technical Details

Spring Boot Application

API accepting Http POST request, processing the input and responding with the response.

Logs are added for tracking and debugging.

hamcrest and fasterxml are added for testing.

## Assumptions

1. Number of days in a month - 30 days.

2. Number of days in a year - 360 days.

## API Description

1. Endpoint:

   http://localhost:8080/generate-plan

2. Supported Method:

   POST

3. Request Header:

   Content-Type: application/json

4. Response Header:

   Content-Type: application/json

