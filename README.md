# Example telegram bot using libraries [TelegramBots](https://github.com/rubenlagus/TelegramBots)

1. [How to launch a bot](#Information-on-launching-and-configuring-the-bot)
   - [Build project](#build-project)
   - [Example config](#example-config)
   - [Database](#database)
   - [Logging](#logging-in-project)

# Information on launching and configuring the bot

## Build project
To build the project you need maven which can be downloaded [here](https://maven.apache.org/download.cgi),
or use shell or cmd files in the project root depending on your operating system.

All commands must be written in the root folder of the project.

If you installed maven yourself use the `mvn clean` command to clean up old artifacts. If you don't want to install maven just use the `mvnw clean` command.

If you installed maven yourself you can build the project using the `mvn package` command. If you don't want to install maven just use the `mvnw package` command.
## Example config
```yaml
telegram:
  bot:
    token: # your token should be here
    name: # your bot name

spring:
  datasource:
    url: # your database url jdbc
    username: # your username database
    password: # your password database
    hikari:
      maximum-pool-size: 25
      auto-commit: false
      leak-detection-threshold: 3000
  flyway:
    default-schema: # your database schema
    encoding: utf8
    locations: classpath:db/migration
    enabled: true
```

## Database
To run our bot we need to create a database, this can be done using [Docker](#database-in-docker) or by installing [Postgresql](#postgresql).

### Database in Docker
In the first method we will deploy our database in Docker, for this we need to create a Dockerfile with the following content in the project directory:
```dockerfile
FROM postgres:16.1
ENV POSTGRES_PASSWORD=2wsx@WSX
COPY src/main/resources/db/CreateDB.sql /docker-entrypoint-initdb.d/
```
After we create the Dockerfile, we just need to write two commands to create the database:
```shell
docker build -t java-tg-bot-database .
docker run --name TGbotDatabase -p 5432:5432 -d java-tg-bot-database
```
-------------------------------------------------------------------------------------------------------------------------------------------------------
### Postgresql
In the second method we will install postgresql and create a user database and a schema for it there.
The first step is to install postgres from the official [website](https://www.postgresql.org/download/).
After installing postgresql, we open psql and connect to the standard postgres database and enter sql commands:
```postgresql
CREATE ROLE "TGBotSU" WITH
   LOGIN
   SUPERUSER
   CREATEDB
   CREATEROLE
   INHERIT
   REPLICATION
   CONNECTION LIMIT 3
   PASSWORD 'NDQ8ydV#';

CREATE DATABASE "TGBotDB"
   WITH
   OWNER = "TGbotSU"
   ENCODING = 'UTF8'
   LOCALE_PROVIDER = 'libc'
   CONNECTION LIMIT = 3
   IS_TEMPLATE = False;

CREATE SCHEMA "TGBotSchema"
   AUTHORIZATION "TGbotSU";
```
After you have created the database, you need to edit the [config](#example-config), flyway will do the rest for you.

## Logging in project
The project uses logback, documentation can be found at this [link](https://logback.qos.ch/manual/appenders.html).
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
   <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
      <encoder>
         <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} -%kvp- %msg%n</pattern>
      </encoder>
   </appender>
   <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
      <prudent>true</prudent>
      <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
         <fileNamePattern>logs/TGBot.%d{yyyy-MM-dd}.log</fileNamePattern>
         <maxHistory>30</maxHistory>
         <totalSizeCap>3GB</totalSizeCap>
      </rollingPolicy>
      <encoder>
         <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} -%kvp- %msg%n</pattern>
      </encoder>
   </appender>

   <root level="info">
      <appender-ref ref="FILE"/>
      <appender-ref ref="CONSOLE"/>
   </root>
</configuration>
```