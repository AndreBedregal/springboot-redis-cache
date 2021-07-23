# Getting Started

Please follow the steps below to run this app in Docker.

### Build app
First, package this project using Maven. Then, build the Docker image.
```shell
mvn clean package
docker build -t javanatic/springboot-redis-cache .
```

### Start app
Start the required services (PostgreSQL, Redis and this app)
```shell
docker-compose up -d && docker-compose logs -f
```

### End the application
```shell
docker-compose down
```