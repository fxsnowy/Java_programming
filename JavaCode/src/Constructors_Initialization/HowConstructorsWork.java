package Constructors_Initialization;


class SuperE{
	int val;
	SuperE(){
		m();
	}
	void m(){
		val = 123;
		System.out.println("In SuperE val = " + val);
	}
}


class E extends SuperE{
	int x = 99;
	E(){
		m();
		super.m();
	}
	void m(){
		System.out.println("In E val = "+val+"x= "+x);
	}
	public static void main(String[] args){
		new E();
	}
}


public class HowConstructorsWork {

	public static void main(String[] args) {
		

	}

}

/*
 * Output:
 * In E val = 0 x = 0
 * In E val = 0 x = 99
 * In SuperE val = 123
 */