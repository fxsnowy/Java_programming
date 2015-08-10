package ClassesOverridingHidingAccess;

import java.io.*;


/*
 * 1) A throws clause in an overriding/hiding/implementing method 
 * cannot specify a (checked) exception in its throws clause not
 * covered by the overridden method. 
 * 
 * 2) In other words, overriding method must throw a narrower (or the
 * same) range of (checked) exceptions.
 * Example: open() method below.
 * 
 */

class A{
	void open() throws FileNotFoundException {
		
	}
}


class E extends A{
	void open() /* throws IOException - compiler error */{ 
		
	}
}

public class OverridingAndExceptions {

	public static void main(String[] args) {
		

	}

}
