package calculator.Operators;

import java.util.Stack;

public class Multiplication extends BinaryOperator{

	public Multiplication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecedence() {
		return 3;
	}

	@Override
	public String getName() {
		return "*";
	}

	@Override
	public double performOperation(double a, double b) {
		return a*b;
	}

}
