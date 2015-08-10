package EnhancedForStatement;

public class Example1 {

	public static void main(String[] args) {
		/*
		 * Enhanced for statement with array
		 * 
		 * int[] ia = {2, 3, 5, 7, 11, 13, 17};
		 * for(final int i: ia){
		 *    System.out.println(i);
		 * }
		 *             |is|
		 *             |e |
		 *             |q | 
		 *             |u |  
		 *             |i |
		 *             |v |
		 *             |a |
		 *             |l |
		 *             |e |
		 *             |n |
		 *           __|t |__
		 *           \  to  / 
		 *            \    /
		 *             \  /
		 *              \/
		 *              
		 * int[] ia = {2, 3, 5, 7, 11, 13, 17};
		 * int[] #a = ia;    // Why this extra assignment? initializer can be a function call returning array
		 * for(int #i=0; #i < #a.length; #i++){
		 *     final int i = #a[#i];
		 *     {
		 *        System.out.println(i);
		 *     }
		 * }    
		 *   
		 *             
		 */
		
		
	}

}
