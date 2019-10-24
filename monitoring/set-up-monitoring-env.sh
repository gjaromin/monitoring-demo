#!/usr/bin/env bash

echo "Building jar file"
./gradlew clean build

echo "Building hello app docker image"
docker build -t symphony/monitoring-demo  ../

echo "Staring all apps"
docker-compose up