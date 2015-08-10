package reflection;

import java.lang.reflect.Method;

/*
 * Before understanding reflection, one should understand the purpose of
 * constant pool http://stackoverflow.com/a/20357685/3317808  in JVM.
 * and about 'Class' instance http://stackoverflow.com/a/31206292/3317808
 * 
 * class life cycle has three of the many important phases-load/link/initialise.
 * 
 * a 'Class' instance describing the 'class Example' will create its
 * own constant pool when the class is loaded.
 * 
 * When another class contains a class literal of the form 'Example.class',
 * it will have it’s own Class entry for that class within its own constant pool.
 * 
 * The runtime evaluation of the class literal may trigger the loading and
 * hence creating of the Class instance when it has not been loaded before. 
 * 
 * 
 * 
 * 1) A class literal of the form 'type.class' look like a member access
 * in the source code but have nothing to do with real class members.
 * There is no member named 'class'.
 * 
 * 2) A class literal is more complicated. E.g. when you write 'int.class',
 * there is nothing to query. Instead, the compiler knows that it has to 
 * read the static field 'Integer.TYPE' to get the runtime value and that’s
 * how this class literal gets compiled, as a field access to 'Integer.TYPE'.
 * 
 * 3) A class literal of reference types are compiled using an 'ldc' 
 * instruction pointing to a constant pool entry which has nothing to do
 * with fields.
 * 
 * 
 *  
 * 
 */

class Super{
	static{
		System.out.println("In Super");
	}
}

class Sub{
	static{
		System.out.println("In Sub");
	}
	private void privMethod(){
		
	}
	public void pubMethod(){
		
	}
}


public class Example {
	public static void main(String[] args) {
		Class myClass = Sub.class;
		Method[] methods = myClass.getMethods();
		for(Method m: methods){
			System.out.println(m.getName());
		}
		
	}

}
