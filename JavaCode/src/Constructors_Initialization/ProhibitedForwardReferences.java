package Constructors_Initialization;


/*
 * 1) This applies to instance initializer blocks and instance field
 * initializers. First methods and constructors may have any sort of 
 * forward references.
 * 
 * 2) Static variables are initialized before instance variables, any
 * sort of reference to a static variable is allowed. 
 * 
 * 3) What is prohibited is any forward reference to an instance field
 * using a simple name on the RHS of an assignment.
 * 
 *  
 */


class C{
	{
		x = 90;             //OK (not on the RHS of '=')
		y = x = 99;         //OK (x i not being read here)
		//y = x + 2;        //Error forward reference
		//y = y + 1;		//Error forward reference
		y = z;				//OK  ( z is static this is instance initialization)
		//y = m(x);			//Error x is forward ref on RHS of '='
		y = m(this.x);		//OK. this.x is not a simple name (super.field is also OK)
		y = p();			//OK methods have forward reference.
	}
	
	C() { y = z;}   //OK  constructirs may have forward reference
	int m(int i){ return 77; }  //OK
	int p(){return x;}          //OK
	int x, y;
	static int z;
}


public class ProhibitedForwardReferences {

	public static void main(String[] args) {
		

	}

}
