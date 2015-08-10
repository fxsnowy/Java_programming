package VariableArityMethod;

/*
 * 1) It is possible to declare a method that takes a variable number of parameters.
 * The method is said to have variable 'arity'  
 * 
 * 2) Only the last argument can have variable arity.
 * 
 * 3) All the variable parameters have to be of the same type (or a subtype of it).
 * 
 * 4) if the last argument in a method is an array, an overriding method can be
 * the equivalent variable arity type and vice verca. Though overriding a variable
 * arity argument with an array type argument is considered bad form.
 * 
 * 
 * 
 * 
 */
public class Example {

	/*
	 * 2) The method is said to have variable 'arity', if its done as follows:
	 * 
	 */
	static void test(int param1, int param2, int... param3){
		/* code */
	}
	
	/*
	 * 3) The above method 'test'  is translated by the compiler as:
	 * 		void test(int arg1, int arg2, int[] arg3){
	 * 			// code 
	 * 		}
	 * 
	 */
	
	
	public static void main(String[] args) {
	
		/*
		 * 4) A call to test might look like this
		 * 
		 */
		int i = 0, j= 1, k = 2, l = 3;
		test(i, j, k, l);

		/*
		 * 5) It would be translated by the compiler into:
		 *		test(i, j, new int[]{k, l}); 
		 */
		
	}

}
