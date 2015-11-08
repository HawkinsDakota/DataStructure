import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A JUnit test case class for the insertion, selection, and merge sorts.
 * 
 * @author Greg Gagne
 */
public class SortingTest {

	/** test isSorted method from SortingAlgorithm */
	@Test
	public void testIsSorted() {
		assertTrue(SortingAlgorithm.isSorted(new Integer[] {1,2,3}));
		assertTrue(SortingAlgorithm.isSorted(new Integer[] {1,1,1}));
		assertTrue(SortingAlgorithm.isSorted(new Integer[] {-3,1,3}));
		assertTrue(SortingAlgorithm.isSorted(new Integer[] {0,0,0}));
		assertFalse(SortingAlgorithm.isSorted(new Integer[] {1,3,2}));
		assertFalse(SortingAlgorithm.isSorted(new Integer[] {2,1,3}));
		assertFalse(SortingAlgorithm.isSorted(new Integer[] {2,3,1}));
		assertFalse(SortingAlgorithm.isSorted(new Integer[] {3,1,2}));
		assertFalse(SortingAlgorithm.isSorted(new Integer[] {3,2,1}));
	}


	/** test SelectionSort.sort */
	@Test
	public void testSelectionSort() {
		SortingAlgorithm<Integer> sorter = new SelectionSort<Integer>();
		// all combinations of 1, 2, 3
		Integer[] array = {1,2,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,3,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,1,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,3,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,2,1};
		sorter.sort(array);
		// double-check negative numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {0,-1,-3};
		sorter.sort(array);
		// duplicate 0's
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,0,0};
		sorter.sort(array);
		// duplicate positive numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
	}
	
	 /** test InsertionSort.sort */
	 @Test
	public void testInsertionSort() {
		SortingAlgorithm<Integer> sorter = new InsertionSort<Integer>();
		// all combinations of 1, 2, 3
		Integer[] array = {1,2,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,3,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,1,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,3,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,2,1};
		sorter.sort(array);
		// double-check negative numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {0,-1,-3};
		sorter.sort(array);
		// duplicate 0's
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,0,0};
		sorter.sort(array);
		// duplicate positive numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
	}
	
	 /** test MergeSort.sort */
	@Test
	public void testMergeSort() {
		SortingAlgorithm<Integer> sorter = new MergeSort<Integer>();
		// all combinations of 1, 2, 3
		Integer[] array = {1,2,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,3,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,1,3};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {2,3,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,2};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,2,1};
		sorter.sort(array);
		// double-check negative numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {0,-1,-3};
		sorter.sort(array);
		// duplicate 0's
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {1,0,0};
		sorter.sort(array);
		// duplicate positive numbers
		assertTrue(SortingAlgorithm.isSorted(array));
		array = new Integer[] {3,1,1};
		sorter.sort(array);
		assertTrue(SortingAlgorithm.isSorted(array));
	}
	
	
	
}
