package main;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

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
		testTree.insert(-3);
		testTree.insert(-2);
		testTree.insert(0);
		for (int i = 0; i < 100; i++) {
			testTree.insert(ThreadLocalRandom.current().nextInt(-100, 100 + 1));
		}
		LinkedList<Integer> testList = testTree.inOrderTraversal();
		System.out.println(testList.toString());
	}

	@Test
	public void testContains() {
		Tree testTree = new BinarySearchTree();
		
		assertFalse(testTree.contains(1));
		
		testTree.insert(1);
		assertEquals(true, testTree.contains(1));
		
		testTree.insert(2);
		testTree.insert(0);
		assertEquals(true, testTree.contains(1));
		assertTrue(testTree.contains(2));
		assertTrue(testTree.contains(0));
		assertFalse(testTree.contains(5));
		assertFalse(testTree.contains(-5));

	}

	@Test
	public void testRemove() {
		Tree testTree = new BinarySearchTree();
		testTree.insert(0);
		assertTrue(testTree.contains(0));
		testTree.remove(0);
		assertFalse(testTree.contains(0));
		testTree.insert(2);
		testTree.insert(3);
		testTree.insert(1);
		testTree.remove(1);
		assertFalse(testTree.contains(1));
		testTree.remove(3);
		assertFalse(testTree.contains(3));
		
		
	}

}
