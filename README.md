# Spring Boot - Hexagonal Architecture Project

![](https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=spring&logoColor=white)
![](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![](https://img.shields.io/badge/Database-H2-blue.svg)

This application is an example of database queries that follows the hexagonal architecture pattern.


### :gear: Project installation and :wrench: Configuration
1. Clone repository:
```sh
> cd <folder path>
> git clone https://github.com/vitorianobruno/java-springboot-hexagonal-prices.git
```
2. Import project **IntelliJ IDEA**
    1. **Import Project**, and select folder project.
    1. Select: **Create Project from external model**, Select: **Maven**.

### :rocket: Execution
1. Local deployment: `> mvn clean install`
2. Run project: `> mvn spring-boot:run -pl project-prices`

### :heavy_check_mark: Testing
1. Unit tests: `> mvn test`
2. Integration tests: 
   1. Import Project **Postman** 
   1. Select: **Import**, and select `project-prices.postman_collection` file in src/main/resources
   2. Send calls to application.