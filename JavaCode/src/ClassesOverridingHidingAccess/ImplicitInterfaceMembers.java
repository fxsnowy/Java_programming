package ClassesOverridingHidingAccess;


/*
 * 1) If an interface has no direct super interfaces, then the
 * interface implicitly declares a public abstract member method m
 * with signature s, return type r, and throws clause t corresponding
 * to each public instance method m with signature s, return type r,
 * and throws clause t declared in Object, unless a method with the
 * same signature, same return type, and a compatible throws clause
 * is explicitly declared by the interface. It is a compile-time error
 * if the interface explicitly declares such a method m in the case 
 * where m is declared to be final in Object.
 * 
 */

class E11 extends java.io.IOException{ }

abstract class E22 extends E11 { }

interface I16 { 
	void m2();
	/*
	 * 2) hashcode() is in `Object` so it's in I2 implicitly, so this is an
	 * attempt to override it, but it gives a compiler error because there's
	 * no throws clause for this in `Object`.
	 *   
	 */
	//int hashCode() throws E1, E2; //compiler error
}


public class ImplicitInterfaceMembers {

	public static void main(String[] args) {
		

	}

}
