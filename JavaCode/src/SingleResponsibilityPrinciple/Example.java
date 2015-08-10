package SingleResponsibilityPrinciple;

/*
 * Single Responsibility Principle
 * 
 * As for squashing 'Iterable' and 'Iterator' into one interface,
 * it would violate Single Responsibility Principle. Being an 'Iterator'
 * (keeping track of the act of iterating over elements), and being 'Iterable'
 * (that is able to build new iterators) are two different responsibilities. 
 * 
 * It does not make sense to squash both 'Iterable' and 'Iterator' interface
 * as single interface.
 * 
 * 
 * 
 */
public class Example {

	public static void main(String[] args) {
		
		
	}

}
