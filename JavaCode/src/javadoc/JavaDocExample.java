package javadoc;

/*
 * Javadoc is a tool that generates html documentation (similar to the reference
 * pages at java.sun.com) from Javadoc comments in the code. 
 *
 * Javadoc tags are documentation level artifacts and are meta-data for 
 * the javadoc processor.
 *
 * Both annotations and Javadoc tags provide metadata about code elements.
 */

/* 
 * Javadoc comments 
 */
// Javadoc recognizes special comments /** .... */  which are highlighted blue by default in Eclipse
// (regular comments // and /* ... */ are highlighted green).
/* Javadoc allows you to attach descriptions to classes, constructors, fields, interfaces and methods
 * in the generated html documentation by placing Javadoc comments directly before their declaration 
 * statements. For example:
 * 
 */ 

/** Class Description of MyClass
 * 
 */
class MyClass {
	
	/** Field Description of myIntField */
	public int myIntField;

	/** Constructor Description of MyClass() */
	public MyClass() {
		// Do something ...
	}
}

/*
 * Javadoc tags: 
 * 
 * 1) Javadoc tags are documentation level artifacts and are
 * meta-data for the javadoc processor. 
 * 
 * 2) Tags are keywords recognized by Javadoc which define the type of 
 * information that follows. 
 * 
 * 3) Tags come after the description (separated by a new line). 
 * 
 * 4) Here are some common pre-defined tags:
 * 
 * @author [author name] - identifies author(s) of a class or interface.
 * 
 * @version [version] - version info of a class or interface.
 * 
 * @param [argument name] [argument description] - describes an argument of
 * method or constructor.
 * 
 * @return [description of return] - describes data returned by method
 * (unnecessary for constructors and void methods).
 * 
 * @exception [exception thrown] [exception description] - describes exception
 * thrown by method.
 * 
 * @throws [exception thrown] [exception description] - same as @exception.
 */



/**
 * Description of JavaDocExample
 *
 * @author Sham
 * @author Sham
 * @version 6.0z Build 9000 Jan 3, 1970.
 */

public class JavaDocExample {
	/** Description of myIntField */
	public int myIntField;

	/**
	 * Description of JavaDocExample()
	 * 
	 * @throws MyException      Description of myException
	 */
	public JavaDocExample() throws myException {
		// whatever
	}

	/**
	 * Description of myMethod(int a, String b)
	 * 
	 * @param a          Description of a
	 * @param b          Description of b
	 * @return           Description of c
	 */
	public Object myMethod(int a, String b) {
		Object c = null;
		// Blah Blah Blah...
		return c;
	}

}

class myException extends Exception{}