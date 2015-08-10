package javaoperators_ex5;

public class Lesson5 {

	public static void main(String[] args) {
		/*
		 * Java shift operators
		 */
		
		int n = 10;
		int shiftLeftTwice = n << 2; // shift 2 places to the left.
		int shiftRightTwice = n >> 2; // shift 2 places to the right propagating the sign
		shiftRightTwice = n >>> 2; //shift 2 places to the right inserting zero in the msb.
		
		/*
		 * Java bitwise operators on integral types
		 */
		int a = ~2; // One's complement operator
		int b = 0xABCDEF98 & 0x000FF000; // result is 0x000DE000, Bitwise AND operator
		int c = 0xABCDEF98 ^ 0xFF000000; // result is 0x54CDEF98, flips the state, Exclusive OR operator	
		int d = 0xABCDEF98 | 0x03030303; // set the first two bits in every byte.
		
		/*
		 * Comparison operator on integral types
		 *
		 */
		boolean bool =  (3 >= 2); // bool holds the value true
		bool = (2 != 2); // bools holds false.
		bool = (2 == 2);
		
		/*
		 * Comparison operator on reference types
		 * Expression a == b compares the content of a and b, regardless of their types.
		 */
		String obj1 = "abc";
		String obj2 = "def";
		bool = (obj1 == obj2);  // For reference type, content is memory address, will compare "memory locations"
		
		/*
		 * Logical operators on boolean types
		 */
		boolean flip = !false;
		boolean result = true & false; //false
		result = true ^ false; // true
		result = true | false; // true
		
		/*
		 * Conditional operators on boolean types.
		 * These are exactly the same as the logical operators with & and |, with
		 * one important difference.
		 * 1) For &&: If the left operand is false the result is false and the right
		 * operand is not evaluated.
		 * 2) For ||: If the left operand is true then the right operand is not evaluated 
		 */
		bool = (2 > 50) && (1 == 1); // left operand is false
		bool = (2 < 50) || (1 == 1); //left operand is true
		
		
		/*
		 * Equality operators on boolean types
		 */
		boolean opr1 = false;
		boolean opr2 = false;
		result = (opr1 == opr2);
		result = (opr1 != opr2);

		
	}

}
