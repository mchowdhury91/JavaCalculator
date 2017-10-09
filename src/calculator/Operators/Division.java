package calculator.Operators;

import java.util.Stack;

public class Division extends BinaryOperator{

	public Division() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrecedence() {
		return 3;
	}

	@Override
	public String getName() {
		return "/";
	}

	@Override
	public double performOperation(double a, double b) {
		return a/b;
	}

}
