package ClassesOverridingHidingAccess;

/*
 * Go thru this query.
 * 
 *  http://stackoverflow.com/questions/31680228/covariant-return-type-narrower-exception-type
 *  Below is one example:
 *   
 */
class Type3 {}
class Type2 extends Type3{}
class Type1 extends Type2{}
class Type5 extends Type1 {}

class Exc3 extends Throwable {}
class Exc2 extends Exc3 {}
class Exc1 extends Exc2 {}
class Exc5 extends Exc1 {}

interface It1{
	Type1 m() throws Exc1;
}

interface It2{
	Type2 m() throws Exc2;
}

interface It3{
	Type3 m() throws Exc3;
}

interface It4 extends It1, It2, It3{
	
}

interface It5 extends It1, It2, It3{
	Type5 m() throws Exc5;
} 
public class CovariantReturnTypeAndExceptions {

	public static void main(String[] args) {
		

	}

}
