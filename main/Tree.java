package main;

import java.util.LinkedList;

public interface Tree{
	public abstract void insert(int n);

	public abstract boolean contains(int key);

	public abstract void remove(int key);
	public abstract LinkedList<Integer> inOrderTraversal();
		
	

	public class Node {
		private int key;
		private Node leftChild;
		private Node rightChild;

		public Node(int key) {
			this.key = key;
		}
		
		public int getKey() {
			return key;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}
		public void setKey(int newKey){
			key = newKey;
		}
		public void setLeftChild(Node newChild) {
			leftChild = newChild;
		}

		public void setRightChild(Node newChild) {
			rightChild = newChild;
		}
		
		
	}
}
