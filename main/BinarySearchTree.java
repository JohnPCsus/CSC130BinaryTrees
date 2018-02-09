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
		Node n0 = null;
		Node n1 = root;
		//boolean found = false;
		if(key == root.getKey()){
			root = null;
			return;
		}
		while (n1 != null) {
			if (n1.getKey() == key) {
				nodeRemover(n0, n1);
				n1 = null;
			} else {
				n0 = n1;
				n1 = key > n1.getKey() ? n1.getRightChild() : n1.getLeftChild();
			}
		}
	}

	private void nodeRemover(Node n0, Node n1) {
		if (n0 == null) {
			root = null;
			return;
		}
		if (n1.getRightChild() != null) {
			n1.setKey(n1.getRightChild().getKey());
			n0 = n1;
			n1 = n1.getRightChild();
			nodeRemover(n0, n1);
		} else if (n1.getLeftChild() != null) {
			n1.setKey(n1.getLeftChild().getKey());
			n0 = n1;
			n1 = n1.getLeftChild();
			nodeRemover(n0, n1);
		} else {
			if (n1.equals(n0.getRightChild())) {
				n0.setRightChild(null);
			} else if (n1.equals(n0.getLeftChild())) {
				n0.setLeftChild(null);
			}
		}
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
