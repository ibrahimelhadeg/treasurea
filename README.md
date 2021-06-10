# TREASUREA

A map where multiple explorers can gather treasures while avoiding obstacles

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Building or running this project requires that [Java 16 or newer](https://jdk.java.net/java-se-ri/16) be available on your machine.

## Development

### Setup

After installing Java, you should be able to run the following command to install project dependencies.

    ./mvnw dependency:resolve

You will only need run this command when dependencies change in [pom.xml](pom.xml).

To compile the sources, use :

    ./mvnw clean compile

Run the following command in a terminal to start the application on the development mode.

    ./mvnw exec:java

## Testing

To compile then run the tests, use :

    ./mvnw clean test


## Building for production

To prepare the splitter application for production, run:

    ./mvnw clean package

This will produce a JAR file on the `target` directory. To ensure everything worked, run:

    java -jar target/*.jar

Then you can use the program from your terminal.


## Deployment

TODO

## Troubleshooting

If you get the message `permission denied: ./mvnw`, when trying to run the commands,
execute the following command (to ask your system to attribute the permission to the file [mvnw](mvnw)):

    chmod +x mvnw

In case of error when running the provided commands, try to add the arguments `-e` or `-X` to get detailed error messages

If your Java version is older than 16, and you've encountered problems running any of the commands, try to run it by appending at beginning `export JAVA_HOME="/path/to/java/16/jdk" && `

    export JAVA_HOME="/path/to/java/16/jdk" && ./mvnw clean test

## Built With

* [Java](https://jdk.java.net/) - The programming language
* [Google Guava](https://github.com/google/guava) - to make using the Java language more pleasant
* [JUnit](https://junit.org/) and [Mockito](https://site.mockito.org/) - Used to create tests
* [Maven](https://maven.apache.org/) and [Maven Wrapper](https://github.com/takari/maven-wrapper) - Dependency Management
* [Git](https://git-scm.com/) - as version-control system

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Author

* **Ibrahim El Hadeg**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
