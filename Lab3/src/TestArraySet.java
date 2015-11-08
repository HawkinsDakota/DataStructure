import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for ArraySet class.
 * 
 * @author Dakota Hawkins and Harry Hause
 * @date January 19, 2015
 */

public class TestArraySet {

	@Test
	//Unit test to constructor method of ArraySet object
	public void testConstructor() {
		try {
			Set newSet = new ArraySet(-1);
			fail("Should have caused exception");
		}
		catch (IllegalArgumentException iae) {}

		Set newSet = new ArraySet(10);
		assertEquals(10, newSet.getCapacity());
	}

	@Test
	//Unit test for adding new elements to an ArraySet.
	public void testAdd(){
		Set newSet = new ArraySet(3);
		newSet.add(1);
		newSet.add(2);
		newSet.add(3);
		assertEquals(3, newSet.getSize());
		assertEquals(3, newSet.getCapacity());
		newSet.add(4);
		assertEquals(4, newSet.getSize());
	}

	@Test
	//Unit test for adding multiple elements to 
	//an ArraySet
	public void testAddAll(){
		String [] letters = {"A", "B", "C", "D", "E"};

		Set newSet = new ArraySet(4);
		newSet.addAll(letters);
		assertEquals(5, newSet.getSize());
	}

	@Test
	//Unit test that tests the contains method
	//of ArraySets.
	public void testContains(){
		Set newSet = new ArraySet();
		assertFalse(newSet.contains(1));
		newSet.add(1);
		assertTrue(newSet.contains(1));

	}

	@Test
	//Unit test to test the remove method
	//of ArraySets
	public void testRemove(){
		Set newSet = new ArraySet();
		newSet.remove(1);
		assertEquals(0, newSet.getSize());
		newSet.add(1);
		assertEquals(1, newSet.getSize());
	}

	@Test
	//Unit test to test for duplicates
	//in an ArraySet
	public void testDuplicates(){
		Set newSet = new ArraySet();
		String [] letters = {"A", "B", "B"};
		newSet.addAll(letters);
		assertEquals(2, newSet.getSize());

	}

	@Test
	//Unit test to test set union
	//for an ArraySet
	public void testUnion(){
		Set s1 = new ArraySet();
		Set s2 = new ArraySet();
		Set s3 = new ArraySet();
		
		Integer [] nums1 = {1,2,3,4,5};
		Integer [] nums2 = {10,2,3,15};
		
		for (int i = 0; i < nums1.length; i++){
			s1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++){
			s2.add(nums2[i]);
		}
		
		s3 = s1.union(s2);
		
		assertEquals(7, s3.getSize());
		assertTrue(s3.contains(1));
		assertTrue(s3.contains(10));
		
	}

	@Test
	//Unit test to test for the 
	//Intersection of two ArraySets
	public void testIntersection(){
		Set s1 = new ArraySet();
		Set s2 = new ArraySet();
		Set s3 = new ArraySet();
		
		Integer [] nums1 = {1,2,3,4,5};
		Integer [] nums2 = {10,2,3,15};
		
		for (int i = 0; i < nums1.length; i++){
			s1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++){
			s2.add(nums2[i]);
		}
		
		s3 = s1.intersection(s2);
		
		assertEquals(2, s3.getSize());
		assertTrue(s3.contains(2));
		assertTrue(s3.contains(3));
	}

	@Test
	//Unit test to test the set difference
	//of two different ArraySets
	public void testDifference(){
		Set s1 = new ArraySet();
		Set s2 = new ArraySet();
		Set s3 = new ArraySet();
		
		Integer [] nums1 = {1,2,3,4,5};
		Integer [] nums2 = {10,2,3,15};
		
		for (int i = 0; i < nums1.length; i++){
			s1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++){
			s2.add(nums2[i]);
		}
		
		s3 = s1.difference(s2);
		
		assertEquals(3, s3.getSize());
		assertTrue(s3.contains(1));
		assertTrue(s3.contains(4));
		assertTrue(s3.contains(5));
	}

}


