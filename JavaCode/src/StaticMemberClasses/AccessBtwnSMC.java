package StaticMemberClasses;

/*
 * Two SMCs nested in the same Top Level classes can access each others 
 * fields and methods even if they are private, (in which case compiler inserts an access method)
 * 
 * 
 *   class Outer{
 *   
 *   }
 *   
 *   class Outer1$In1{
 *       private int i;
 *       static int access$008(Outer1$In1 _1){ _1.i++; }
 *   }
 *   
 *   class Outer1$In2{
 *       void m(Outer1$In1 in){ Outer1$In1.access$008(in); }
 *   }
 *   
 */

class Outer1{
	private static class In1{
		private int i;
	}
	
	private static class In2{
		void m(In1 in){
			in.i++;
		}
	}
}



public class AccessBtwnSMC {

	public static void main(String[] args) {
		

	}

}
