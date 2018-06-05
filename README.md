# Reverse Polish Notation Calculator

Reverse Polish notation (RPN), also known as Polish postfix notation or simply postfix notation, is a mathematical notation in which operators follow their operands.
[RPN](https://en.wikipedia.org/wiki/Reverse_Polish_notation) - Wiki

## Requirements

* The calculator has a stack that can contain real numbers.
* The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
* Numbers are pushed on to the stack. Operators operate on numbers that are on the stack.
* Available operators are +, -, *, /, sqrt, undo, clear
* Operators pop their parameters off the stack, and push their results back onto the stack.
* The 'clear' operator removes all items from the stack.
* The 'undo' operator undoes the previous operation. "undo undo" will undo the previous two operations.
* sqrt performs a square root on the top item from the stack
* The '+', '-', '*', '/' operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
* After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
* Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
* All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
* If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:
operator <operator> (position: <pos>): insufficient parameters
* After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.

Example:

```
Enter your expression to be evaluated :
5 2
Stack : [5.0, 2.0]
clear
Stack : [Empty Stack]
2 sqrt
Stack : [1.4142135623730951]
clear
Stack : [Empty Stack]
5 2 -
Stack : [3.0]
clear
Stack : [Empty Stack]
5 4 3 2
Stack : [5.0, 4.0, 3.0, 2.0]
undo undo *
Stack : [20.0]
5 *
Stack : [100.0]
```
If there is an exception:

```
1 2 3 * 5 + * * 6 5
operator * (position: 8): insufficient parameters
Stack : [11.0]
(the 6 and 5 were not pushed on to the stack due to the previous error)
```

## Getting Started

### Prerequisites

Java 8
Maven 3.5.3


### Setup & Running the application

#### Through Command Line

Run the following maven commands to get started

To download and install all dependencies:

```
mvn clean install -DskipTests
```

Run the tests:

```
mvn clean test
```

Run the application (main method):

```
mvn exec:java
```

#### Through Eclipse

* Open eclipse.
* Click File > Import.
* Type Maven in the search box under Select an import source:
* Select Existing Maven Projects.
* Click Next.
* Click Browse and select the folder that is the root of the Maven project (probably contains the pom.xml file)
* Click Next.
* Click Finish.