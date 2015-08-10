package ClassesOverridingHidingAccess;

/*
 * 1) Constructors cannot be marked as abstract.
 * 
 * 2) Constructors are never inherited.
 * 
 * 3) Method signature constitutes argument types and the order of it.
 * Return type is not part of method signature.
 * 
 */
public class StaticMethod {

	private int i;
	/*
	 * 4) Static methods can only directly access static fields and methods,
	 * not instance fields or methods. Directly in the sense, object reference 
	 * can be passed to static methods as shown below.
	 * 
	 * 5) Static methods can't use 'this' or 'super'.
	 * 
	 * 6) Why static methods can't be abstract?
	 * Because which subclass does that static methods belong to, after sub classing.
	 *  
	 */
	public static void test(StaticMethod x){
		System.out.println(x.i); // this is possible
	}
	
	
	public static void main(String[] args) {
		StaticMethod x = new StaticMethod();
		test(x);
		X y = new X();
		y.abc();
	}

}

/*
 * Why interface inherits multiple interfaces? (as shown below)
 * 
 * You can inherit methods that are @Override-equivalent, subject to the usual
 * requirements of method overriding and hiding. Since they ARE @Override-equivalent,
 * effectively there is only one method to implement, and thus there's nothing 
 * to distinguish/select from.
 * 
 * The compiler does not have to identify which method is for which interface,
 * because once they are determined to be @Override-equivalent, they're the same method.
 * 
 * Resolving potential incompatibilities may be a tricky task, but that's another
 * issue altogether. Yes it is definitely the responsibility of the programmer to not
 * get into this situation
 * 
 * 
 */
interface I1{}
interface I3{
	int CONST_1 = 3;
	void abc();
}; 
interface I2{
	int CONST_1 = 2;
	void abc();
};
interface I4 extends I3, I1{
	
}

class X implements I4{
	@Override
	public void abc() {
		System.out.println(I2.CONST_1);
	}

}