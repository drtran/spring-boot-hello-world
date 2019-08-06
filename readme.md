# Spring Boot Hello World example
This project consists of a simple hello world program that returns a "Hello world!" string via a HTTP get.

# To run:
Two ways of running this application:

## spring-boot:run :

```
mvn spring-boot:run
```

## java -jar: 

```
mvn package
java -jar target/helloworldproject-0.0.1-SNAPSHOT.jar
```

## curl:
```
curl http://localhost:8080
```

# OpenShift/OKD 3.11:
I used this website to create a java s2i application template: https://github.com/jorgemoralespou/s2i-java.

## Import the template:
```
oc cluster up
oc new-project springboot-sti
oc create -f https://raw.githubusercontent.com/jorgemoralespou/s2i-java/master/ose3/s2i-java-imagestream.json
```
## create the app via CLI:
```
oc new-app --image-stream=s2i-java --code=https://github.com/drtran/spring-boot-hello-world.git
oc expose svc spring-boot-hello-world
```

## curl:
```
curl http://spring-boot-hello-world-springboot-sti.127.0.0.1.nip.io

```
