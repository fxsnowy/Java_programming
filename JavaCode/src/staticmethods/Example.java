package staticmethods;


class A{
	int x;
	void nonStatic(){
		x++;
	}
}


public class Example {
	A varA1 = new A();
	A varA2 = new A();
	
	/*
	 * nonStatic() can only be called, through an existing object(varA1 in
	 * this case). A pointer to that object is passed to nonStatic. This is 
	 * done by compiler. This is how, nonStatic knows, which object's 'x' to
	 * increment. That pointer is available to the programmer, it is called 
	 * 'this'.
	 */
	void testA(){
		varA1.nonStatic();
	}
	
	/*
	 * In the case of static methods no object pointer is passed. Execute static
	 * methods by calling 'ClassName.staticMethod(params)'
	 * 
	 * Below nonStatic() invocation fails, because member varA1 gets created only
	 * when object of type Example gets created. But static methods can be invoked,
	 * before object of type Example gets created. So, static methods give below error.
	 */
	public static void main(String[] args) {
		//varA1.nonStatic(); //Compile Error; cannot make a static reference to non-static field varA1 
	}
	
	static void testB(){
		//varA1.nonStatic(); //Compile Error; cannot make a static reference to non-static field varA1
	}

}
