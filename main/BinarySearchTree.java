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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub

	}

	public LinkedList<Integer> inOrderTraversal() {
		return inOrderTraversal(root);
	}

	private LinkedList<Integer> inOrderTraversal(Node n) {
		
		java.util.LinkedList<Integer> values = new java.util.LinkedList<>();
		Node currentNode = n;
		
		if(n.getLeftChild()!=null){
			values.addAll(inOrderTraversal(n.getLeftChild()));
		}
		values.add(n.getKey());
		if(n.getRightChild()!=null){
			values.addAll(inOrderTraversal(n.getRightChild()));
		}
		
		

		return values;
	}

}
