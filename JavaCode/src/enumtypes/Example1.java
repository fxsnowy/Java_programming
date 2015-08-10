package enumtypes;


/*
 * 1) enum type syntax pulled singleton design pattern into java language
 * 2) You should always use enums when a variable can only take one
 * out of a small set of possible values.
 * 3) If you use enum instead of integers(or String codes), you increase
 * compile-time checking.
 * 4) All enums implicitly extend java.lang.Enum
 *  http://stackoverflow.com/questions/31039980/in-java-what-does-such-enum-type-compile-to
 *  
 */
enum Company{
	GOOGLE("G"), YAHOO("Y"), EBAY("E"), PAYPAL("P");
	
	private String companyLetter;
	
	private Company(String s){
		companyLetter = s;
	}
	
	public String getCompanyLetter(){
		return companyLetter;
	}
}
enum X{A}

public class Example1 {

	public static void main(String[] args) {
		
		System.out.println(Company.EBAY.getCompanyLetter());
		System.out.println(Company.EBAY.name());     //super class 'Enum' methods
		System.out.println(Company.EBAY.ordinal());  //super class 'Enum' methods
		System.out.println(Company.EBAY.toString()); //super class 'Enum' methods
		System.out.println(Company.valueOf(Company.class, Company.EBAY.name()));
		Company cName = Company.EBAY;
		//cName = 1;   //compile time error
		Example1 ex1 = new Example1();
		Example1 ex2 = new Example1();
		System.out.println(ex1 == ex2);
		X x1 = X.A;
		X x2 = X.A;
		System.out.println(x1 == x2);
		
	}

}
