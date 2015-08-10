package Exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * An important rule to remember is
 * 
 * The last exception thrown in a try-catch-finally block is the exception 
 * that will be propagated up the call stack. All earlier exceptions will disappear.
 * 
 *
 */
public class Tpc8_FailSafeExceptionHandling {
	
	
	public static void main(String[] args) throws WrapperException  {
		
		/*
		 * If an exception is thrown from inside a catch or finally block, 
		 * this exception may hide the exception caught by that block.
		 * This is misleading when trying to determine the cause of the error.
		 * 
		 * Below is a classic example of non-fail-safe exception handling:
		 * 
		 * If the FileInputStream constructor throws a FileNotFoundException, 
		 * what do you think will happen?
		 * 
		 * First the catch block is executed. This block just rethrows the
		 * exception wrapped in a WrapperException.
		 * 
		 * Second the finally block will be executed which closes the input 
		 * stream. However, since a FileNotFoundException was thrown by the
		 * FileInputStream constructor, the "input" reference will be null.
		 * The result will be a NullPointerException thrown from the finally
		 * block. The NullPointerException is not caught by the finally
		 * block's catch(IOException e) clause, so it is propagated up the
		 * call stack. The WrapperException thrown from the catch block will
		 * just disappear!
		 * 
		 *
		 */
		
		InputStream input = null;

		  try{

		    input = new FileInputStream("myFile.txt");

		    //do something with the stream

		  } catch(IOException e){
		    throw new WrapperException(e);
		  } finally {
		    try{
		     input.close();
		    } catch(IOException e){
		       throw new WrapperException(e);
		    }
		  }
		  
		  
	}
	
	/*
	 * The correct way to handle this situation is course to check if 
	 * references assigned inside the try block are null before invoking 
	 * any methods on them. Here is how that looks:
	 *
	 *
	 * But even this exception handling has a problem. Let's pretend the
	 * file exists, so the "input" reference now points to a valid 
	 * FileInputStream. Let's also pretend that an exception is thrown
	 * while processing the input stream. That exception is caught in 
	 * the catch(IOException e) block. It is then wrapped and rethrown.
	 * Before the wrapped exception is propagated up the call stack, 
	 * the finally clause is executed.	If the input.close() call fails,
	 * and an IOException is thrown, then it is caught, wrapped and 
	 * rethrown. However, when throwing the wrapped exception from the
	 * finally clause, the wrapped exception thrown from the first catch 
	 * block is again forgotten. It disappears. Only the exception thrown
	 * from the second catch block is propagated up the call stack.
	 * 
	 * By the way, the try-with-resources features in Java 7 makes it
	 * easier to implement fail safe exception handling.
	 */
	private void test() throws WrapperException{
		InputStream input = null;

		  try{

		    input = new FileInputStream("myFile.txt");

		    //do something with the stream

		  } catch(IOException e){ //first catch block
		    throw new WrapperException(e);
		  } finally {
		    try{
		     if(input != null) input.close();
		    } catch(IOException e){  //second catch block
		       throw new WrapperException(e);
		    }
		  }
	}

}
