## How to install

Download the project and run the command <br><br>
`mvn clean install`

## Run test

To run the test, use the command

`mvn clean verify`

## To add new tests
1. Add a feature file in `src/test/resources/features`
2. Add a new endpoint in `src/test/java/com.example/SwaggerApiEndPoints`
3. Create a new steps class in `src/test/java/com.example/stepdefs`

## Endpoints Documentation
The end points are documented in <br>
https://generator.swagger.io/

## Reports
HTML reports for the serenity tests can be found in
`target/site/serenity/index.html`
