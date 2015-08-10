package inheritanceVScomposition_ex4;

class Peel {
	private int peelCount;

	public Peel(int peelCount) {
		this.peelCount = peelCount;
	}

	public int getPeelCount() {
		return peelCount;
	}
	// ...
}

class Fruit {
	// Return int number of pieces of peel that
	// resulted from the peeling activity.
	public Peel peel() {
		System.out.println("Peeling is appealing.");
		return new Peel(1);
	}
}

/*
 * In the composition approach, the subclass becomes the "front-end class," and
 * the superclass becomes the "back-end class." With inheritance, a subclass
 * automatically inherits an implemenation of any non-private superclass method
 * that it doesn't override. With composition, by contrast, the front-end class
 * must explicitly invoke a corresponding method in the back-end class from its
 * own implementation of the method. This explicit call is sometimes called
 * "forwarding" or "delegating" the method invocation to the back-end object.
 * 
 * The composition approach to code reuse provides stronger encapsulation than
 * inheritance, because a change to a back-end class needn't break any code that
 * relies only on the front-end class. For example, changing the return type of
 * Fruit's peel() method from the previous example doesn't force a change in
 * Apple's interface and therefore needn't break Example3's code.
 */
class Apple {
	private Fruit fruit = new Fruit();

	public int peel() {// Apple must be changed to accomodate the change to
						// Fruit
		Peel peel = fruit.peel();
		return peel.getPeelCount();
	}
}

public class example4 {

	public static void main(String[] args) {
		Apple apple = new Apple();
		int pieces = apple.peel(); // This old implementation of Example3 still
									// works fine.

	}

}

