package PublicMethInDefauClass.one;

public class A {
	public void m1(){
		System.out.println("In A");
	}
	
	public static A makeB(){
		return new B();
	}
}

class B extends A{
	
	public void m1(){
		System.out.println("In B");
	}
}



