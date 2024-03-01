# Amazon Statistics Processor Application
Spring boot application for loading some Amazon statistics into DB and viewing it by parameters

Technologies used:
* Spring Web
* Spring Security
* Spring Cache
* MongoDB
* Lombok
* Mapstruct

## Description

The application takes the statistics data from the JSON file, converts it into Java classes and saves to database. 
It also keeps the database up-to-date with the file as the file is constantly checked for any changes.
The application allows users to register, log in (using JWT) and get either the general statistics or the specific one (using params)
It is also using caching in order to decrease the response time (as the data will be accessed from cache instead of Database)
