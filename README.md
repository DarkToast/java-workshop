# Java workshop
A simple workshop for non java developers to get an introduction

## First steps in the java rover.world
Java is a bytecode based language first developed by Sun Microsystems in 1995.
Currently the java environment is driven by the Oracle corporation and a very big open source community. 
Bytecode based means, that the program code is not compiled directly to a machine specific binary format 
as for example a C program, to a pre format, the so called bytecode. Next this bytecode is interpreted by 
the java virtual machine (JVM), to the machine specific. So you can install a Windows JVM, a Linux JVM, a 
MacOS JVM and so on. You may already know this concept from the .Net platform of Microsoft.  

## The Java development kit (JDK) and the java runtime environment (JRE)
### Installation
To get started with java on your machine, you have to install the Java Development Kit (JDK). This kit includes
all necessary libraries, compilers and the Java runtime environment (JRE) to compile your code, link it to the 
standard libraries and execute your compiled bytecode on your machine with the JRE. You also can install the JRE 
standalone, if you wish to only execute already compiled programs.   

You can now either install the [Oracle JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
or the [Open JDK](http://openjdk.java.net/) to start. The only difference of this both is, that the 
oracle JDK is extended by some proprietary code. The rest is equals.
  
### Introduction
Now let take a look at the installed JDK and what we find there. At this quick start, we only refer to the important 
elements:

```
JDK 
 |
 +-bin              The binaries for development and execution
 |   |
 |   +- java        This is the main executable to execute 
 |   |                 compiled java programs
 |   +- javac       'javac' ist the java compiler. It is used to compile 
 |   |                 java files to compiled 'class' files.
 |   +- javac       'javac' ist the java compiler. It is used to compile 
 |   |                 java files to compiled 'class' files.
 |   +- ...
 +-...                     
 +-jre              The java runtime environment. Here we will find the core 
 |   |                 java libraries and also some executables.
 |   |
 |   +- bin         The JRE executables. Here we will also find a 'java' 
 |   |                 program equals to the one in the above bin directory.
 |   +- lib         The java core libraries. Here you can find collection api, 
 |                     file and stream io, concurrent libs, etc.
 +-lib              Libraries for the development and compiling process.
 +-...
```

So what we can do with this programs mentioned above? The following flow diagram shows you the steps from writing to 
executing your code.
 
1. First you will write one and even more of *.java* file, which holds you human readable program code.  
2. With the *javac* compiler you now compile your *.java* files to *.class* file, which holds the java bytecode.
3. These class files can now be executed using the *java* program. With this, the bytecode is interpreted and 
translated to the machine specific binary code.

```
+-----------+   javac    +----------+     java      +--------------+
| Java code | =========> | Bytecode | ============> | machine code |
|   .java   |  compile   |  .class  |   interpret   |   (binary)   |
+-----------+            +----------+               +--------------+
````

## Get into the code
Now it's time to check out this project and dive a little bit into the code.
