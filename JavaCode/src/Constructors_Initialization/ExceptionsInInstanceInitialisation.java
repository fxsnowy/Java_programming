package Constructors_Initialization;


/*
 * 1. If an instance initialiser can throw an exception then that 
 * exception must be declared in the throws clause of every constructor.
 * This is because the initialisation code is inserted after every call
 * to 'super' in the constructor.
 * 
 * 2. That exception can't be caught because constructors must start with 
 * 'super'  or 'this' but not 'try'.
 * 
 * 3. If a constructor starts with 'super', keep following the chain, every
 * constructor in that chain will have to have a throws clause  with that
 * exception.
 * 
 * 
 */

class MyEx1 extends Exception {}
class MyEx2 extends Exception {}

class D{
	int i = m();
	{
		if(i > 10){
			throw new MyEx1();
		}
	}
	int m() throws MyEx2{
		return 42;
	}
	D() throws MyEx1, MyEx2{
		
	}
}

class SubD1 extends D{
	int x, y;
	SubD1() throws MyEx1, MyEx2{
		this(0, 0);
	}
	SubD1(int x, int y) throws MyEx1, MyEx2{ /*<=============== The compiler inserted call super()
	 															is effectively D() which can throw 
	 															MyEx1 & MyEx2 so they must be
	 															declared here*/ 
		this.x = x;
		this.y = y;
	}
}


/*class SubD2 extends D{
	 //
	 // The default, compiler generated constructor
	 // does not have a throws clause so you will get
	 // an error here. 
	 //
}*/


public class ExceptionsInInstanceInitialisation {

	public static void main(String[] args) {
		

	}

}
