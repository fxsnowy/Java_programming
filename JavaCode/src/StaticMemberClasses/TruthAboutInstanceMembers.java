package StaticMemberClasses;

/*
 * You can't access instance fields or methods in the top level class directly
 * from a Static Method Class(SMC) but you can if you have a reference to an 
 * object of that class. 
 * 
 * Where this occurs the compiler will provide access methods if the field or
 * method is private furthermore this access method will need to take a 
 * parameter which is a reference to an instance of the top level class,
 * as shown below:
 * 
 *    class OuterOne{
 *        private long i;
 *        private void m() throws E{ }
 *        static long access$002(OuterOne _1, long _2){ return _1.i = _2;}
 *        static long access$004(OuterOne _1) { return ++_1.i; }
 *        static long access$096(OuterOne _1, long _2) {return _1.i >>>= _2; }
 *        static void access$100(OuterOne _1) throws E{  _1.m(); }
 *        
 *    }
 *    
 *    class OuterOne$InnerOne{
 *        static void test(OuterOne o) throws E{
 *            OuterOne.access$002(o, OuterOne.access$004(o) + OuterOne.access$096(o. 1234L));
 *            OuterOne.access$100(o);
 *        }
 *    }
 *    
 *            
 * 
 */

class E extends java.lang.Exception{ }

class OuterOne{
	private long i;
	private void m() throws E { }
	static class InnerOne{
		static void test(OuterOne o) throws E{
			o.i = ++o.i + (o.i >>>= 1234L);
			o.m();
		}
	}
}



/*
 * If you are trying to access a private method and the method throws an 
 * exception then the access method will have to do the same.
 * 
 */

public class TruthAboutInstanceMembers {
	
}