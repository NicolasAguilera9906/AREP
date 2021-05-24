# LAB #1 - Mean and Standard Desviation calculator

Program to calculate the mean and standard deviation of a set of n real numbers. The program reads the n real numbers from a file.

## Getting Started

The following instructions will allow you to have a copy of the project and run it on your machine.

### Prerequisites

* [Maven](https://maven.apache.org/) - Dependency Management

* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Development Environment 

* [Git](https://git-scm.com/) - Version Control System

### Installing

1. Clone the repository

```
git clone https://github.com/NicolasAguilera9906/AREP-LAB1
```

2. Compile the projet

```
mvn package
```

3. Executing the program

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arem.ASE.app.App"
```

4. Generating the documentation

```
mvn javadoc:javadoc
```

The documentation will be generated in target/site/apidocs/index.html.

[Documentation](https://nicolasaguilera9906.github.io/AREP-LAB1/)

## Running the tests

To run the unit tests

```
mvn test
```

## Test Data

In this workshop we have two test cases along with their respective mean and standard deviation.

In the following tables you can see the test data and the expected results.

![table](https://github.com/NicolasAguilera9906/AREP-LAB1/blob/main/resources/imagenTablas.PNG) 

Observing the results we can see that these are equal to the expected ones so the program behaves correctly when making the corresponding calculations.

![table](https://github.com/NicolasAguilera9906/AREP-LAB1/blob/main/resources/resultadosPruebas.PNG) 

## Diagrams

An own implementation of LinkedList is made. The class extends AbstractSecuentialList and implements the List, Deque, Clonable and Serializable interfaces to be compatible with the Java api. It also makes its own implementation of the Linked List Iterator, extending from Iterator. Finally, it has its own implementation of the nodes that are part of the LinkeList, each of them stores the value and the reference to the next node.

![diagram1](https://github.com/NicolasAguilera9906/AREP-LAB1/blob/main/resources/diagrams/LinkedListClassDiagram.PNG) 

There is a class called ComputingService that will allow the user to access the application services. In this case, this class will connect with an interface called Calculator that will allow to perform an operation on a LinkedList. In this case, the standard deviation or the mean of the values in the LinkedList can be calculated. For that there are two classes called MeanCalculator and StandardDesviationCalculator that extend from the Calculator interface. This allows us to add more operations easily in case the user requires it.

![diagram2](https://github.com/NicolasAguilera9906/AREP-LAB1/blob/main/resources/diagrams/CalculatorsDiagram.png) 


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Inform

* [View inform](https://github.com/NicolasAguilera9906/AREP-LAB1/blob/main/resources/informe.pdf)

## Author

* **Nicolás Aguilera Contreras** 

## License

This project is under GNU General Public License - see the [LICENSE](LICENSE) file for details
