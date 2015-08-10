package stringbenchmark_ex7;

public class Lesson7 {

	public static void main(String[] args) {
		/*
		 * Benchmarking String/StringBuffer/StringBuilder
		 * 
		 * 1) StringBuilder is 2x faster than StringBuffer, and 300x faster than String.
		 * 
		 * 2) Reversing a long String via a String vs. a StringBuffer vs. a StringBuilder
		 * 
		 */
		
		long beginTime, elapsedTime;
		
		
		//Build a long string
		String str = "";
		int size = 16536;
		char ch = 'a';
		beginTime = System.nanoTime(); // returns the current value of the system timer,
		// in nanoseconds
		for(int count = 0; count < size; count++){
			str += ch;
			++ch;
			if(ch > 'z'){
				ch = 'a';
			}
		}
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed Time is: " + elapsedTime/1000 + " usec(Build String)");
		
		//Reverse a string by building another String character-by-character in the reverse order.
		String strReverse = "";
		beginTime = System.nanoTime();
		for(int pos = str.length() - 1; pos >= 0; pos--){
			strReverse += str.charAt(pos);
		}
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed TIme is " + elapsedTime/1000 + " usec (Using String to reverse)");
		
		
		//Reverse a string via an empty StringBuffer by appending characters in the reverse order
		beginTime = System.nanoTime();
		StringBuffer sBufferReverse = new StringBuffer(size);
		for(int pos = str.length() - 1; pos >= 0; pos--){
			sBufferReverse.append(str.charAt(pos));
		}
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed TIme is " + elapsedTime/1000 + " usec (Using StringBuffer to reverse)");
		
		//Reverse a string by creating a StringBuffer with the given String and invoke its reverse()
		beginTime = System.nanoTime();
		StringBuffer sBufferReverseMethod = new StringBuffer(str);
		sBufferReverseMethod.reverse();
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed Time is " + elapsedTime/1000 + "usec (Using StringBuffer's reverse() method");
		
		//Reverse a string via an empty StringBuilder by appending characters in the reverse order
		beginTime = System.nanoTime();
		StringBuilder sBuilderReverse = new StringBuilder(size);
		for(int pos = str.length() - 1; pos >= 0; pos--){
			sBuilderReverse.append(str.charAt(pos));
		}
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed Time is " + elapsedTime/1000 + "usec (Using StringBuilder to reverse)");
		
		//Reverse a string by creating a StringBuilder with the given String and invoke its reverse()
		beginTime = System.nanoTime();
		StringBuffer sBuilderReverseMethod = new StringBuffer(str);
		sBuilderReverseMethod.reverse();
		elapsedTime = System.nanoTime() - beginTime;
		System.out.println("Elapsed Time is " + elapsedTime/1000 + "usec (Using StringBuilder's reverse method)");
	}

}