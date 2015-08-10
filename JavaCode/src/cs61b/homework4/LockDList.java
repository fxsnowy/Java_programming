/* LockDList.java */
package cs61b.homework4;

public class LockDList extends DList {

	/**
	 * newNode() calls the LockDListNode constructor. Use this method to
	 * allocate new LockDListNodes rather than calling the LockDListNode
	 * constructor directly.
	 * 
	 * @param item
	 *            the item to store in the node.
	 * @param prev
	 *            the node previous to this node.
	 * @param next
	 *            the node following this node.
	 */
	@Override
	protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);
	}

	/**
	 * LockDList() constructor for an empty LockDList.
	 */
	public LockDList() {
		// Compiler inserts super();
	}

	/**
	 * remove() removes "node" from this DList. If "node" is null, do nothing.
	 * Performance: runs in O(1) time.
	 */
	@Override
	public void remove(DListNode node) {
		
	if ( (node != null)
				&&  !(((LockDListNode)node).lock) )  {
		super.remove(node);
		}
	}

	
	/**
	 * lockNode() locks the node, if "node" is null do nothing.
	 * 
	 * @param node
	 */
	public void lockNode(DListNode node) {
		
		if ((node != null) && (node instanceof LockDListNode)) {
			((LockDListNode) node).lock = true;
		} 
		
	}

}