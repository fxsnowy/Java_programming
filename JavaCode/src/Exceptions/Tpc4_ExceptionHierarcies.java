package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Tpc4_ExceptionHierarcies {

	public static void main(String[] args) {
		/*
		 * 1) Multiple Catch Blocks
		 * 
		 * As you may know already it is possible to have several catch blocks
		 * for the same try-block. This is usually the case if the code inside
		 * the try-block throws more than one type of exception. But, multiple
		 * catch blocks can also be used in the case where all the exceptions
		 * thrown inside the try-block are the same type or subclasses of that
		 * type.
		 * 
		 * 2) Remember that the first catch-block a thrown exception matches 
		 * will handle that exception. In this example all IOExceptions are
		 * being handled by the catch(IOException e) except for FileNotFoundException.
		 * 
		 */

		try {
			// call some methods that throw IOException's
			byte a = 2, b = 3;
			if (a > 2) {
				throw new FileNotFoundException();
			} else if (b > 0) {
				throw new IOException();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		
		

	}
	
	/*
	 * 2) Throws Clauses
	 * 
	 * If a method can throw either a certain exception A, or
	 * any subclasses of A (Asub), then it is enough to declare in the method
	 * declaration that the method throws A. It is then allowed to throw
	 * subclasses of A from the method too.
	 * 
	 */
	
	public void doSomething() throws IOException, FileNotFoundException{
	}
	

	/*
	 * 
	 * 3) Designing Exception Hierarchies
	 * 
	 * When designing exception hieararchies for an API or application it 
	 * is a good idea to create a base exception for that API or application.
	 * For instance, in Mr. Persister, our Java Persistence / ORM API the base
	 * exception is called PersistenceException. This base exception makes 
	 * it possible to catch and handle all exceptions thrown by Mr. Persister
	 * in the same catch block.
	 * 
	 * 
	 * If you need more granularity on the exceptions thrown, for instance 
	 * because you think the exceptions may be handled differently, then add
	 * new exceptions as subclasses of your API or application base exception. 
	 * That way users have the choice of either catching the specific exceptions,
	 * or just the base exception.
	 * 
	 */

}