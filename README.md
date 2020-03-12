# consumer-driven-contract-testing
consumer-driven contract testing study

## consumer side (credit-card-service)
Generate stubs:  
`mvn clean install -DskipTests -f centralized-contract-repo\src\main\resources\contracts\com\nu75h311\credit-check-service\pom.xml`

Run tests:  
`mvn clean install -f credit-card-service\pom.xml`

## provider side (credit-check-service)
Generate tests:  
`mvn clean install -f centralized-contract-repo\pom.xml`

Run tests:  
`mvn clean install -f credit-check-service\pom.xml`
