
public class Homework7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] firstArray = {5,7,4,9,8,5,6,3};
		Integer[] secondArray = {80,90,85,70,60,40,95,50};
		
		SelectionSort sSort = new SelectionSort();
		//sSort.sort(firstArray);
		InsertionSort iSort = new InsertionSort();
		//iSort.sort(firstArray);
		MergeSort mSort = new MergeSort();
		mSort.sort(secondArray);

	}

}
