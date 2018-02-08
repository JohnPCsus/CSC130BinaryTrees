package main;

import java.util.LinkedList;

public class BinarySearchTree implements Tree {
	private Node root;

	@Override
	public void insert(int key) {
		Node currentNode = root;
		boolean inserted = false;
		if (root == null) {
			root = new Node(key);
			inserted = true;
		}
		while (!inserted) {
			if (key < currentNode.getKey()) {
				if (currentNode.getLeftChild() == null) {
					currentNode.setLeftChild(new Node(key));
					inserted = true;
				} else {
					currentNode = currentNode.getLeftChild();
				}
			} else {
				if (currentNode.getRightChild() == null) {
					currentNode.setRightChild(new Node(key));
					inserted = true;
				} else {
					currentNode = currentNode.getRightChild();
				}
			}
		}

	}

	@Override
	public boolean contains(int key) {
		return contains(key, root);
		// if(root == null){
		// return false;
		// }
		// if(root.getKey()==key){
		// return true;
		// }
		// else{
		// return this.contains(key,root);
		// }
	}

	private boolean contains(int key, Node n) {
		if (n == null) {
			return false;
		}
		if (n.getKey() == key) {
			return true;
		} else if (key > n.getKey()) {
			return contains(key, n.getRightChild());
		} else {
			return contains(key, n.getLeftChild());
		}
	}

	@Override
	public void remove(int key) {
		if (!contains(key)) {
			return;
		} else if (key == root.getKey() && hasChildren(root)) {
			nodeRemover(root);
		} else if (key == root.getKey()) {
			root = null;
			return;
		} else {
			removeSearcher(key, root);
		}
	}

	private void removeSearcher(int key, Node n) {
		if (key > n.getKey()) {
			if (n.getRightChild() == null) {
				return;
			} else if (key == n.getRightChild().getKey()) {
				if (hasChildren(n.getRightChild())) {
					nodeRemover(n.getRightChild());
				} else {
					n.setRightChild(null);
				}
			} else {
				removeSearcher(key, n.getRightChild());
			}
		} else {
			if (n.getLeftChild() == null) {
				return;
			} else if (key == n.getLeftChild().getKey()) {
				if (hasChildren(n.getLeftChild())) {
					nodeRemover(n.getLeftChild());
				} else {
					n.setRightChild(null);
				}
			} else {
				removeSearcher(key, n.getLeftChild());
			}
		}

	}

	private void nodeRemover(Node n) {
		n.setKey(n.getRightChild().getKey());
	}

	public LinkedList<Integer> inOrderTraversal() {
		return inOrderTraversal(root);
	}

	private LinkedList<Integer> inOrderTraversal(Node n) {

		java.util.LinkedList<Integer> values = new java.util.LinkedList<>();
		Node currentNode = n;

		if (n.getLeftChild() != null) {
			values.addAll(inOrderTraversal(n.getLeftChild()));
		}
		values.add(n.getKey());
		if (n.getRightChild() != null) {
			values.addAll(inOrderTraversal(n.getRightChild()));
		}

		return values;
	}

	private boolean hasChildren(Node n) {
		return !(n.getLeftChild() == null && n.getRightChild() == null);
	}

}
