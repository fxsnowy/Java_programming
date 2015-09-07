package StaticMemberClasses;


/*
 * An interface is a static interface, when declared as a member of
 * a top level interface.
 * 
 * An interface within an interface can only be public.
 * 
 * 
 */



interface Map<K,V> {
	
    interface Entry<K,V> {
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object o);
        int hashCode();
    }
}

class HashMap<K,V> implements Map<K, V>{
	
	transient Node<K,V>[] table; // transient mean member variable 'table' not to be 
								 // serialised when it is persisted to streams of bytes.
	
	static class Node<K,V> implements Map.Entry<K,V> {
		private Object key;
		private Object value;
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
 
public class NestedInterfaceInInterface {
	
	public static void main(String[] args) {
		
	}
}