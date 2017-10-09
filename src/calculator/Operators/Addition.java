package calculator.Operators;

import java.util.Stack;

public class Addition extends BinaryOperator{

	public Addition() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecedence() {
		return 2;
	}

	@Override
	public String getName() {
		return "+";
	}

	@Override
	public double performOperation(double a, double b) {
		return a+b;
	}

}
