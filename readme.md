# Spring Boot Hello World example
This project consists of a simple hello world program that returns a "Hello world!" string via a HTTP get.

## To run unit test with Maven:
```
mvn test
```
The result output is displayed on screen
## To run unit test with Gradle:
```
gradle test
```

## To run:
Two ways of running this application:

### spring-boot:run :

```
mvn spring-boot:run
```

### java -jar: 

```
mvn package
java -jar target/helloworldproject-0.0.1-SNAPSHOT.jar
```

## To test the app with curl:
## curl:
```
curl http://localhost:8080
```

## dependency-check:

Add this certificate to the cacerts keystore.

```bash
 
sudo keytool -import -noprompt -trustcacerts -alias nistca -file ./nvd.nist.gov -keystore /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/security/cacerts -storepass changeit
```

```bash
mvn clean dependency-check:check
```

## SonarQube

I run SonarQube container on port 49004.

```bash
mvn -Dsonar.host.url=http://localhost:49004 clean test sonar:sonar
```

## Working with OpenShift Community Development/OKD 3.11:
I used this website to create a java s2i application template: https://github.com/jorgemoralespou/s2i-java.

### Import the template:
```
oc cluster up
oc new-project springboot-sti
oc create -f https://raw.githubusercontent.com/jorgemoralespou/s2i-java/master/ose3/s2i-java-imagestream.json
```
### create the app via CLI:
```
oc new-app --image-stream=s2i-java --code=https://github.com/drtran/spring-boot-hello-world.git
oc expose svc spring-boot-hello-world
```

## To test application with curl:
### curl:
```
curl http://spring-boot-hello-world-springboot-sti.127.0.0.1.nip.io
```

## Prerequisites:
The following is a list of prerequisite software I used for this project.

### Fedora:
I run Fedora 30 on a Virtual Machine using Oracle Virtual Box software located here: https://www.virtualbox.org/. I stay with the latest 5.x instead of using 6.x because I experienced VM crashes so many times with 6.x. You can get a copy of Fedora ISO image here: https://getfedora.org/.

### Docker
I install Docker engine for fedora VM using this website: https://developer.fedoraproject.org/tools/docker/docker-installation.html. You need a Docker engine to run the OpenShift OKD 3.11.

### OpenShift OKD 3.11
I run OpenShift OKD 3.11 using this website: https://developer.fedoraproject.org/deployment/openshift/about.html.

### Integrated Development Environment (IDE):
I used these IDE tools for this project even though I should need only one.

- Visual Studio Code (VS Code)
- IntelliJ 2019.2
- Spring Tool Suite (STS 4.x)
