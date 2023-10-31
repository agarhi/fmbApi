#!/bin/zsh

# Greetings
echo "-------> Hello, World!"

cd src/main/resources/sql

docker build -t fmb/db .
echo "-------> Build done!"

docker stop container.fmb.db
echo "-------> Stopped container.fmb.db!"

docker rm container.fmb.db
echo "-------> Removed container.fmb.db!"

container_id=$(docker run --network network.fmb -e "MYSQL_ROOT_PASSWORD=kaha53K@H@" --name=container.fmb.db -d fmb/db)
echo "-------> Running container.fmb.db!"

docker logs --follow $container_id

# docker exec -it container.fmb.db bash;