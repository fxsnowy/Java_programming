package array;

/*
 * 1) Initializing an array with an initializer is a shortened form of using
 * an anonymous array. An anonymous array can be used when an array is not declared.
 * 
 */


public class ArrayInitialization {

	public static void main(String[] args) {
		//declare, create and initialise arrays
		int[][] ia =  {{7}, {6}, {5}, {9}}; // is int[4][1]
		int i = 9;
		int[] ib = {i++, i++, i++};
		int[][] ic = {{i++}, {i++, ++i}, null, {}, ib}; // {} is zero length array
		
		MyType mtb = null;
		MyType[] mta = {new MyType(), mtb, null};
		
		
		int[] id = new int[]{1, 2, 3};
		int[][] ie = new int[][]{{1, 8, 9}, {2}, {3}, {4}};
		int[][] ix = new int[][]{new int[] {1, 8, 9}, {2}, {3}};
		
		//passing Anonymous array
		test(new int[]{1, 2, 3});
		
		
	}
	
	static void test(int[] var){
			
	}

}
