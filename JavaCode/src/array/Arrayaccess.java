package array;

/*
 * Accessing and assigning arrays
 * 
 * 1) Individual elements accessed using a positive integer index; narrower
 * types are widened to integer. myArray['z'], here 'z' is a character literal
 * so its widened.
 * 
 * 2) instance of array of type subclass may be assigned to an array of type
 * superclass. An array of implementing class may be assigned to an array
 * of its interface type. Size is irrelevant.
 * 
 * 3) Arrays of primitive types are inconvertible - they can only be converted to
 * Object type. Size is irrelevant.
 *    
 */

class C{}; interface I{}; class S extends C implements I{};
class B{};

public class Arrayaccess {
	public static void main(String[] args){
		//Accessing arrays
		long lng = 0L;
		int[] myArray = new int[10];
		//myArray[5] = myArray[lng];  // lng must be integer
		//myArray[5] = myArray[-1];     // Run time error - index out of bounds
		
		
		//Assigning arrays
		C[] c = new C[4];
		S[] s = new S[6];
		I[] i = new S[0];
		B[] b = new B[2];
		//i = new C[2]; //compiler error
		i = s; //OK S implements I
		c = s; //OK S extends C
		s = (S[])c; //cast required
		i = (I[])c;
		//i = (I[])b; //Runtime error
		Object o1 = new S[2];
		Object o2 = new Object[3];
		S[] obj = (S[])o1;
		
		
		int[] ia = new int[6];
		byte[] ba = new byte[8];
		C[] c3 = new C[4];
		Object[] oa = new Object[8];
		
		//ia = ba;          // Compiler error; Inconvertible type
		//ia = (int[])ba;   // Compiler error; Inconvertible type
		//ia = (int[])c3;   // Compiler error; Inconvertible type
		//t  = (T[])ba;     // Compiler error; Inconvertible type
		//ba = (byte[])ia;  // Compiler error; Inconvertible type
		Object o = ba; 		// OK all arrays are objects
		ia = (int[])null;	// null can be cast to any reference type
		
		//Arrays know their type
		Object[] obj1 = new C[4];
		//obj1[3] = new String("xyz"); //Runtime error, its C[] not String[]
		
	}
}
