package array;


/*
 * 1) For multi dimensional arrays only the first dimension is copied
 * 
 * 2) Every array implements the interfaces Cloneable and java.io.Serializable
 */
public class CloningArray {

	public static void main(String[] args) {
		int[] ia = {1, 2, 3};
		int[] ib = ia.clone();
		ia[2]++;
		System.out.println(ia[2] + " " + ib[2]); // 4 3
		
		int[][]ic = {{1}, {2}, {3, 4, 5}};
		int[][]id = ic.clone();
		ic[2][0]++;
		System.out.println(ic[2][0] + " " + id[2][0]);
	}

}
