# Permutation Generator

The Permutation Generator is a data stucture that generates integer permutations between user specified bounds. The integers can be received in a random order by using the iterator directly or through a for each loop.

### Purpose

This project serves mainly as a utility for software testing. For example, the generator can be used to insert and delete unique values from an AVL tree.

### Installation

The project is managed using Maven. Following are the installation steps...

1. Clone or download the files into a directory.
2. Ensure that Maven and Java version 14 are installed. If a different version of Java is needed, the compiler and target versions will need to be changed in the pom.xml file.
3. Run "maven clean install" from command line on the directory with the source files. This will install the file in your local maven directory.
4. Add the dependency to your maven project using the following format...

```xml
<dependency>
  <groupId>jashlal</groupId>
  <artifactId>PermutationGenerator</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
