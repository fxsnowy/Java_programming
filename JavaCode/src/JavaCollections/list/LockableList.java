package JavaCollections.list;

import JavaCollections.list.DblyLinkList.DListNode;

public class LockableList<T> extends DblyLinkList<T> {

	protected class LockableNode extends DListNode {

		/**
		 * lock the node during creation of a node.
		 */
		private boolean lock;

		LockableNode(T item, DListNode p,
				DListNode n) {
			super(item, p, n); // this does not work
			this.lock = false;
		}

	}

	LockableNode newNode(T item, DListNode prev, DListNode next) {
		return new LockableNode(item, prev, next);
	}

	public LockableList() {
		this.sentinel = this.newNode(null, this.sentinel, this.sentinel);
	}

}
