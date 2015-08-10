package ClassesOverridingHidingAccess;

/*
 * 1) Interfaces and abstract classes can declare methods which throw 
 * exceptions.
 * 
 * 2) It's quite common for an abstract method to throw quite broad exceptions,
 * expecting that implementing classes will be more specific.
 * 
 * 3) When an interface extends other interfaces, a method may 'override' one
 * or more methods in different super interfaces.
 * 
 * 4) Throws clauses have to be compatible whenever a method is overridden or
 * implemented.
 * Below is an example
 */

/*
 * 5) If the return type of a method is not primitive or void an overriding
 * method doesn't have to return exactly the same type. 
 * It is said that the overriding method has a 'covariant' return type.
 * 
 * 6) Covariant return type of a method is one that can be replaced by a
 * "narrower" type when the method is overridden in a subclass.
 *	Below is an example: 
 */

class E1 extends java.io.IOException{ }
abstract class E2 extends E1{ }
interface I11{
	I11 m1() throws java.io.IOException;
}
interface I9 extends I11{ }
interface I12 {
	I9 m() throws java.io.IOException, E1;
}
interface I13 extends I11, I12, I9{
	I13 m() throws E2;
}

/*
 * 1) In the above code, compiler will check the return type of 'm()'
 * in 'interface I13' as follows:
 * 		a) Whether I13 return type is subtype of I9 return type.
 * 		b) Whether I13 is subtype of I11 return type.
 * 
 * 2) In the above code, compiler will check the throws clause of 'm()'
 * in 'interface I13' as follows:
 * 		a) whether E2 is substype of E1 or java.io.IOException
 * 		
 * 		
 */

public class InterfaceAbstractExceptions {

	public static void main(String[] args) {
		

	}

}
