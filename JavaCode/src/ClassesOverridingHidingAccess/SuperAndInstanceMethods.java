package ClassesOverridingHidingAccess;

/*
 * 1) For instance method overriding, it is the runtime class which counts.
 * 
 * 2) The actual method called depends on the runtime class of the object.
 * Casting does not change the runtime class it merely checks that it is 
 * compatible with the specified type.
 * Casting changes the view of the object not the actual object itself.
 * 
 * 3) For field overriding, it is the view which counts.
 * 
 */
interface I{
	int x = 0;
}
class T1 implements I{
	int x = 1;	// hiding fields
	String s(){
		return "1";
	}
}

class T2 extends T1{
	int x  = 2;
	String s(){
		return "2";
	}
}

class T3 extends T2{
	int x = 3;
	String s(){
		return "3";
	}
	
	void test(){
		// Accessing instanc method
		System.out.println("s()=\t\t" + s());	// 3
		System.out.println("super.s()=\t" + super.s()); // 2
		System.out.println("((T2)this).s()= " + ((T2)this).s());  // 3
		System.out.println("((T1)this).s()= " + ((T1)this).s());  // 3
		
		//Accessing instance attribute
		System.out.println("\n\nx=\t\t" + x);  // 3
		System.out.println("super.x=\t" + super.x);  // 2
		System.out.println("((T2)this).x=\t" + ((T2)this).x);  // 2
		System.out.println("((T1)this).x=\t" + ((T1)this).x);  // 1
		System.out.println("((I)this).x=\t" + ((I)this).x);   // 0
	}
}

public class SuperAndInstanceMethods {
	public static void main(String[] args) {
		(new T3()).test();
	}
}