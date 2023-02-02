#!/bin/bash

# build the app
mvn clean package
# stop container
docker stop empresa-service-jvm
# remove container
docker rm empresa-service-jvm
# remove container image
docker rmi spring/empresa-service-jvm:latest
# build container image
docker build -f Dockerfile.jvm -t spring/empresa-service-jvm .
# run container
docker run -id --network=trace-net -e LOGGING_URL=http://openzipkin:9411 --name empresa-service-jvm -p 8080:8080 spring/empresa-service-jvm