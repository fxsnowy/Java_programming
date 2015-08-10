package constants;


/*
 * You might wish to make a method final if it has an implementation that
 * should not be changed and it is critical to the consistent state of the
 * object.
 * 
 * 
 * Methods called from constructors should generally be declared final.
 * If a constructor calls a non-final method, a subclass may redefine that 
 * method with surprising or undesirable results.
 * 
 * Whenever you don't want a class to be inherited, you make the class
 * declare as final.
 *  
 */

public class Rational {
    
	/* implementation - starts*/
	
	private int[] tuple;
	
	private Rational(int n, int d){
		this.tuple = new int[2];
		int g = gcd(n, d);
		this.tuple[0] = n / g;
		this.tuple[1] = d / g;
		
	}
	
	private final int getNumer(){
		return this.tuple[0];
	}
	
	private final int getDenom(){
		return this.tuple[1];
	}
	
	/*
	 * helper function
	 */
	private static final int gcd(int n, int d){
		 if (d == 0)
		    return n;
		 else
		    return gcd(d, n % d);
	}
	/* implementatiion - ends*/
	
	/*
	 * Interface - starts
	 */
	
	public static Rational makeRational(int n, int d){
		return new Rational(n, d);
	}
	
	public Rational mulRational(Rational x, Rational y){
		return new Rational(x.getNumer()*y.getNumer(), x.getDenom()*y.getDenom());
	}
	
	
	public Rational addRational(Rational x, Rational y){
		return new Rational(x.getNumer() * y.getDenom() + y.getNumer() * x.getDenom(), x.getDenom() * y.getDenom());
		
	}
	
	@Override
	public boolean equals(Object obj) {
    	// logical equality
		return this.getNumer() * ((Rational)obj).getDenom() == ((Rational)obj).getNumer() * this.getDenom();
	}

    @Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.getNumer();
		result = 31 * result + this.getDenom();
		return result;
	}

	@Override
	public String toString() {
		return  this.getNumer() + "/" + this.getDenom();
	}
    
	/*
	 * Interface - ends
	 */
	
	
	public static final void main(String[] args) {
		System.out.println("abc");

	}

}


/*
 * keyword 'final' is also used to define named constants.
 * 
 * Only constants which are immediately given a value computable at 
 * compile time get treated as literals.
 * for example  CONST_1/3/6/8 in below code 
 */
class DefineConstants{
	static final int CONST_1 = 90;
	static final int CONST_2;
	static{
		CONST_2 = 90;
	}
	static final int CONST_3 = CONST_1 / 2;
	static final int CONST_4 = (int)System.currentTimeMillis();
	final int 		 CONST_5 = (int)System.currentTimeMillis();
	final int 		 CONST_6 = CONST_1 / 2;
	final int 		 CONST_7;
	{
		CONST_7 = 90;
	}
	
	int getSomeValue(){
		return 55;
	}
	
	void test(){
		final int CONST_8 = 42;
		final int CONST_9;
		CONST_9 = 44;
		final int CONST_10 = getSomeValue();
	}
}


