package ClassesOverridingHidingAccess;

/*
 * 1) Over-riding basically supports late binding. Therefore, which
 * method will be called is decided at run time.It is for non-static
 * methods. Hiding is for all other members (static methods , instance
 * members, static members). It is based on the early binding . More
 * clearly , the method or member to be called or used is decided 
 * during compile time.
 * 
 * 2) Method names must match.
 * 
 * 3) Argument types must match, with array form and variable arity form 
 * considered equal.(argument names of course can differ).
 * 
 * 4) Any throws clause in the over riding method must not throw an exception
 * not covered by the overridden method's clause. (this only applies to checked
 * exceptions).
 * 
 * 5) If you override a method returning a primitive type( or void) then you must
 * return exactly the same type. Otherwise you may return a subtype in the 
 * overriding method.
 * 
 * 6) An overriding method must have same or wider access.
 * 
 * 7) There's nothing wrong with an abstract method( in an abstract class)
 * overriding a concrete method
 * 
 * 
 */
public class OverridingHidingRules {

	public static void main(String[] args) {
		

	}

}
