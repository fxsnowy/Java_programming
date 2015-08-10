package variablesANDscope;

public class Example {
	int i = 3;
	
	void method(int k){
		System.out.println(" i = " + i + " j = " + j); //i=3 j=7
		int i = 4;
		//int k = 1; //duplicate local variable-error
		{
			int j = 5;
			//int i = 1;	//duplicate local variable-error
			System.out.println("i= " + i + "j= " + j); //i=4 j=5
		}
		{
			int j = 9;
			System.out.println("i= " + i + "j= " + j); //i=4 j=9
		}
	}
	
	int k = 6;
	int j = 7;
	
	public static void main(String[] args) {
		

	}
	
}

