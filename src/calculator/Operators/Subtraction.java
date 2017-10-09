package calculator.Operators;

import java.util.Stack;

public class Subtraction extends BinaryOperator{

	public Subtraction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecedence() {
		return 2;
	}

	@Override
	public String getName() {
		return "-";
	}

	@Override
	public double performOperation(double a, double b) {
		return a-b;
	}

}
