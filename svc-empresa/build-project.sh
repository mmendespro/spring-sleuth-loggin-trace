#!/bin/bash

# build the app
mvn clean package
# stop container
docker stop departamento-service-jvm
# remove container
docker rm departamento-service-jvm
# remove container image
docker rmi spring/departamento-service-jvm:latest
# build container image
docker build -f Dockerfile.jvm -t spring/departamento-service-jvm .
# run container
#docker run -id --network=trace-net --name departamento-service-jvm -p 8081:8081 spring/departamento-service-jvm