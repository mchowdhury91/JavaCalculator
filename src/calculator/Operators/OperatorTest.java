package calculator.Operators;

import java.util.Stack;

public class OperatorTest {

	public OperatorTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		Operator add = new Addition();
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("5");
		stack.push("7");
		
		System.out.println(add.operate(stack));
	}

}
