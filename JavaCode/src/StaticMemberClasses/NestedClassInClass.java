package StaticMemberClasses;

/*
 * All accessibility modifiers are available to the static member class.
 */

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Collections {
	
    static class UnmodifiableCollection<E>  implements Collection<E>, Serializable {
    	
    	final Collection<? extends E> c;
    	
    	UnmodifiableCollection(Collection<? extends E> c) {
            if (c==null)
                throw new NullPointerException();
            this.c = c;
        }

		@Override
		public int size() { return 0; }

		@Override
		public boolean isEmpty() { return false; }

		@Override
		public boolean contains(Object o) { return false; }

		@Override
		public Iterator<E> iterator() { return null; }

		@Override
		public Object[] toArray() { return null; }

		@Override
		public <T> T[] toArray(T[] a) { return null; }

		@Override
		public boolean add(E e) { return false; }

		@Override
		public boolean remove(Object o) { return false; }

		@Override
		public boolean containsAll(Collection<?> c) { return false; }

		@Override
		public boolean addAll(Collection<? extends E> c) { return false; }

		@Override
		public boolean removeAll(Collection<?> c) {	return false; }

		@Override
		public boolean retainAll(Collection<?> c) { return false; }

		@Override
		public void clear() {  }
		
	} // end UnmodifiableCollection
    
    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) {
        return new UnmodifiableCollection<>(c);
    }
    
}


/*
 * Usage would be like 'Collections.UnmodifiableCollection.method'
 * 
 */

public class NestedClassInClass {

	public static void main(String[] args) {
		//Collections.UnmodifiableCollection<String> = new Collections.UnmodifiableCollection<String>();
		
	}
	
}
