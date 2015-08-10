package inheritanceVScomposition_ex3;

class Fruit {
    // Return int number of pieces of peel that
    // resulted from the peeling activity.
    public int peel() {
        System.out.println("Peeling is appealing.");
        return 1;
    }
}

/*
 * Composition provides an alternative way for Apple to reuse 
 * Fruit's implementation of peel(). Instead of extending Fruit,
 * Apple can hold a reference to a Fruit instance and define its 
 * own peel() method that simply invokes peel() on the Fruit.
 * 
 */
class Apple {
    private Fruit fruit = new Fruit();
    public int peel() {
        return fruit.peel();
    }
}

public class example3 {
	public static void main(String[] args) {
		Apple apple = new Apple();
        int pieces = apple.peel();
    }

}
