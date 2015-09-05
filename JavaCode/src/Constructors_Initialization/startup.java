package Constructors_Initialization;

/*
 * A stand alone program starts at the method main declared as:
 * 
 * 		public static void main(String[] args)
 * 	 or public static void main(String... args)
 * 
 * The arguments are the parameters passed on the command line.
 * 
 * For example:
 * 
 * java startup abc def xyz
 * 
 * will print:
 * abc
 * def
 * xyz
 * 
 */
public class startup {
	public static void main(String[] args){
		for(final String s: args){
			System.out.println(s);
		}
	}
	
}



