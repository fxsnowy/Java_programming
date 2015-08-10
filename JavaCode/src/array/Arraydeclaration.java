package array;

/*
 * 1) array.length may look like a member access in the source code but have
 * nothing to do with real class members.
 * 
 * 2) There is no member named 'length' in array type. when you write 'array.length',
 * it will get compiled to a bytecode instruction 'arraylength' dedicated to retrieve
 * the length of an array at runtime without actually specifying how a JVM remembers
 * lengths of arrays. That’s implementation dependent.
 * 
 * 3) JLS 4.3.1 says "An object is a class instance or an array."
 * 
 * 4) Arrays are subclass of 'class Object', so that means all the methods of 'class Object'
 * can be invoked on them.
 * 
 * 5) Is java array(T[]) with an element null is of length 1? yes
 * 
 * 6) The length of an array represents how many components that an array can have.
 * 
 * 7) An array has a fixed length. This length cannot be changed.
 * 
 * 8) An array is created by an array creation expression (§15.10.1) or an array initializer (§10.6)
 * 
 * 9) An array creation expression specifies the element type, the number of levels
 * of nested arrays, and the length of the array for at least one of the levels of 
 * nesting. The array's length is available as a final instance variable length.
 * 
 * 10) An array creation expression specifies the element type, the number of levels
 * of nested arrays, and the length of the array for at least one of the levels of
 * nesting. The array's length is available as a final instance variable length.
 * 
 * 
 */

class MyType{}

public class Arraydeclaration {
	public static void main(String[] args) {
		//Declaration syntax of an array variable
		int[] 			ia;
		MyType[][] 		mta;
		MyType[] 		mtb[];   // local variable of a method is unspecified
		MyType          mtc[][]; // Number of consecutive '[]' is 255
	    	
		// declare & create array all in one go
		int[] ib = new int[5];   
		int i = 2;
		MyType[][]   mt2 = new MyType[++i][10*(++i)];  //expr giving a +ve integer will do
		MyType[][]   mt3 = new MyType['z']['9'];
		MyType[][]   mt4 = new MyType[3][];  //2D array don't have
		mt4[0] = new MyType[4];              //...to be square
		mt4[1] = new MyType[1];
		mt4[2] = new MyType[7];
		//MyType[][][] mt5 = new MyType[][9][6]; //Error. size must be specified from the left
		int[] ic = new int[0]; // content of ic has memory location(that is empty)
		int[][][] t = new int[4][0][2]; // jvm does not allocate space after first zero is encountered.
		                                // however t is not of type int[][]
		
		//length field of array, which is final
		MyType[][][] aT = new MyType[1][2][3];
		System.out.println(aT.length);  // 1
		System.out.println(aT[0].length);  // 2
		System.out.println(aT[0][0].length);  // 3
		System.out.println(aT[0][1].length);  // 3
		
		int[][][] aV = { {{9, 4}, null},  {},  {{1, 2, 3}} };
		System.out.println(aV.length + " " + aV[1].length);  // 3 0

		int[][][] aX = { {{9, 4}, null},  {null},  {{1, 2, 3}} };
		System.out.println(aX.length + " " + aX[1].length);  // 3 1
		
		MyType[] a = {null};
		System.out.println(a.length);
		
	}
}

