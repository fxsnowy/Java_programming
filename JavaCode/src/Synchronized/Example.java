package Synchronized;

/*
 * Every object and every class has a lock.
 * 
 * In the below syntax, 'Expression' is a reference.
 * 
 * 			synchronized(Expression){
 * 				// code
 * 			}
 * 
 * The synchronized statement waits until it acquires the lock on the
 * referred object before it can execute the code. On completion it 
 * releases the lock. This ensures that only one thread at a time can
 * execute the code.
 * 
 * 		
 */


public class Example {

	/*
	 * Methods can also be marked as synchronized by putting the word
	 * synchronized in front of its return type. For a static method the class
	 * lock is obtained for a non-static method the object's lock is obtained.
	 * 
	 */

	public static synchronized void testExample(){
		/*code*/
	}

	public synchronized void text2(){
		/* code */
	}
	
	
	public static void main(String[] args) {

	}

}
