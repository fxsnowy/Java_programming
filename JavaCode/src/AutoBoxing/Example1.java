package AutoBoxing;

/*
 * Wrapper classes for primitives:
 * 
 * 1) Primitive values are not objects in java(for performance reasons).
 * 
 * 2) To treat primitives as objects use these classes:
 *         Boolean, Byte, Short, Character, Integer, Float, Long, Double
 * 
 * 3) Boolean and Character subclass Object, the rest subclass java.lang.Number
 */

public class Example1 {

	public static void main(String[] args) {
		Integer i = 8, j = --i;   // For 'i = 8', 8 is boxed before assignment.
								  // For 'j = --i', i is unboxed, decremented and then boxed before assignment.
		Integer k = i + j;		  // i and j are unboxed, added, giving 15 to box.
		int l = i + j;			  // unboxed, added, giving 15 to l.
		boolean b = (k == l);	  // k is unboxed because 'l' is primitive and then values are compared, so b is true.
		
		
	}

}
