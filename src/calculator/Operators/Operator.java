package calculator.Operators;

import java.util.Stack;

public interface Operator {

	public int getPrecedence();

	public int getNumArgs();

	public String getName();
	
	public double operate(Stack<String> expressionStack);

	public double getOperand(Stack<String> expressionStack);	
}
