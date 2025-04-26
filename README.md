# MS Template

`ReplaceMe` suffix is used across the application as a template name, which should be changed;

### Gradle

- run unit tests: `gradlew test`
- run integration tests: `gradlew integrationTest`
- build without tests: `gradlew build -x test`
- build with unit tests: `gradlew build`
- build with both unit and integration tests: `gradlew build -Dtest.profile=integration`