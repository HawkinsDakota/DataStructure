/**
 * Unit tests to test implementation of Stack interface.
 */
import static org.junit.Assert.*;

import org.junit.Test;


public class TestListStack {

	@Test
	public void test() {
		Stack<String> s = new ListStack<String>();
		
		assertTrue(s.isEmpty());
		assertNull(s.peek());
		assertNull(s.pop());
		
		s.push("apple");
		s.push("banana");
		s.push("cherry");
		
		assertFalse(s.isEmpty());
		
		assertEquals("cherry", s.peek());
		assertEquals("cherry", s.pop());
		assertEquals("banana", s.peek());
		assertEquals("banana", s.pop());
		assertEquals("apple", s.peek());
		assertEquals("apple", s.pop());
		
		assertTrue(s.isEmpty());
		assertNull(s.pop());
	}

}
