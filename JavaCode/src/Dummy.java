class Super{
	static final int CONSTANT = 3;
}

class Sub extends Super{
	
}

public  class Dummy {
	public static void main(String[] args) {
	 System.out.println(Sub.CONSTANT);	
	}
}