package NonStaticMemberClass;

/*
 * A non static member class can use 'Classname.this' and 'Classname.super'
 * to get enclosing instances and their inherited members. 
 * 
 * You can't do this out side the class or with a SMC because the technique 
 * uses the 'this$n' chain to obtain the associated enclosing class instance.
 * 
 * 
 * Here 'SyntaxForThisAndSuper' is 'Out':
 * 
 * 
 * 
 * 
 *                                   ----------------
 *                                  ||              ||
 *                                  ||    Ext2      ||
 *                                  ||______________||<-----               
 *  								|                |     | 
 * 									|    this$0      |     |
 *                                  |   /  In1       |     |   -------------------
 *                                  |__/_____________|     |   |||              |||
 *           ----------------         /                    |   |||   Ext2       |||
 *          ||               ||      /                     |   |||______________||| 
 *          ||      Ext1     ||<----/----------------------|---||-----this$0     || 
 *          ||               ||    /                       |   ||     In1        || 
 *          ||_______________||   /                        |   ||________________|| 
 *          |                 |  /                         |   |                  | 
 *          |                 | /                          |___|______this$1      |
 *          |      Out        |L                               |                  |
 *          |_________________|                                |       In2        |
 *                                                             |__________________| 
 *          
 *          
 *          
 */ 

class Ext1{
	int j=0;
}

class Ext2{
	int j=1;
}

public class SyntaxForThisAndSuper extends Ext1{
	int j = 2;
	class In1 extends Ext2{
		int j=3;
		In1(int x){
			j=x;
		}
		
		class In2 extends In1{
			int j=4;
			In2(int x){
				super(x);
			}
			void test(){
				/*
				 * 'SyntaxForThisAndSuper.this.j' gets replaced with 'this$1.this$0.j' 
				 */
				System.out.println( j + super.j + In1.this.j + In1.super.j + 
						SyntaxForThisAndSuper.this.j + SyntaxForThisAndSuper.super.j);
			}
		}
	}
	
	public static void main(String[] args){
		new SyntaxForThisAndSuper().new In1(10).new In2(20).test();
	}
}