package typeconversion_ex3;

public class Lesson3 {
	public static void main(String[] args){
		/*
		 * Widening of primitive types
		 * 
		 * byte --> short -
		 * 					-
		 * 					  ---> int ---> long ---> float ---> double	
		 * 				  	-
		 * 			 char -
		 */
		byte b = 126;
		short s = 32767;
		char ch = 65534;
		int i = 210000000;
		long l = 2100000000000L;
		float f = 0.5f;
		double d = 0.5d; // suffix optional
		d = b;	//OK
		d = ch; //OK
		//s = ch; // Error possible loss of precision
		//ch = s; //Error possible loss of precision
		//b = i; //Error possible loss of precision
		f = i; //OK
		
		
		/*
		 * Implicit narrowing rules for primitive types
		 * General rule:
		 *  for <short | byte | char> = <int literal | char literal> Work out 
		 *  the RHS as a decimal value, does it fall in the range of the LHS?
		 * 
		 */
		
		b = 0xFFFFFFFF; //OK, because integer -1 sits between -128 to 127, Good!! 
		//b = 0L; // Compiler says Not OK? Weird rule.
		//ch = 0xFFFFFFFF; //Not OK, because -1 does not sit between 0 and 65535
		
		
		/*
		 * Casting rules for primitive types
		 */
		double aDoubleValue = 30000000000000000000.123438934;
		int doubleToInt = (int)aDoubleValue; //stores max value 2147483647
		byte doubleToByte = (byte)aDoubleValue;
		short doubleToShort = (short)aDoubleValue;
		long doubleToLong = (long)aDoubleValue;
		float doubleToFloat = (float)aDoubleValue;
		char doubleToChar = (char)aDoubleValue;
		System.out.println(doubleToByte); // stores -1, why?
		System.out.println(doubleToInt); // stores 2147483647, max value. 
		System.out.println(doubleToShort); // stores -1, why?
		System.out.println(doubleToLong); // stores 9223372036854775807, max value, make sense. 
		System.out.println(doubleToFloat); // stores 3.0E19, 3.0 x 10^19 is max value
		System.out.println("char: " + doubleToChar); //what does this store?
		
		
	}
}