package main;
import java.util.LinkedList;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTests {

	@Test
	public void testInsert() {
		Tree testTree = new BinarySearchTree();
		testTree.insert(1);
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(-1);
		testTree.insert(-2);
		LinkedList<Integer> testList = testTree.inOrderTraversal();
		System.out.println(testList.toString());
	}

	@Test
	public void testContains() {
		// fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		// fail("Not yet implemented");
	}

}
