
/**
 * Abstract class for sorting algorithms. Parent class to Insertion Sort,
 * Merge Sort, and Selection Sort.
 * @author Dakota
 *
 * @param <T>
 */
public abstract class SortingAlgorithm <T extends Comparable <? super T>> extends Algorithm<T> {

	
	/**
	 * sorts the parameter array in ascending order (from smallest to largest)
	 */
	public abstract void sort (T[] array);
	
	/**
	 * Invoke the appropriate sorting algorithm
	 */
	public void apply(T[] array){
		this.sort(array);
	}
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> boolean isSorted(Comparable[] array){
		for (int i = 1; i < array.length ; i++){
			if(array[i - 1].compareTo(array[i]) > 0){
				return false;
			}
		}
		return true;
	}
	/** Task: Swaps the array elements a[i] and a[j].
	 *  @param a  an array of objects
	 *  @param i  an integer >= 0 and < a.length
	 *  @param j  an integer >= 0 and < a.length */
	protected void swap(T[] a, int i, int j)
	{
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	}
	public String toString(T[] array){
		String output = "";
		for(int i = 0; i < array.length; i++){
			output += "" + array[i] + ",";
		}
		return output;
	}
	
	public static void compareSorts(int n){
		SortingAlgorithm[] sorts = new SortingAlgorithm[3];
		
		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		
		Integer[][] sortArray = new Integer[3][n];
		sortArray[0] = createRandomArray(n);
		
		System.arraycopy(sortArray[0], 0, sortArray[1], 0, sortArray[0].length);
		System.arraycopy(sortArray[0], 0, sortArray[2], 0, sortArray[0].length);
		
		for (int i = 0; i < sorts.length; i++){
			long compTime = sorts[i].time(sortArray[i]);
			if(i == 0){
				System.out.println("Selection sort for " + n + " took: " + compTime + " ms.");
			} else if(i == 1){
				System.out.println("Insertion sort for " + n + " took: " + compTime + " ms.");
			} else {
					System.out.println("Merge sort for " + n + " took: " + compTime + " ms.");
				}
		}
	}

}
