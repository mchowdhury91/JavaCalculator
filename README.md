To Run:

Run the JavaCalc.jar file.


To run from the source code in eclipse:
run the main in JCalc.java


This is my attempt at creating a calculator in Java. I am still refactoring the code to have better design and to comment everything. I may redo everything from scratch.


Right now, I attempted to use the Strategy Pattern and have each operator implement an Operator interface I created to make the process for adding new operators simpler. However,
it did not work out well. To add a new operator, you create a new class that implements Operator. Then you add that operator to the static operatorMap in Calculator.java. The problem is that there is 
that I currently have no way in the Operator interface to define the syntax for non-binary operators. For example, the syntax for sin should be "sin(a)" where a is the operand.
The syntax for binary operators is always "a Y b" where Y is some operator and a and be are operands. I need to implement a way for the operator interface to dictate the syntax for the operator. 