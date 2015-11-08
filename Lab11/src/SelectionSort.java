/**
 * Class that implements the selection sort algorithm on an array of compearables.
 * @author Dakota
 *
 * @param <T>
 */
public class SelectionSort <T extends Comparable <? super T>> extends SortingAlgorithm<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable[] array) {
		this.selectionSort((T[]) array, array.length);
	}
	/*
	 * Sorts the first n objects in an array into ascending order
	 * using selection sort algorithm.
	 */

	public void selectionSort(T[] a, int n) 
	{
		for (int index = 0; index < n - 1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			super.swap(a, index, indexOfNextSmallest);
			System.out.println(super.toString(a));
		} 
	} 

	/** Task: Finds the index of the smallest value in a portion of an 
	 *        array.
	 *  @param a      an array of Comparable objects
	 *  @param first  an integer >= 0 and < a.length that is the index of 
	 *                the first array element to consider
	 *  @param last   an integer >= first and < a.length that is the index 
	 *                of the last array element to consider
	 *  @return the index of the smallest value among
	 *          a[first], a[first + 1], . . . , a[last] */
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last)
	{
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++)
		{
			if (a[index].compareTo(min) < 0)
			{
				min = a[index];
				indexOfMin = index;
			} 
		} 
		return indexOfMin;
	}
}
