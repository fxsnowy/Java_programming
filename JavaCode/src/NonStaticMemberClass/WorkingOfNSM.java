package NonStaticMemberClass;

/*
 * Joshua Bloch's answer is in Effective Java read, 
 * item 22 : Favour static member classes over non static
 * 
 * Any instance of the non-static member class MUST be associated with 
 * an instance of the enclosing class.
 * 
 * An instance of the enclosing class does not have to be associated 
 * with an instance of the inner class i.e., it is not forced to create
 * one.
 * 
 * When you introduce a NSMC, you are not allowed to declare any interface
 * not allowed to have any static methods, not allowed to have any static
 * initializers, not allowed to have any static fields with the exception 
 * of compile time constants.
 * 
 * Compile time constants have to be primitives or Strings.
 * 
 * NSM classes may however inherit static methods and static fields.
 * 
 * NSM classes can implement interfaces.
 * 
 * NSM classes can access all fields and methods from enclosing classes( not
 * just statics), including private methods and fields.
 * 
 * NSM classes can have any accessibility, private/public/default or protected.
 * 
 * 
 * 
 */

class Outr{
	int a;
	class In1{
		//private static final int illegal;   // Compiler error
		private static final int OK = 2;      // OK this is a compile time constant
		//private static final void() { }     // Compiler error.
	}
}

public class WorkingOfNSM {

}
