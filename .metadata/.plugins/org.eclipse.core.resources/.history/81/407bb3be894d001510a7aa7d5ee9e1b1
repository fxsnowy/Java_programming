package JavaCollections.list;

import JavaCollections.list.DblyLinkList.DListNode;

public class LockableList<T> extends DblyLinkList<T> {

	
	class LockableNode<T> extends DListNode<T>{
		
		/**
		 * lock the node during creation of a node.
		 */
		private boolean lock; 
		
		

	}
	
	
	LockableNode<T> newNode(T item, DListNode<T> prev, DListNode<T> next) {
	    return new LockableNode(item, prev, next);
	 }
	 
	public LockableList(){
		this.sentinel = this.newNode(null, this.sentinel, this.sentinel);
	}
	 
	 
	

}
