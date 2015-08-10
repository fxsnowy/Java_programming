package Exceptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class Tpc2_TryWithResources {

	/*
	 * 1) In Java 7 you can write the code from the example above using the
	 * try-with-resource construct as shown below
	 * 
	 * Notice the first line inside the method
	 *        'try(FileInputStream input = new FileInputStream("file.txt")) {'
	 * This is the try-with-resources construct.
	 * 
	 * 2) When the try block finishes the FileInputStream will be closed 
	 * automatically. This is possible because FileInputStream implements the 
	 * Java interface java.lang.AutoCloseable. All classes implementing this
	 * interface can be used inside the try-with-resources construct.
	 * 
	 * 3) If an exception is thrown both from inside the try-with-resources block,
	 * and when the FileInputStream is closed (when close() is called), the 
	 * exception thrown inside the try block is thrown to the outside world.
	 * The exception thrown when the FileInputStream was closed is suppressed.
	 * 
	 * This is opposite of what happens in the example using 'finally' block,
	 * using the old style exception handling (closing the resources in the finally block).
	 * 
	 * 4) By the way, the try-with-resources features in Java 7 makes it easier
	 * to implement fail safe exception handling.
	 * 
	 *        
	 */
	
	private static void printFileJava7() throws IOException {

	    try(FileInputStream input = new FileInputStream("file.txt")) {

	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	}
	
	
	
	/*
	 * 4) You can use multiple resources inside a try-with-resources block and
	 * have them all automatically closed. Here is an example:
	 * 
	 * 5) This example creates two resources inside the parentheses after the
	 * try keyword. An FileInputStream and a BufferedInputStream. Both of these 
	 * resources will be closed automatically when execution leaves the try block.
	 * 
	 * 6) The resources will be closed in reverse order of the order in which 
	 * they are created / listed inside the parentheses. First the
	 * BufferedInputStream will be closed, then the FileInputStream.
	 * 
	 */
	
	private static void printFileJava7_() throws IOException {

	    try(  FileInputStream     input         = new FileInputStream("file.txt");
	          BufferedInputStream bufferedInput = new BufferedInputStream(input)
	    ) {

	        int data = bufferedInput.read();
	        while(data != -1){
	            System.out.print((char) data);
	    data = bufferedInput.read();
	        }
	    }
	}
	
	/*
	 * Custom AutoClosable Implementations
	 * 
	 * 1) The try-with-resources construct does not just work with Java's
	 * built-in classes. You can also implement the java.lang.AutoCloseable
	 * interface in your own classes, and use them with the try-with-resources
	 * construct.
	 *
	 * 2) The AutoClosable interface only has a single method called close().
	 * Here is how the interface looks:
	 * 			public interface AutoClosable {
	 * 					public void close() throws Exception;
	 * 			}
	 * 
	 * 3) Here is an example of how the MyAutoClosable is used with the
	 * try-with-resources construct that prints an output:
	 * 			MyAutoClosable doing it!
	 * 			MyAutoClosable closed!
	 * 
	 *  
	 */
	private static void myAutoClosable() throws Exception {

	    try(MyAutoClosable myAutoClosable = new MyAutoClosable()){
	        myAutoClosable.doIt();
	    }
	}
	
	
	public static void main(String[] args) {
		
		
	}

}

class MyAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
}
