package ClassesOverridingHidingAccess;

/*
 * 1) Top level classes can be public or package-private.
 * They cannot be protected or private.
 * 
 * 2) The ability to access an entity is determined by the compiler 
 * at compile time not at runtime.
 * 
 * 3) Accessibility is determined at compile time.
 *
 *
 * 4) Private field or method:
 * That means a subclass could use the same method name and it wouldn't
 * override because the method in the class doesn't exist as far as the
 * subclass is concerned.
 * 
 * 
 */

/*
 * 5) Default method: 
 * Let 'C' be the class of 'objectref'. The actual method to be invoked is
 * selected by the following lookup procedure:
 * 
 * If C contains a declaration for an instance method with the same name 
 * and descriptor as the resolved method, then it is the method to be invoked.
 * 
 * Otherwise, if C has a superclass, a search for a declaration of an instance
 * method with the same name and descriptor as the resolved method is performed,
 * starting with the direct superclass of C and continuing with the direct 
 * superclass of that class, and so forth, until a match is found or no further
 * super classes exist. If a match is found, then it is the method to be invoked.
 *
 */
class Super{
	int i;
	protected void method(){
		
	}
}
class Sub extends Super{
	 int i;
	public void f(){
		method(); // follows rule 5 shown above
	}
}



/*
 * 6) An overriding/hiding method must not be more restrictive.
 * If access was more restrictive some code might be able to access
 * the superclass object but not its subclass object.
 * 		class A{
 * 			public void m1(){
 * 			}
 * 		}
 * 
 * 		class B extends A{
 * 			void m1(){ //not possible
 * 			}
 * 
 * 		class C{	//different package
 * 			void test(A ab){
 * 				ab.m1();	// this will not work for above code.
 * 			}
 * 
 * 
 */


public class AcessQualifiers {

	public static void main(String[] args) {
		

	}

}
