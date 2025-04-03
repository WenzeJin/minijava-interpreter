# MiniJava Interpreter

[![Java CI with Maven](https://github.com/WenzeJin/minijava-interpreter/actions/workflows/maven.yml/badge.svg)](https://github.com/WenzeJin/minijava-interpreter/actions/workflows/maven.yml) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a simple interpreter for the MiniJava language, written in Java. This project is also a part of the course _Compiler & Virtual Machines_ of Nanjing University.

> [!Note]
> This project is still under development. The interpreter is not fully functional yet.

## About MiniJava

MiniJava is a simple language designed for educational purposes. Most of the syntax and semantics are similar to Java, but it is simpler and lacks some features. The grammar of MiniJava can be found in the folder `grammar`.

MiniJava supports the following features:

- Object-Oriented Programming: Classes and objects, Inheritance, Polymorphism
- Procedure-Oriented Programming: Functions (outside classes)
- Arrays

MiniJava is a statically-typed language, which means that the type of each variable must be declared before it is used. The type system of MiniJava is similar to that of Java.

MiniJava is a strongly-typed language (mostly), which means implicit type conversion is not allowed (except char to int / null to any reference type).

> [!Tip]
> More information about typing systems can be found [here](https://en.wikipedia.org/wiki/Type_system).  
> For example, C is a statically and weakly typed language, while Python is a dynamically and strongly typed language, and Java is a statically and strongly typed language.  
> MiniJava follows the type system of Java.

### Primitive Types

| Type    | Description |
| ------- | ----------- |
| int     | 32-bit signed integer |
| boolean | true or false |
| char    | 8-bit signed integer |
| string  | a sequence of characters |

## How to Build

This project is built using Maven. To build the project, run the following command:

```shell
mvn clean assembly:assembly
```

You can find the built JAR file in the `target` folder.

## How to Run

To run the interpreter, use the following command:

```shell
java -cp target/minijava-1.0-SNAPSHOT-jar-with-dependencies.jar cn.edu.nju.cs.Main <filename>
```

Where `<filename>` is the path to the MiniJava source file you want to run.

## How to Test

All the test cases are in `src/test/resources/testcases` folder. Both input and output files are provided. `FuntionalProgrammingTest.java` tests the functional programming features (functions, primitive types, arrays) of MiniJava, while `ObjectOrientedProgrammingTest.java` tests the object-oriented programming features of MiniJava.

```shell
mvn test
```

> [!Caution]
> This project is licensed under the MIT License. See the [License](LICENSE) file for more information.  
> Copyriht (c) 2025, Wenze Jin, All rights reserved.
