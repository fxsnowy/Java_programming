
/* DblyLinkList.java */

package JavaCollections.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Dlist using sentinel node
 * 
 * @author mohet01
 *
 * @param <T>
 */
public class DblyLinkList<T> implements Iterable<T> {

	/*
	 * Representation - starts
	 */
	/**
	 * DListNode is a node in a DblyLinkList
	 * 
	 * @author mohet01
	 *
	 */
	class DListNode {

		/**
		 * item references the item stored in the current node. prev references
		 * the previous node in the DList. next references the next node in the
		 * DList.
		 *
		 * 
		 */

		private T item;
		private DListNode prev;
		private DListNode next;

		DListNode(T item, DListNode p, DListNode n) {
			this.item = item;
			this.prev = p;
			this.next = n;
		}

	}

	private class Itr implements Iterator<T> {

		private DListNode currentPosition = sentinel;

		private int lastRet = -1;

		@Override
		public boolean hasNext() {
			return currentPosition.next != sentinel;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (currentPosition.next == sentinel) {
				throw new NoSuchElementException();
			}
			T nextItem = currentPosition.next.item;
			lastRet = +1;
			currentPosition = currentPosition.next; // points to the node that
													// is already read
			return nextItem;
		}

		@Override
		public void remove() throws NoSuchElementException {
			if (lastRet < 0) {
				throw new IllegalStateException();
			} else {
				// this item is already read using next()
				currentPosition.item = null;
				currentPosition.prev.next = currentPosition.next;
				currentPosition.next.prev = currentPosition.prev;
				currentPosition = currentPosition.prev;
				lastRet = -1;
			}
		}
	}

	/**
	 * sentinel references the sentinel node.
	 *
	 * Being sentinel as part of implementation detail, will avoid null checks,
	 * while performing mutable operations on list.
	 * 
	 * DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
	 * 
	 */
	protected DListNode sentinel;
	protected int size;

	/**
	 * newNode() calls the DListNode constructor. Use this class to allocate new
	 * DListNodes rather than calling the DListNode constructor directly. That
	 * way, only this method needs to be overridden if a subclass of DList wants
	 * to use a different kind of node.
	 * 
	 * @param item
	 *            the item to store in the node.
	 * @param prev
	 *            the node previous to this node.
	 * @param next
	 *            the node following this node.
	 */
	DListNode newNode(T item, DListNode prev, DListNode next) {
		return new DListNode(item, prev, next);
	}

	/*
	 * Representation - ends
	 * 
	 * DblyLinkList invariants: 1) sentinel != null. 2) For any DListNode x in a
	 * DblyLinkList, x.next != null. 3) For any DListNode x in a DblyLinkList,
	 * x.prev != null. 4) For any DListNode x in a DblyLinkList, if x.next == y,
	 * then y.prev == x. 5) For any DListNode x in a DblyLinkList, if x.prev ==
	 * y, then y.next == x. 6) size is the number of DListNode's, NOT COUNTING
	 * the sentinel (referenced by "sentinel"), that can be accessed from the
	 * sentinel by a sequence of "next" references.
	 */

	/*
	 * User Interface - starts
	 */
	/**
	 * DblyLinkList() constructor for an empty DblyLinkList.
	 */
	public DblyLinkList() {
		this.sentinel = this.newNode(null, this.sentinel, this.sentinel);
	}

	/**
	 * Return the size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	public void remove(int index) throws NoSuchElementException {
		if (index > size()) {
			throw new NoSuchElementException();
		}
		DListNode node;
		for (node = sentinel; index-- > 0; node = node.next)
			;
		node.item = null;
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	/**
	 * Inserts a non-sentinel node at front of the list.
	 * 
	 * @param item
	 */

	public void insertFront(T item) {

		DListNode node = this.newNode(item, this.sentinel, this.sentinel.next);
		node.next.prev = node;
		sentinel.next = node;
		this.size++;
	}

	/**
	 * insertBack() inserts an item at the back of this DList.
	 * 
	 * @param item
	 *            is the item to be inserted. Performance: runs in O(1) time.
	 */
	public void insertBack(T item) {
		DListNode node = this.newNode(item, this.sentinel.prev, this.sentinel);
		this.sentinel.prev = node;
		node.prev.next = node;
		this.size++;
	}

	
	
	
	/**
	 * Remove first non-sentinel node from the list. Do not require size check
	 * before remove operation
	 * 
	 */
	public void removeFront() throws UnsupportedOperationException {
		if (this.size() < 0) {
			throw new UnsupportedOperationException("removeFront");
		} else {
			sentinel.next.next.prev = sentinel;
			sentinel.next = sentinel.next.next;
			this.size--;
		}
	}

	public T get(int index) throws NoSuchElementException {
		if (index > size())
			throw new NoSuchElementException();
		DListNode node;
		for (node = sentinel; index-- > 0; node = node.next)
			;
		return node.item;
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

}
