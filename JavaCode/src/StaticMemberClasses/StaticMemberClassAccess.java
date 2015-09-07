package StaticMemberClasses;


/*
 * To instantiate a static member class use its full name. No instance of 
 * the enclosing class is required and therefore only static members of
 * the enclosing class can be directly accessed.
 * 
 * Like methods it can access private members of the enclosing class and 
 * the enclosing class can access private members of the static member
 * class.
 * 
 * 
 * 
 * 
 */

class Top{
	public int i=9;
	public static int k = 43;
	private static int j=42;
	public void n(){ }
	private static void m() { }
	static class Nest1{
		interface I{ }
		static int a;
		int b;
		void test(Top t){
			b=j; //j is outer class member
			a = t.i;
			m(); // m is outer class member
			t.n();
			//int b = i; n(); //Instance methods and fields are accessible thru objects 
		}
	}
	private static abstract class Nest2 implements Nest1.I{
		
	}
}


class A{
	private static  I ii;
	private interface I{ // static member interface can be private
		void f();
	}
	
	static class B implements I{
		@Override
		public void f() { 	}
	}
	
	static class C implements I{
		@Override
		public void f() { 	}
	}
	
	static void m(I x){
		ii = x;
	}
	
	
}

public class StaticMemberClassAccess extends Top.Nest1 implements Top.Nest1.I{
	//Top.Nest2 tn2; // Compiler error; Nest2 is private
	Top.Nest1 tn1 = new Top.Nest1();
	Top.Nest1.I inf;
	public static void main(String[] args) {
		StaticMemberClassAccess t = new StaticMemberClassAccess();
		t.inf = t;
		Top tp = null;
		System.out.println(tp.k); // Compiler replaces 'tp' with class name 'Top'
		int x = (new Top()).k;
		
		
		A.B ab = new A.B();
		A.m(ab);
		//A.I ai = ab; //The compiler knows B implements I but it has no way of referring to I outside A.
	}
}


/*
 * Compiler output files:
 * 		Top.class
 *      Top$Nest1.class
 *      Top$Nest2.class
 *      Top$Nest1$I.class
 *      StaticMemberClassAccess.class
 *      
 *      
 */