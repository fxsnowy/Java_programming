package Constructors_Initialization;

/*
 * 1) It is about the process of setting the static fields in classes 
 * and interfaces.
 * 
 * 2) Initialization is done using 'static initialization blocks'.
 * The same rules for forward references apply as for instance 
 * initialization.
 * 
 * 
 * 3) Initialization takes place at various times sp there is no clearly
 * related thread of execution; therefore if a checked exception is thrown
 * it has to be caught (because there is nowhere for it to propagate to).
 *   
 * 4) Execution of any static initializers and static field initializers 
 * occurs in the order they are declared except in the case of 'static final
 * fields which are initialized with compile time constants', these are set 
 * first before anything else. 
 * 
 * 5) Initializing a class causes its direct superclass to be initialized 
 * first (unless they are already initialized), it does not cause any 
 * implemented interfaces to be initialized. Initializing any interface does 
 * not cause its super interfaces to be initialized.
 * 
 * 
 * 
 */
class Z{
	static int peekj(){
		return j;
	}
	static int peekk(){
		return k;
	}
	static int i = peekj();
	static int h = peekk();
	static final int j = 1;
	static int k = 1;
}


class Super{
	static{
		System.out.print("Super");
	}
	static int taxi = 1729;
}

class Two extends Super{
	static{
		System.out.print("Two");
	}
}

class Sub extends Super{
	static{
		System.out.print("Sub");
	}
}

interface I{
	int i = 1, ii = Test.out("ii", 1);
}

interface J extends I{
	int j = Test.out("j", 3), jj = Test.out("jj", 4);
}

interface K extends J{
	int k = Test.out("k", 5);
}

class Test{
	static int out(String s, int i){
		System.out.println(s + "=" + i);
		return i;
	}
}

public class ClassAndInterfaceInitialization {
	public static void main(String[] args) {
		
		System.out.println(Z.i);
		System.out.println(Z.h);
		
		Two t = null; //This does not trigger initialization
		System.out.println("No effect yet");
		t = new Two(); //prints "Super Two"
		
		System.out.print(Sub.taxi); // cause Super to initialize not Sub
		new Sub();   //Cause Sub to initialize not Super (because Super has already been initialised)
		
		
		System.out.println(J.i); // J.i is declared in I but this does not trigger
								 // its initialization because it is a compile time 
								 // constant(static final member). prints "1"
		System.out.println(K.j); // K.j lies in J so this triggers the initialization
								 // before the statement runs. Therefore "j=3" and
								 // "jj=4" gets printed before K.j is evaluated 
								 // resulting in 3 being printed. super interface I
								 // does not get initialized.
	}
}
