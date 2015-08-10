package inheritanceVscomposition_ex5;

/*
 * Below code demonstrates: It's easier to add new subclasses (inheritance)
 * than it is to add new front-end classes (composition), because inheritance
 * comes with polymorphism. If you have a bit of code that relies only on a
 * superclass interface, that code can work with a new subclass without change.
 * This isn't true of composition, unless you use composition with interfaces.
 * 
 */
interface Peelable {
    int peel();
}

class Fruit {

    public int peel() {
        System.out.println("Peeling is appealing.");
        return 1;
    }
    //...
}

class Apple implements Peelable {
    private Fruit fruit = new Fruit();
    public int peel() {
        return fruit.peel();
    }
}

class FoodProcessor {
    static void peelAnItem(Peelable item) {
        item.peel();
    }
}

public class Example5 {

	public static void main(String[] args) {
		Apple apple = new Apple(); //sub class is the front end class
        FoodProcessor.peelAnItem(apple);

	}

}


/*
 * Given the above set of classes, you could later define a class Banana like this
 * Remember, In composition, subclass is the front end class.
 */

class Banana implements Peelable {
    private Fruit fruit = new Fruit();
    public int peel() {
        return fruit.peel();
    }
}