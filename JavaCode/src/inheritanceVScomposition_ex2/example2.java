package inheritanceVScomposition_ex2;

class Peel {
    private int peelCount;
    public Peel(int peelCount) {
        this.peelCount = peelCount;
    }
    public int getPeelCount() {
        return peelCount;
    }
    //...
}
class Fruit {
    // Return a Peel object that
    // results from the peeling activity.
    public Peel peel() {
        System.out.println("Peeling is appealing.");
        return new Peel(1);
    }
}
// Apple still compiles and works fine
class Apple extends Fruit {
}

public class example2 {

	public static void main(String[] args) {
		Apple apple = new Apple();
        //int pieces = apple.peel(); //This old implementation of Example1 is broken and won't compile. 
		
	}

}
