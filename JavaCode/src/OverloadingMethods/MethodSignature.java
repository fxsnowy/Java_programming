package OverloadingMethods;

import java.io.IOException;

/*
 * 1) When you override a method you must not change the argument types
 * or their order. If you do change these you will simply get another 
 * method with the same name. This is called 'overloading'.
 * 
 * 2) A good method of an overloaded method is 'println'. To properly 
 * identify a method you need both the name and argument types.
 * 
 * 3) You can declare a method in one class and overload it in a subclass,
 * that just means the subclass has got two methods with the same name one
 * of which is inherited.
 * 
 * 4) Working out the overloaded method to call is done at compile time not
 * at run time. If one of these parameters is a reference it is NOT determined
 * by the type of the object referred to BUT the static type of reference.
 * 
 * 
 */

/*
 * Method Signature:
 * The signature of a method or constructor consists of its name and argument
 * types (in the order they are declared). It does include the return type.
 * It does not include any throws clause.
 * 
 * If two methods have the same signature (where the array form and variable
 * arity forms of argument are considered the same). they are called 
 * 'override-equivalent'.
 * 
 * It is a compiler error if a class or interface declares two override-equivalent
 * methods. 
 *  
 */

abstract class C{
	
	int m(char c) throws IOException { return 0; }
	//C   m(char c) {/* code */}                    // compiler error
	//protected abstract void m(char f);			// compiler error
	
	C(int i, Integer j){ /* code */}
	//C(int i, Integer k) throws IOException{ }		// compiler error
	C(int i, int j){ /* code */}					// OK
	
}

/*
 * All of the methods in C are override-equivalent, only one of the 
 * constructors is. Notice argument name, abstract, protected, return type
 * and throws plays no part in deciding if something is override-equivalent. 
 */

public class MethodSignature {

	public static void main(String[] args) {
		

	}

}
