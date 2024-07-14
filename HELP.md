# Modos de execução

## Execução em desenvolvimento (Profile dev)

 - Criar um container docker de teste

        docker run --name mongo-dev -p 27018:27017 -e MONGO_INITDB_DATABASE=ezblue -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=mongo -d mongo

 - Rodar a execução pelo próprio Intellij ou IDE de preferência.

## Execução com docker (Profile prod)

Execução com container local:

 - Criação de rede
    
        docker network create -d bridge ezblue

 - Criação de container mongodb

        docker run --name mongo-blue -p 27017:27017 --network ezblue -e MONGO_INITDB_DATABASE=ezblue -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=mongo -d mongo

 - Build do boundary service

        docker build -t boundary-service . 

 - Execução do boundary service

        docker run --name boundary-service -p 8085:8085 --network ezblue -d boundary-service
