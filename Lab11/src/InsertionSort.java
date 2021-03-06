/**
 * Class that implements the Insertion sorting algorithm on an array
 * of Compareables.
 * @author Dakota
 *
 * @param <T>
 */
public class InsertionSort <T extends Comparable<? super T>> extends SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) {
		insertionSort(array, array.length);
		
	}
	private void insertionSort(T[] a, int n){
		for(int i = 1; i < n; i++){
			T key = a[i];
			int j = i - 1;
			while(j >= 0 && a[j].compareTo(key) > 0){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
			System.out.println(super.toString(a));
		}
	}

}
