package functionalinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 1) a functional interface is one whose type can be used for a method
 * parameter when a lambda is to be supplied as the actual argument.
 *  Ex:
 *      public static <T> void sort(List<T> list, Comparator<? super T> c) {
 *         list.sort(c);
 *      } 
 * Here type 'Comparator' is a functional interface.
 * 
 * 2) Conceptually, a functional interface has exactly one abstract method,
 * not counting the public methods of 'class Object'.
 * 
 * 3) Why lambda? they make it easier to distribute processing of collections
 * over multiple threads.
 * 
 * 4) the compiler will treat any interface meeting the definition of a 
 * functional interface as a functional interface regardless of whether or
 * not a @FunctionalInterface annotation tagged on the interface declaration.
 * 
 * 5) A lambda expression is an instance of a functional interface type. 
 * 
 * 6) Instances of functional interfaces can be created with lambda expressions,
 * method references, or constructor references.
 * 
 * 7) lambda expressions can be passed and returned as first class objects.
 * 
 */
public class LambdaExpression {

	public static void main(String[] args) {
		List<String> a1 = new ArrayList<String>();
		a1.add("Zara");
		a1.add("Mahnaz");
		a1.add("Ayan");
		Collections.sort(a1,
							(p1, p2) -> p1.compareTo(p2)
							
						);
		System.out.println(a1.toString());
        
	}

}
