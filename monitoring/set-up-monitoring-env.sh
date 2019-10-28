#!/usr/bin/env bash

echo "Building jar file"
cd .. #Quick workaround as ../gradlew does not work correctly
./gradlew clean build
cd monitoring

echo "Building hello app docker image"
docker build -t symphony/monitoring-demo  ../

echo "Staring all apps"
docker-compose up > applications.logs &

sleep 30 #let the apps to start
echo "Sending sample RQs to generate some statistics"

APP_URL=localhost:8080

curl $APP_URL/hello?name=tom
curl $APP_URL/hello?name=mark
curl $APP_URL/hello?name=tom

curl $APP_URL/goodbye
curl $APP_URL/goodbye

curl $APP_URL/fakeendpoint

curl $APP_URL/longHello