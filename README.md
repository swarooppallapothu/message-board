# message-board
Message board backend application

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Starting the App During Development
Use the Spring Boot Maven plugin to start the app from the command line.  Basic usage looks like this.
```
$ mvn spring-boot:run
```
We can use `-Drun.jvmArguments` to pass in additional arguments to the spring-boot plugin.  For instance, you may want to turn on the debugger, layer various Sprint profiles, or modify logging.

