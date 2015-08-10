package primitivetypes_ex1;

public class Lesson1 {
	
	public static void main(String[] args) {
		
		/*
		 * Primitive types:
		 * 1) The designers of Java decided to retain primitive types in an object 
		 * oriented language, instead of making everything an object, so as to 
		 * improve the performance of the language.
		 * 
		 * 2) Primitives are stored in the call stack, unlike objects are stored in
		 * heap.
		 * 
		 */
		/*Integral types  */
		byte bigByte = 127; // 8 bits; -128 to 127
		
		short bigShort = 32767; // 16 bits; -32768 to 32767
		
		int bigInt = 2100000000; // 32 bits; -2147483648  to +2147483647
		int  integerThree = 234987; //no L suffix, so this is int
		int integerFour = 02345; // an int written in octal
		int integerFive = 0xF34aA2; //an int written in hex 
		
		long longIntegerOne = 788665L; //Java is case sensitive except for writing numeric literals(l or L)
		long bigLong = 9220000000000000000L; // 64 bits; -9223372036854775808 to +9223372036854775807
		long longIntegerTwo = 01770L; // a long written in octal
		long longIntegerThree = 0x7885545L; //a long written in hex
		
		char ch1 = '\u0041'; // 16 bits; '\u0000' (= 0)  to '\uFFFF' (= 65535) BMP plane
		char ch2 = '\b';
		char ch3 = '\n';
		char ch4 = '\r';
		char ch5 = '\\'; // '\"' - 	double quote
		char ch6 = '\101'; // \octalnumber where octalnumber is between 0 and 377 i.e. 0 to
		//255 and therefore represents an 8859-1 character.
		char ch7 = '\u0001'; //escape sequences like \r \n can't be represented using unicodeEscape
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		System.out.println(ch7);
		
		
		/* Floating point types */
		float floatVarOne = -50E-1f; //32 bits; -50 x 10^-1; decimal FP literal
		double doubleVarOne = -0.05E+2d; //64 bits; -0.05 X 10^2; suffix is optional
		System.out.println(floatVarOne);
		System.out.println(doubleVarOne);
		
		float floatVarTwo = -0X05P+2f; // 32bits; -5 x 2^2; hexadecimal FP literal 
		System.out.println(floatVarTwo);
		
		/* Boolean type */
		
		boolean truthValue = true; //boolean in java is not integral type; size(bits) unspecified.
		System.out.println(truthValue);
		
		
		
	}

}
