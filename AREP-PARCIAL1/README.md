# AREP-PARCIAL 1
## Weather Calculator

Spark Web Application that calculates the weather from a city.

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://arepparcial1nicolasaguilerac.herokuapp.com/clima?lugar=bogota)


## Getting Started

The following instructions will allow you to have a copy of the project and run it on your machine.

### Prerequisites

* [Maven](https://maven.apache.org/) - Dependency Management

* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Development Environment 

* [Git](https://git-scm.com/) - Version Control System

### Installing

1. Clone the repository

```
git clone https://github.com/NicolasAguilera9906/AREP-PARCIAL1
```

2. Compile the projet

```
mvn package
```

3. Executing the program

```
mvn exec:java -Dexec.mainClass="Server.SparkWebServer"
In your browser : http://localhost:4567/clima?lugar=Bogota  (Change Bogotá for the city that you want)
```

4. Generating the documentation

```
mvn javadoc:javadoc
```

The documentation will be generated in target/site/apidocs/index.html.

[Documentation](https://nicolasaguilera9906.github.io/AREP-PARCIAL1/)

## Running the tests

To run the unit tests

```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Nicolás Aguilera Contreras** 

## License

This project is under GNU General Public License - see the [LICENSE](LICENSE) file for details
