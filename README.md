# Deep Copy Utility in Java
### technical interview test

This project provides a utility for performing deep copies of objects in Java, handling various edge cases including nested objects, collections, arrays, and primitive fields. The utility avoids using `Serializable` and `Cloneable` and instead relies on reflection to create deep copies.
A simple successful scenario can be found in the `Main` class. 

Functional tests and validity of error handling are tested in test package `DeepCopyTests` class.
`Junit4` library is used for writing the tests.


## Features

- Deep copy of arbitrary objects
- Handles nested objects, lists, sets, maps, and arrays
- Works with custom classes
- Demonstrates functionality with various test methods

## Prerequisites

- Java 17 or above

## Project Structure

- `DeepCopyUtils.java`: Contains the utility method for deep copying objects.
### Models
- `Book.java`: A sample class to demonstrate deep copying of nested objects.
- `Employee.java`: A sample class to demonstrate deep copying of objects with nested objects and primitive fields.
- `Library.java`: A sample class to demonstrate deep copying of collections.
- `Man.java`: A sample class to demonstrate deep copying of simple objects.

## Usage

### Cloning Objects

The `DeepCopyUtils` class provides a static method `deepCopy` to create deep copies of objects. The method handles various types of fields, including nested objects, collections, arrays, and primitive fields.
