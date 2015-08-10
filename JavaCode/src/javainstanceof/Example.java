package javainstanceof;

/*
 * 1) For syntax, 'oRef instanceof T', instanceof operator takes an
 * object reference and a class type T and returns true if the object
 * referred to is of 'class T' or a subclass of T.
 * 
 * 2) The left hand operand must be a reference type, If its a primitive type the
 * compiler gives an error.
 * 
 * 3) If 'oRef' is null, the answer is false.
 * 
 *  
 */



interface I0{}; interface I1{}; interface I2 {};
interface I3 extends I0{};

class C1{}; class B implements I0{};
class C2 extends C1 implements I1, I2 {};
class C3 extends C2 implements I3 {};
class D extends B implements I1{};
public class Example {

	public static void main(String[] args) {
	

		/*
		 *                   
		 * 				       Object                  I0 
		 *   I1    I2         ^        \              . ^
		 *     .    .         |         \           .   |
		 *       .   .        |          \ ______ .     |
		 *         .  .       C1          |__B___|     I3
		 *           . .     /                      .        
		 *             ..   /                   .            
		 *               C2                  .              
		 *                ^               .                                    
		 *                |            .                   
		 *                |        .                      
		 *                |    .
		 *                C3 
		 *                                           
		 */

		
		Object o;  Object[]  oa;
		I0    i0;  I0[]      i0a;
		I1    i1;  I1[]      i1a; 
		I2    i2;  I2[]      i2a;
		I3    i3;  I3[]      i3a;
		C1    c1;  C1[]      c1a;
		C2    c2;  C2[]      c2a;
		C3    c3;  C3[]      c3a;
		B     b;   B[]        ba;
	    
		/*
		 * For syntax 'oRef instanceof T',  if the compile time type of
		 * the left hand variable is such that it can't possibly be of
		 * class T then the compiler gives an error as shown below.
		 * 
		 * class hierarchy is known at compile time.
		 */
		boolean value;
		//value = c3 instanceof B;  // compile time check error
		//value = b instanceof C3;  // compile time check error
        //value = c2a instanceof B[];
		//value = c2a instanceof C2[][]; 
		b = new D();
		value = b instanceof I0;   // false at runtime. Compiler can't tell.    
		System.out.println(value);
		
	}

}