/**
 * Unit tests to test implementation of AbstractList interface.
 */
import static org.junit.Assert.*;

import org.junit.Test;


public class TestList {

	@Test
	public void testAddFront() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
		
		l.addFront("cherry");
		l.addFront("banana");
		l.addFront("apple");
		
		assertFalse(l.isEmpty());
		assertEquals(3,l.getLength());
	}
	
	@Test
	public void testAddRear() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
		
		l.addRear("apple");
		l.addRear("banana");
		l.addRear("cherry");
		
		assertFalse(l.isEmpty());
		assertEquals(3,l.getLength());
	}
	
	@Test
	public void testRemoveFront() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
		
		l.addFront("cherry");
		l.addFront("banana");
		l.addFront("apple");
		
		assertFalse(l.isEmpty());
		assertEquals(3,l.getLength());
		
		assertEquals("apple",l.removeFront());
		assertEquals("banana",l.removeFront());
		assertEquals("cherry",l.removeFront());
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
	}
	
	@Test
	public void testRemoveRear() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
		
		l.addRear("apple");
		l.addRear("banana");
		l.addRear("cherry");
		
		assertFalse(l.isEmpty());
		assertEquals(3,l.getLength());
		
		assertEquals("cherry",l.removeRear());
		assertEquals("banana",l.removeRear());
		assertEquals("apple",l.removeRear());
		
		assertTrue(l.isEmpty());
		assertEquals(0,l.getLength());
	}
	
	@Test
	public void testGetFrequency() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertEquals(0,l.getFrequency("apple"));
		
		l.addFront("banana");
		l.addFront("apple");
		l.addRear("apple");
		
		assertEquals(2,l.getFrequency("apple"));
	}
	
	@Test
	public void testContains() {
		AbstractList<String> l = new LinkedList<String>();
		
		assertFalse(l.contains("apple"));
		
		l.addFront("banana");
		l.addFront("apple");
		l.addRear("apple");
		
		assertTrue(l.contains("apple"));	
	}
	
	@Test
	public void testIteration() {
		AbstractList<String> l = new LinkedList<String>();
		
		l.addFront("banana");
		l.addFront("apple");
		l.addRear("cherry");
		l.addRear("donut");
		
		java.util.Iterator<String> itr = l.iterator();
		
		assertTrue(itr.hasNext());
		
		assertEquals("apple", itr.next());
		assertEquals("banana", itr.next());
		assertEquals("cherry", itr.next());
		assertEquals("donut", itr.next());
		
		assertFalse(itr.hasNext());
	}

}
