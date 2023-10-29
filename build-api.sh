#!/bin/zsh

# Greetings
echo "-------> Hello, World!"

mvn clean compile install -DskipTests
echo "-------> Built!"

docker build -t fmb/api .
echo "-------> Build done!"

docker stop container.fmb.api
echo "-------> Stopped container.fmb.api!"

docker rm container.fmb.api
echo "-------> Removed container.fmb.api!"

docker run --network network.fmb --name container.fmb.api -p 8080:8083 -d fmb/api
echo "-------> Running container.fmb.api!"

sleep 20
echo "-------> Slept 20"

curl http://localhost:8080/fmbApi/test/
