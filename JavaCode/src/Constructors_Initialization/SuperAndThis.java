package Constructors_Initialization;

/*
 * super and this as a call
 * 
 * 1) super(parameterList) is a call to the constructor of the direct 
 * superclass.
 * 
 * 2) this(parameterList) is a call to a constructor within the class.
 * 
 * 3) The first statement of any constructor must be 'this(parameterList)'
 * or 'super(parameterList)'. You cannot use 'this(parameterList)' or 
 * 'super(parameterList)' anywhere else except as a first statement of a 
 * constructor.
 * 
 * 4) If you don't put a 'this(parameterList)' or 'super(parameterList)' 
 * call in as the first statement the compiler will insert 'super()' as 
 * the first statement.
 * 
 * 5) There is no access to instance methods or fields until after 
 * 'super(parameterList)' has run. That means you may only use static 
 * methods and fields, or constructor arguments in any expressions passed
 * as parameters to 'this(parameterList)' or 'super(parameterList)'.
 *  
 * 
 */

/*
 * class A{
 * 		// compiler does not insert constructor A() here
 * 		A(int i){  }
 * }
 * 
 * class C extends A{
 * 		static int w; int i;
 * 		
 * 		C(){
 * 			this(42);
 * 		}
 * 
 * 		C(int i){
 * 			//**** Error: Compiler inserts super() here
 * 			There's no A() so error.
 * 			
 * 			this.i = i;
 * 		}
 * 
 * 		C(int j, int k){
 * 			super(i);
 * 			//****Error is an instance field. Instance fields and methods
 * 			can only be used after the return from super()
 * 		}
 * 		
 * 		C(long i){
 * 			//****Error: Compiler inserts super() as first statement. 
 * 			if((int)i > 23)
 * 				super(w); // ***Compile time error: Super must be the first statement
 * 			else	
 * 				super((int)i);
 * 		}
 * }
 * 
 * class B extends A{
 * 		//There are no constructors therefore the compiler inserts:
 * 		B(){
 * 			super();
 * 		}
 * 		//***** There is no A() so error.
 * }
 * 
 * class W {
 * 		W(){
 * 			this("help");
 * 		}
 * 
 * 		W(String s){
 * 			this(); //***Error recursive constructor call.
 * 		}
 * }
 * 
 * 
 * 
 * 
 * 
 */

public class SuperAndThis {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
