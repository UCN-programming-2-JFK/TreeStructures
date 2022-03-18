package binarytree;

import java.util.*;

public class BinaryStringTreeIteratorImplementation implements Iterable<BinaryStringNode> {

	private BinaryStringNode root = null;

	public boolean isEmpty() {
		return root == null;
	}

	public BinaryStringNode getRoot() {
		return root;
	}

	public void setRoot(BinaryStringNode root) {
		this.root = root;
	}

	public int size() {
		if (getRoot() == null) {
			return 0;
		} else {
			return getRoot().getNumberOfDescendants() + 1;
		}
	}

	@Override
	public String toString() {
		if (getRoot() == null) {
			return "Tree is empty";
		}
		return "Tree has " + size() + " elements.";
	}

	@Override
	public Iterator<BinaryStringNode> iterator() {
		return new PreOrderIterator(getRoot());
	}

	private class PreOrderIterator implements Iterator<BinaryStringNode> {

		Queue<BinaryStringNode> nodeQueue = new LinkedList<BinaryStringNode>();

		private PreOrderIterator(BinaryStringNode rootNode) {
			if (rootNode != null) {
				addNodeInOrder(rootNode);
			}
		}

		private void addNodeInOrder(BinaryStringNode node) {
			if (node.getLeft() != null) {
				addNodeInOrder(node.getLeft());
			}
			nodeQueue.add(node);
			if (node.getRight() != null) {
				addNodeInOrder(node.getRight());
			}
		}

		@Override
		public boolean hasNext() {
			return !nodeQueue.isEmpty();
		}

		@Override
		public BinaryStringNode next() {
			return nodeQueue.remove();
		}
	}
}