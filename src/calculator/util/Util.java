package calculator.util;

import java.text.DecimalFormat;

public class Util {

	/**
	 *  This function is to avoid rounding errors from floating point arithmetic
	 *  It works by adding 1 to n, rounding it to 15 places, then subtracting 1
	 *  This was primarily for trig functions like sin(180) giving weird values instead of 0
	 */
	public static double roundDouble(double n){
		return round15(n+1) - 1;
	}
	
	public static double round15(double x){
		DecimalFormat twoDForm = new DecimalFormat("0.##############E0");
		String str = twoDForm.format(x);
		return Double.valueOf(str);
	}	

}
