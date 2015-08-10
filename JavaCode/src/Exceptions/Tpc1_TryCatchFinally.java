package Exceptions;

import java.io.FileReader;
import java.io.IOException;

/*
 * 1) If a method declares that it throws an exception A,
 * then it is also legal to throw subclasses of A.
 * 
 * 2) When the catch block is finished the program continues
 * with any statements following the catch block.
 * 
 * At most one catch block is executed.
 * 
 */
public class Tpc1_TryCatchFinally {

	/*
	 * 3) here is how finally block works.
	 * 
	 * No matter whether an exception is thrown or not inside the try or
	 * catch block the code inside the finally-block is executed.
	 * The example below shows how the file reader is always closed,
	 * regardless of the program flow inside the try or catch block.
	 * 
	 * Note: If an exception is thrown inside a finally block, and it is
	 * not caught, then that finally block is interrupted just like the 
	 * try-block and catch-block is. That is why this below example had
	 * the reader.close() method call in the finally block wrapped in
	 * a try-catch block
	 * 
	 * Generally resources are closed in finally block.
	 * 
	 * 
	 */
	 public void openFile(){
	        FileReader reader = null;
	        try {
	            reader = new FileReader("someFile");
	            int i=0;
	            while(i != -1){
	                i = reader.read();
	                System.out.println((char) i );
	            }
	        } catch (IOException e) {
	            //do something clever with the exception
	        } finally {
	            if(reader != null){
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                    //do something clever with the exception
	                }
	            }
	            System.out.println("--- File End ---");
	        }
	    }
	 
	 
	 /*
	  * 4) You don't need both a catch and a finally block. You can have
	  * one of them or both of them with a try-block, but not none of them.
	  * This code doesn't catch the exception but lets it propagate up the
	  * call stack. Due to the finally block the code still closes the filer
	  * reader even if an exception is thrown.
	  * 
	  * Notice how the catch block is gone.
	  */
	 public void openFile1() throws IOException {
	        FileReader reader = null;
	        try {
	            reader = new FileReader("someFile");
	            int i=0;
	            while(i != -1){
	                i = reader.read();
	                System.out.println((char) i );
	            }
	        } finally {
	            if(reader != null){
	                try {
	                    reader.close();
	                } catch (IOException e) {
	                    //do something clever with the exception
	                }
	            }
	            System.out.println("--- File End ---");
	        }
	    }
	 
	public static void main(String[] args) {
		

	}

}
