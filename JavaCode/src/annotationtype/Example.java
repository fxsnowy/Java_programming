package annotationtype;

import java.lang.reflect.Method;

/*
 * 1) Annotation is about enhancing the compiler. 
 * 2) Annotations that come with javac are called built-in or meta anotations.
 * 3) annotation processors for built-in annotation are part of javac, but not part of jdk.
 * 4) annotation provide a mechanism that allows programmers to write metadata about their 
 * code directly in the code itself.
 * 5) Before annotations, the way programmers were describing their code. using transient
 * keywords, via comments, with interfaces, etc. This was not a good approach.
 *  
 *  
 */
class Super{
	static{
		System.out.println("In Super");
	}
	public void superMethod(){
		
	}
}

class Sub extends Super{
	static{
		System.out.println("In Sub");
	}
	public void subMethod(){
		
	}
}

public class Example {
	static{
		System.out.println("In Example");
	}
	public static void main(String[] args){
		
		Class myClass = Sub.class;
		Method[] methods = myClass.getMethods();
		for(Method eachMethod :  methods){
			System.out.println(eachMethod.getName() + " with " + eachMethod.getParameterCount() + " parameters");
		}
	}
}

