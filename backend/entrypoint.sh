#!/bin/bash

echo "Spring Sample API -- Checking PostgreSQL Server 🐘"
until pg_isready -h $DB_HOST -t 1 ; do
    echo "Spring Sample API -- PostgreSQL Server is not ready... ⏳"
    sleep 1 
done

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -Dspring.devtools.restart.enabled=true -jar /app/build/libs/spring-boot-application.jar