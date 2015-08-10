package inheritanceVScomposition_ex1;

class Fruit {
    // Return int number of pieces of peel that
    // resulted from the peeling activity.
    public int peel() {
        System.out.println("Peeling is appealing.");
        return 1;
    }
}

class Apple extends Fruit {
}

public class example1 {

	public static void main(String[] args) {
		Apple apple = new Apple();
		int pieces = apple.peel();
		
	}

}
