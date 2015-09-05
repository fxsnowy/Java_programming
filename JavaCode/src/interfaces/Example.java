package interfaces;


/*
 * 
 * Why interface?
 * 1) 'java.util.Collections' is container of all inner static class data models and algo.
 * Why would it sit under abstract class like 'AbstractList? So, this static impl has
 * to program on interfaces like 'List', 'Set'.
 * 2) If implementations like 'CopyOnWriteArrayList' are sitting in subpackg(java.util.concurrent),
 * then yes, 'CopyOnWriteArrayList' has to program on interface 'List'
 * 
 * 
 * From java 1.8, Syntactically, an interface is a reference type, 
 * that can contain abstract methods, default methods and static
 * methods. 
 * 
 * All abstract, default, and static methods in an interface are implicitly 
 * public, so you can omit the public modifier. interface fields are 
 * "public final"(by default)
 * 
 * In addition, an interface can contain constant declarations.
 * All constant values defined in an interface are implicitly
 * public, static and final. Constants can only be initialised
 * like, for example: int a = 2;
 * Static initialisers are not allowed in interface.
 * All methods declared in interface are implicitly public.
 * 
 * Interfaces always declare abstract methods corresponding to the 
 * public methods of <class Object>, but they usually do so implicitly.
 * 
 * Interfaces cannot be marked final.
 * 
 * 
 */

interface A{
	abstract void f();
	
	public void g(); //abstract method
	
	public default void h(){ //default method
		System.out.println("default method");
	}
	
	static void k(){ //static method
		System.out.println("static method");
	}
	
	int CONST_1 = 1; // an interface field is automatically "public final"

}

interface I{}

class C implements I{
	
}

public class Example {
	
	public static void main(String[] args) {
		//assignment between  classes and interface 
		C t1 = new C();
		I i = t1;
		t1 = (C)i;
		I i2 = null; //null is a valid value for reference types
		
		/*
		 * assignment for classes(with below hierarchy)
		 *                Object
		 *                /    \
		 *               /      \
		 *              A        B
		 *             / \      
		 *            /   \
		 *           C     T
		 *               / | \
		 *              /  |  \
		 *             X   Y   Z
		 *            / \
		 *           /   \
		 *          V     W
		 */
		//T t = new X();
		//A a = new X();
		//a = t;
		//t = a; // NO!!
		//t = (T)a // OK! Casting changes the static type of an expression not original variable.
	}
}