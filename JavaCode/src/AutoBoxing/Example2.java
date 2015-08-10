package AutoBoxing;

/*
 * When a wrapper type is initialized do you get a new object created?
 * Answer: It depends!!!!
 * 1) If you use a constructor then a new instance will be created.
 * 2) If you use boxing('Integer i = 127'), and the value being boxed is a 
 * boolean, byte, char in the range \u0000 to \u007f, int or short in the 
 * range -128 to 127 then there is a single object. Technical phrase is 'interned'
 * 
 * If '==' or '!= is used with two reference types, unboxing will not be done.
 * 
 * Wrapper classes for primitives are immutable.
 * 
 */
public class Example2 {

	public static void main(String[] args) {
		Integer i = 127, j = 127;
		Integer k = new Integer(127);
		System.out.println(i == j); // memory addresses are compared
		System.out.println(i == k); // memory addresses are compared

	}

}
