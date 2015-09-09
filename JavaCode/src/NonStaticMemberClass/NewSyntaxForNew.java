package NonStaticMemberClass;


/*
 * Constructors of NSMCs take an extra hidden parameter which is a reference
 * to an instance of the immediately enclosing class. There is also a syntactic
 * extension of 'new'. 
 * 
 * A reference to an instance of a class can be followed by '.new' and a constructor
 * of an immediately enclosed class. The reference then becomes the hidden paramter 
 * passed in the immediately enclosed class.
 * 
 */
public class NewSyntaxForNew {
	class In1{
		class In2{
			
		}
	}
	public static void main(String[] args) {
		In1.In2 i2 = new  NewSyntaxForNew().new In1().new In2();
	}
}


class K{
	static class Ka{
		static class Kb{
			class Kc{
				class Kd{
					
				}
			}
		}
	}
}

class Test{
	K.Ka.Kb.Kc.Kd k = (new K.Ka.Kb()).new Kc().new Kd();
}