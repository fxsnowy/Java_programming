package EnhancedForStatement;

/*
 * Here is my understanding on significance of using `Iterable` and `Iterator` in pre 1.8 java.
 * 1) `java.util.AbstractList` is `Iterable` because it implements,
 * `Iterator<T> iterator();`, which is a contract for any class to be `Iterable`.
 * 
 * 2) `java.util.AbstractList` implements,  `Iterator<T> iterator();` by creating an
 * instance level inner class, `private class Itr implements Iterator<E> { ... }`
 * that implements `hasNext`, `next` and `remove` methods.
 * 
 * `private class ListItr extends Itr implements ListIterator<E>{..}` is just an
 *  extra facility over above iterator for `List` type implementations.
 *  
 * 3) This is the only purpose of `Iterable` and `Iterator` interafces. 
 *  
 */
public class Example3 {

	public static void main(String[] args) {
		

	}

}
