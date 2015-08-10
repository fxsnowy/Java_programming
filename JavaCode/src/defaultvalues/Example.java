package defaultvalues;
import java.util.*;


/*
 * If you don't initialise a class member variable they are
 * set as follows. This applies to both static and instance variables.
 * 
 * ---------------------------------
 *   Type       	|  Default value
 * ---------------------------------
 *      byte		|      0
 *      char		|      '\u0000'
 *     short		|      0
 *       int 		|	   0
 *      long 		| 	   0L
 *     float		|	   0.0f
 *    double		|      0.0d
 *   boolean	   	|      false
 * reference		|      null
 * ---------------------------------
 * 
 * Unlike member variables local variables of a method are not automatically
 * initialised with a default value, but the compiler prevents access any
 * local variable until it has been initialised by the program.
 * 
 * Three ways to initialise an class instance members, when you do 'new' to create an object:
 * 1) With an initialiser. For example int i = 24;
 * 2) With ordinary code in the constructor.
 * 3) With an instance initialisation block. They get run after default initialisation.
 * 
 * Two ways to initialise class static members, when class is loaded:
 * 1) With an initialiser. For example static int i = 24;
 * 2) With static initialisation block. They get run after default initialisation.
 *  
 */

class Super{
	static int x;
	static{
		System.out.println("Super");
	}
}

class Sub extends Super{
	Date date;
	{//instance initialisation block for date
		Calendar temp = Calendar.getInstance();
		date = temp.getTime();
	}
	static{
		System.out.println("Sub");
	}
	
	long alarm;
}

class Game{
	static Random rand;
	static{
		rand = new Random();
	}
	static void tossCoin(){
		if(rand.nextBoolean()){
			System.out.println("Heads");
		}else{
			System.out.println("Tails");
		}
	}
	
}
public class Example {
	public static void main(String[] args) {
		System.out.println(Sub.x); // class Super is loaded. From class Super, static members are
		//initialised and static initialisation blocks are executed before executing expression 'Sub.x'
		
		Game.tossCoin(); // class Game is loaded. From class Game, static members are initialised
		//and static initialiser blocks are executed before executing expression 'Game.tossCoin()'
		Sub obj = new Sub(); //instance variables are initialised and instance initialisation block 
		//of class A are executed.
		System.out.println(obj.date);
		System.out.println(obj.alarm);
		System.out.println(obj); // prints obj's hashcode.Typically, hashCode() just returns the
		                         // object's address in memory if you don't override it.
		
	}
	
}
