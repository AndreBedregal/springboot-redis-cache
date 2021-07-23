FROM openjdk:11

ADD /target/redis-cache-0.0.1-SNAPSHOT.jar springboot-redis-cache.jar

ENTRYPOINT ["java","-jar","springboot-redis-cache.jar"]