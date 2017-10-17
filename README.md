## CookCollab Web Application

This is the web app for CookCollab. It uses Spring Boot with Hibernate connected to a PostgreSQL database and is built with gradle.
It requires a src/main/resources/application.properties file to look like this:

```
spring.jpa.hibernate.ddl-auto=none

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect

spring.datasource.url=jdbc:postgresql://<<Database>>

spring.datasource.username=<<Database User>>

spring.datasource.password=<<Database Password>>

spring.jpa.properties.hibernate.default_schema=public

spring.datasource.driver-class-name=org.postgresql.Driver

spring.thymeleaf.cache=false
```

## CookCollab

The purpose of this project is to allow users to create an event and invite other users to collaboratively cook a meal. The host can assign
ingredients for each user to bring. The users can also rate each other so they know whom to invite next time.
