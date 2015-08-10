package ClassesOverridingHidingAccess;

interface I5{
	int x = 0;
}

class T4 implements I5{
	int x = 1;
}

class T5 extends T4{
	int x = 2;
}

class T6 extends T5{
	int x = 3;
	
	void test(){
		//T6 t6 = (T4)this;		//this gives a compiler error
		if ((T4)this instanceof T6){
			System.out.println("(T4)this is instance of T6");
		}
		T4 t4 = (T4)this;
		if (t4 instanceof T6){
			System.out.println("even after assignment it remains T6");
		}
	}
}

public class TypeCasting {

	public static void main(String[] args) {
		new T6().test();

	}

}
