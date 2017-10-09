package calculator.Operators;

import java.util.Stack;

public abstract class BinaryOperator implements Operator{

	@Override
	public abstract int getPrecedence();
	@Override
	public int getNumArgs() {
		return 2;
	}

	@Override
	public abstract String getName();

	@Override
	public double operate(Stack<String> expressionStack) {
		double b = getOperand(expressionStack);
		double a = getOperand(expressionStack);
		
		return performOperation(a, b);
	}

	public abstract double performOperation(double a, double b);
	
	@Override
	public double getOperand(Stack<String> expressionStack) {
		return Double.parseDouble(expressionStack.pop());
	}

}
