package enumtypes;




/*
 * 1) You can specify value of enum constants at the creation time.
 * myEnum.values() return an array of myEnum's values.
 * 2) The compiler automatically adds some special methods when it
 * creates an enum. For example, they have a static values method
 * that returns an array containing all of the values of the enum
 * in the order they are declared.
 * 3) Enum constants are implicitly static and final and cannot be 
 * changed once created.
 * 4) An enum can be declared outside or inside a class, but NOT in a method.
 * 
 */



public class Example2 {
	
	enum Company{
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
		private int value;
		
		private Company(int value){
			this.value = value;
		}
		
	}

	
	public static void main(String[] args) {
		Company c = Company.EBAY;
        		
	}

}
