package javastring_ex4;

import java.util.Locale;

public class Lesson4 {

	public static void main(String[] args) {
		/*
		 * class String
		 * 
		 * 1) A Java String contains an immutable sequence of Unicode characters.
		 * String is a class in package java.lang
		 * 
		 * 2) object of type String can be created by asigning a String literal or
		 * calling the constructor.
		 * 
		 * 3) Java does not allow user level operator overloading. But '+' is the
		 * only operator overloaded to concatenate two strings of type String/StringBuffer/
		 * StringBuilder apart from performing addition on primitives(int and double).
		 * 
		 * 4) objects of type String are immutable. objects of type StringBuffer/
		 * StringBuilder are mutable.
		 * 
		 * 
		 */
		
		String s1 = "Hello \"I'm here\""; //object of type String kept in common pool
		String s2 = "Hello \"I'm here\""; //Share same storage in common pool
		String s3 = s1;
		String s4 = new String("Hello \"I'm here\""); // object of type String kept in heap
		String s5 = new String("Hello \"I'm here\""); // no sharing of storage in heap
		
		boolean result = (s1 == s2); //true; s1 and s2 share same storage
		result = (s1 == s3); // true; s1 and s3 share same storage
		result = (s1.equals(s3)); //true; same contents
		result = (s1 == s4); // false; different storage
		result = s1.equals(s4); //true; same content
		result = (s4 == s5); // false; different storage
		result = s4.equals(s5); // true; same content

		
		/*
		 * Primitive type to String type
		 */
		String byteString = Byte.toString((byte)100);
		String shortString = Short.toString((short)100);
		String intString = Integer.toString(100);
		String longString = Long.toString(100L);
		String floatString = Float.toString(100f);
		String doubleString = Double.toString(100);
		String booleanString = Boolean.toString(true);
		
		System.out.println(intString);
		
		/*
		 * String to primitive type
		 */
		byte stringToByte = Byte.parseByte(byteString);
		short stringToShort = Short.parseShort(shortString);
		int stringToInt = Integer.parseInt(intString);
		long stringToLong = Long.parseLong(longString);
		float stringToFloat = Float.parseFloat(floatString);
		double stringToDouble = Double.parseDouble(doubleString);
		boolean stringToBoolean = Boolean.parseBoolean(booleanString);
		
		System.out.println(stringToByte);
		System.out.println(stringToShort);
		System.out.println(stringToInt);
		
		/*
		 * String concatenation operator +
		 */
		String completeString = "firsthalf" + "secondhalf";
		String mixedTypeString = 1 + 2 + "strings";
		System.out.println(mixedTypeString);
		
		
		
		
		/*
		 * Supported methods on objects of type String
		 */
		String uppercaseStr = "BIG";
		String lowercaseStr = "big";
		if(uppercaseStr.equals(lowercaseStr)){
			System.out.println("both are equal - case sensitive");
		}else if (uppercaseStr.equalsIgnoreCase(lowercaseStr)){
			System.out.println("both are equal - case insensitive");
		}
		
		String letters = "abcdecd"; // index 0 is a, index 1 is b
		String moreLetters = "fghijk";
		System.out.println("2nd char: " + letters.charAt(1));

		//Compare two strings lexicographically.If two strings are different,
		//then either they have different characters at some index that is a
		//valid index for both strings, or their lengths are different, or both.
		//If they have different characters at one or more index positions, let
		//k be the smallest such index; then the string whose character at 
		//position k has the smaller value, as determined by using the < operator,
		//lexicographically precedes the other string. In this case, compareTo 
		//returns the difference of the two character values at position k in the
		//two string -- that is, the value: 
		//	this.charAt(k)-anotherString.charAt(k)
		//If there is no index position at which they differ, then the shorter 
		//string lexicographically precedes the longer string. In this case, 
		//compareTo returns the difference of the lengths of the strings -- that is, 
		//the value: 
		//	this.length()-anotherString.length()
		System.out.println(letters.compareTo(moreLetters));// -5;  can be used for name orderings.
		
		System.out.println(letters.compareToIgnoreCase(moreLetters)); // -5
		
		System.out.println(letters.toCharArray()); // create char[] from this string
		
		char[] dst = new char[30];
		letters.getChars(0, letters.length()-1, dst, 0);//copy into dst char[]
		
		String.valueOf(dst); // type can be primitives or char[]; returns new string 
		
		System.out.println(String.format("%.1f", 1.234)); //returns String "1.2"
		
		System.out.printf("%.1f\n", 1.234); //simple formatted string to console
				
		System.out.println(letters.contains("abc")); // true
		
		System.out.println(letters.endsWith("de")); // true
		
		System.out.println(letters.startsWith("abcd")); //true
		
		System.out.println(letters.indexOf("cd")); // 2
		
		System.out.println(letters.indexOf("cd", 3));// -1; start searching from index 3
		
		System.out.println(letters.lastIndexOf("cd")); // 5; search starts from end of the string
		
		System.out.println(letters.length()); // number of characters in the string
		
		System.out.println(letters.replace("abc", "xy")); // xydecd
		
		System.out.println(letters.substring(1, 4)); // bcd
		
		System.out.println(letters.toUpperCase()); // ABCDECD
		
		System.out.println(letters.toLowerCase());
		
		System.out.println(letters.isEmpty());// false
		
		String randString = "         abdfg      ";
		System.out.println(randString.trim());//leading and trailing whitespace omitted
		
		String delimiter = "\\.";
		String str = "one\\two.three";
		String[] temp;
		temp = str.split(delimiter);
		for(String str1: temp){
			System.out.println(str1);
		}
		
		
		
		
		
		
		/*
		 * String formatting:
		 * 
		 * "% [argument index] [flag] [width] [.precision] type"
		 * 
		 * % is a special character denoting that a formatting instruction follows.
		 * 
		 * [argument index] 
		 * is a decimal integer indicating the position of the
		 * argument in the argument list. The first argument is referenced by "1$", 
		 * the second by "2$", etc.
		 *  
		 * [flag]
		 *  Flag	General		Character	Integral	FloatingPoint	Date/Time	Description
		 * '-'			y		y			y			y				y			The result will be left-justified.
		 * '#'			y1		-			y3			y				-			The result should use a conversion-dependent alternate form
		 * '+'			-		-			y4			y				-			The result will always include a sign
		 * ' '			-		-			y4			y				-			The result will include a leading space for positive values
		 * '0'			-		-			y			y				-			The result will be zero-padded
		 * ','			-		-			y2			y5				-			The result will include locale-specific grouping separators
		 * '('			-		-			y4			y5				-			The result will enclose negative numbers in parentheses
		 *
		 *
		 *
		 * 1 Depends on the definition of Formattible.
		 *
		 * 2 For 'd' conversion only.
		 *
		 * 3 For 'o', 'x', and 'X' conversions only.
		 *
		 * 4 For 'd', 'o', 'x', and 'X' conversions applied to BigInteger or 'd' applied to byte, Byte, short, Short, int and Integer, long, and Long.
		 *
		 * 5 For 'e', 'E', 'f', 'g', and 'G' conversions only.
		 *
		 * Any characters not explicitly defined as flags are illegal and are reserved for future extensions.
		 *	
		 *
		 *  
		 * 
		 * [width] 
		 * The width is the minimum number of characters to be written to the output. For
		 * the line separator conversion, width is not applicable; if it is provided, an
		 * exception will be thrown.
		 * 
		 * 
		 * [.precession]
		 * For general argument types, the precision is the maximum number of characters
		 * to be written to the output.
		 *
		 * For the floating-point conversions 'e', 'E', and 'f' the precision is the number
		 * of digits after the decimal separator. If the conversion is 'g' or 'G', then 
		 * the precision is the total number of digits in the resulting magnitude after
		 * rounding. If the conversion is 'a' or 'A', then the precision must not be 
		 * specified.
		 *
		 * For character, integral, and date/time argument types and the percent and line
		 * separator conversions, the precision is not applicable; if a precision is provided,
		 * an exception will be thrown.
		 *
		 * http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
		 * 
		 * 
		 */
		
		System.out.printf("Integer : %d\n",15);
		
		System.out.printf("Floating point number with 3 decimal digits: %.3f\n",1.21312939123);
		
		System.out.printf("Floating point number with 8 decimal digits: %.8f\n",1.21312939123);
		
		System.out.printf("String: %s, integer: %d, float: %.6f\n", "Hello World",89,9.231435);
		
		System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
		
		System.out.printf("%-12d%-12d%07d\n",15,12,5);
		
		System.out.printf("%-12.5s%s\n", "Hello World","Shamu");
		
		System.out.printf("%-12.5f%.20f\n", 12.23429837482,9.10212023134);
		
		String s = String.format("%-12.5f%.20f", 12.23429837482,9.10212023134);
		
		System.out.println(s);
		
		doubleString = String.format(Locale.GERMAN, "%,.2f", 2354548.235);
		
		System.out.println(doubleString);
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * class StringBuilder
		 * 
		 * 1) A mutable sequence of characters.
		 * 
		 * 2) This class provides an API compatible with StringBuffer, but with no guarantee
		 * of synchronisation. 
		 * 
		 * 3) This class is designed for use as a drop-in replacement for StringBuffer
		 * in places where the string buffer was being used by a single thread (as is 
		 * generally the case). Where possible, it is recommended that this class be
		 * used in preference to StringBuffer as it will be faster under most 
		 * implementations.
		 * 
		 * 4) StringBuilder object is just like any ordinary object, which are stored in 
		 * the heap.
		 *  
		 */
		StringBuilder randSB = new StringBuilder("A random value");
		System.out.println(randSB.append(" again"));
		
		System.out.println(randSB.delete(15, 17)); //chars at index 15 and 16 are removed.
		
		System.out.println(randSB.capacity()); // 30; returns the current capacity in memory
		
		randSB.ensureCapacity(60); //Ensures that the capacity is at least equal to the specified
		//minimum. If the current capacity is less than the argument, then a new internal array
		//is allocated with greater capacity. The new capacity is the larger of: 
		//		. The minimumCapacity argument. 
		//		. Twice the old capacity, plus 2. 
		
		
		randSB.trimToSize(); //Attempts to reduce storage used for the character sequence
		//equal to number of characters in the string.
		
		System.out.println(randSB.insert(1, "nother")); //inserts at index 1
		
		String oldSB = randSB.toString();// StringBuilder converts to String type
		
		//charAt() indexOf() lastIndexOf() subString() works exactly the same here.
		
		
		/*
		 * class StringBuffer
		 * 
		 * 1) A mutable sequence of characters.
		 * 
		 * 2) Objects of type StringBuffer are synchronised for multithread operations.
		 * 
		 * 3) Rule of Thumb: Strings are more efficient if they are not modified (because
		 * they are shared in the string common pool). However, if you have to modify the
		 * content of a string frequently (such as a status message), you should use the 
		 * StringBuffer class (or the StringBuilder described below) instead.
		 * 
		 *  
		 */
		StringBuffer rndSB = new StringBuffer("A random value");
		System.out.println(rndSB.append(" again"));
		
		System.out.println(rndSB.delete(15,  17)); //chars at index 15 and 16 are removed.
		
		System.out.println(rndSB.capacity()); // 30; returns the current capacity in memory
		
		rndSB.ensureCapacity(60); //Ensures that the capacity is at least equal to the specified
		//minimum. If the current capacity is less than the argument, then a new internal array
		//is allocated with greater capacity. The new capacity is the larger of: 
		//		. The minimumCapacity argument 
		//		. Twice the old capacity, plus 2 
		
		rndSB.trimToSize(); //Attempts to reduce storage used for the character sequence
		//equal to the number of characters in the string.
		
		System.out.println(rndSB.insert(1, "nother")); //inserts at index 1
		
		String obj = rndSB.toString(); //StringBuffer converts to String type
		
		//charAt() indexOf() lastIndexOf() subString() works exactly the same here.
		
		
		
		
		
	}
	
}