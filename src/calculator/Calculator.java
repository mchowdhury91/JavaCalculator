package calculator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import calculator.Operators.*;

public class Calculator {

	static HashMap<String, Operator> operatorMap;	
	
	/*
	 * Edit functions below to add more operators/functions to parse and evaluate
	 */
	
	// add any new operators/functions to the operatorMap in the static block below
	// Operator constructor takes: String name, int numArguments, int precedence
	static {
		operatorMap = new HashMap<String, Operator>();
		operatorMap.put("*", new Multiplication());
		operatorMap.put("/", new Division());
		operatorMap.put("+", new Addition());
		operatorMap.put("-", new Subtraction());
	}			
	
	/** returns the precedence of the operator represented by String s
	**/
	public static int getPrecedence(String s){
		s = s.toLowerCase();
		try{
			int precedence = operatorMap.get(s).getPrecedence();
			return precedence;
		}catch(NullPointerException e){
			return 0;
		}
	}	

	public static double logN(double base, double n){
		double result = Math.log(n) / Math.log(base);
		return result;
	}
	
	/** converts user entered equation into postfix notation
	 ** eg:  "3+4*6" becomes { 3, 4, 6, *, + } in array form
	 ** white spaces and multiplication symbols must be inserted before running this function
	 ** otherwise it will not work as intended
	 **/
	public static String[] infixToPostfix(String string){
		string = string.trim(); // remove leading and trailing white spaces
		//System.out.println(string);
		String[] array = string.split("\\s+");
		String[] outputArray = new String[array.length - StrManip.countSpecialChars(array)];
		LinkedList<String> fifo = new LinkedList<String>();
		Stack<String> operatorStack = new Stack<String>();
		
		int i = 0;
		
		while(i < array.length){
			if(StrManip.isNumber(array[i])){
				fifo.add(array[i]);				
			}else if(StrManip.isOperator(array[i]) || operatorMap.containsKey(array[i])){
				try{
					while(!operatorStack.isEmpty() && 
							getPrecedence(operatorStack.peek()) >= getPrecedence(array[i])){
						fifo.add(operatorStack.pop());
					}
				}catch(EmptyStackException e){
					
				}
				
				operatorStack.push(array[i]);
			}else if(array[i].equals("(")){
				operatorStack.push(array[i]);
			}else if(array[i].equals(")")){
				while(!operatorStack.isEmpty() &&
						!operatorStack.peek().equals("(")){
					fifo.add(operatorStack.pop());
				}
				if(!operatorStack.isEmpty()) operatorStack.pop();
			}
			
			i++;
		}
		
		try{
			while(!operatorStack.isEmpty()){
				fifo.add(operatorStack.pop());
			}
			
		}catch(EmptyStackException e){
			
		}
		
		for(int j = 0; j < outputArray.length; j++){
			if(!fifo.isEmpty())
				outputArray[j] = fifo.removeFirst();
		}
		
		return outputArray;
	}
	
	/**
	 * Given an equation (eg, "3+4(6)")
	 * 
	 * It will insert white spaces and multiplication symbols as necessary
	 * "3+4(6)" becomes "3 + 4 * (6)"
	 * Then it will evaluate the equation and return a double
	 * calculate("3+4(6)") will return 27.0 
	 */
	public static double calculate(String equation){
		equation = StrManip.insertWhiteSpaces(equation);
		equation = StrManip.insertMultiplication(equation);
//		System.out.println(equation);
		String[] array = infixToPostfix(equation);
		double result = evaluatePostfix(array);
		return result;
	}
	
	/**
	 * Given a string array of an equation in postfix form
	 * (such as the one from infixToPostfix function)
	 * it will return a double that evaluates the equation
	 * 
	 * (see the calculate function above for the entire process)
	 */
	public static double evaluatePostfix(String[] array){
		
		Stack<String> stack = new Stack<String>();
		double result = 0;
		
		int i = 0;
		
		while(i < array.length){
			if(StrManip.isNumber(array[i])){
				stack.push(array[i]);
			}else if(StrManip.is1ArgFunction(array[i])){
				try{
					String operand = stack.pop();
					double curResult = 6.0;
					stack.push(""+curResult);
					result = curResult;
				}catch(Exception e){
					System.out.println("something wrong with function processing");
					throw e;
				}
			}
			else{
				try{
					double curResult = operatorMap.get(array[i]).operate(stack);
					
					stack.push(""+curResult);
					result = curResult;
					
				}catch(EmptyStackException e){
					System.out.println("something wrong with equation");
					throw e;
				}
			}
			
			i++;
		}
		
		return result;
	}	
	
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		String eq = "";
		
		while(!eq.equals("exit")){
			eq = keyboard.nextLine();
			testFunction(eq);
			
			//System.out.println(StrManip.insertWhiteSpaces(eq));
			
			
			
			System.out.println(" = " + calculate(eq));
			//testFunction(eq);
			
			//System.out.println(StrManip.insertWhiteSpaces(eq));
			
			
		}
	}
	
	// using this function to print out different things and test functions
	// helpful for keeping the main function clean
	// we can delete this once we're done
	public static void testFunction(String eq){
		eq = StrManip.insertWhiteSpaces(eq);
		eq = StrManip.insertMultiplication(eq);
		
		String[] array = infixToPostfix(eq);
		
		for(String s: array){
			System.out.print(s + " ");
		}
		System.out.println();	
		//System.out.println(calculate(eq));
	}
	
}
