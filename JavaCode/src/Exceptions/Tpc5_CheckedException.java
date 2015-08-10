package Exceptions;

/*
 * 1) 'Effective java' says that, to use checked exceptions for all errors
 * the application can recover from, and unchecked exceptions for the errors
 * the application cannot recover from.
 * 
 * 2) In reality most applications will have to recover from pretty much all
 * exceptions including NullPointerException, IllegalArgumentExceptions and
 * many other unchecked exceptions.
 * 
 * 3) The action / transaction that failed will be aborted but the application
 * has to stay alive and be ready to serve the next action / transaction. 
 * The only time it is normally legal to shut down an application is during startup.
 * 
 * For instance, if a configuration file is missing and the application cannot
 * do anything sensible without it, then it is legal to shut down the application.
 * 
 * 
 * 
 * 
 * 
 */

class BadUrlException extends Exception {
	public BadUrlException(String s) {
		super(s);
	}
}



/*
 * 4) Difference in syntax between checked and unchecked exceptions
 */

public class Tpc5_CheckedException {
	public void storeDataFromUrl(String url) {
		try {
			String data = readDataFromUrl(url);
		} catch (BadUrlException e) {
			e.printStackTrace();
		}
	}

	public String readDataFromUrl(String url) throws BadUrlException {
		if (isUrlBad(url)) {
			throw new BadUrlException("Bad URL: " + url);
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
