package Exceptions;

/*
 * Below is a list of the most common arguments for and against 
 * checked and unchecked exceptions.
 * 
 * 1. Pro Checked Exceptions:
 * Compiler enforced catching or propagation of checked exceptions
 * make it harder to forget handling that exception.
 * 
 * 
 * 2. Pro Checked Exceptions:
 * Unchecked exceptions makes it easier to forget handling errors 
 * since the compiler doesn't force the developer to catch or 
 * propagate exceptions (reverse of 1).
 * 
 * 
 *  
 * 
 * 3. Pro Unchecked Exceptions:
 * Checked exceptions that are propagated up the call stack clutter
 * the top level methods, because these methods need to declare 
 * throwing all exceptions thrown from methods they call.
 * 
 * 4. Pro Checked Exceptions:
 * When methods do not declare what unchecked exceptions they may 
 * throw it becomes more difficult to handle them.
 * 
 * 5. Pro Unchecked Exceptions:
 * Checked exceptions thrown become part of a methods interface 
 * and makes it harder to add or remove exceptions from the method 
 * in later versions of the class or interface.
 * 
 * Summary:
 * a) Unchecked exceptions do not clutter the code with unnecessary try-catch blocks.
 * b) Unchecked exceptions do not clutter the method declarations with aggregated exception declarations.
 * c) The argument that you easier forget to handle unchecked exceptions is not valid in my experience.
 * d) The argument that it is harder to know how to handle undeclared exceptions is not valid in my experience.
 * e) Unchecked exceptions avoids versioning problems altogether.
 *
 * 
 */

class BadUrlException1 extends RuntimeException {
	public BadUrlException1(String s) {
		super(s);
	}
}

/*
 * 2) Difference in syntax between checked and unchecked exceptions
 */
public class Tpc6_UncheckedException {

	

	public void storeDataFromUrl(String url) {
		/*try {
			String data = readDataFromUrl(url);
		} catch (BadUrlException1 e) {
			e.printStackTrace();
		}*/
		String data = readDataFromUrl(url);
	}

	public String readDataFromUrl(String url) /* throws BadUrlException */  { 
		if (isUrlBad(url)) {
			throw new BadUrlException1("Bad URL: " + url);
		}

		String data = null;
		// read lots of data over HTTP and return
		// it as a String instance.

		return data;
	}

	private boolean isUrlBad(String url) {
		return true;
	}

	public static void main(String[] args) {
		

	}

}
