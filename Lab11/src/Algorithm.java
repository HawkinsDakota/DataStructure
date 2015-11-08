
import java.util.Random;
/**
 * Abstract class for Algorithms. Used as a parent class for
 * Sorting Algorithms.
 * @author Dakota
 *
 * @param <T>
 */
public abstract class Algorithm < T extends Comparable < ? super T>> {

	public abstract void apply(T[] array);
	
	public long time(T[] array){
		long start, end;
		start = System.currentTimeMillis();
		
		//invoke the apply method
		this.apply(array);
		end = System.currentTimeMillis();
		
		//returns elapsed time
		return (end - start);
	}
	
	/**
	 * Create an array containing n random Integers.
	 */
	public static Integer[] createRandomArray(int n){
		Integer[] integerArray = new Integer[n];
		Random randomGenerator = new Random();
		
		for (int i = 0; i < n; i++){
			integerArray[i] = randomGenerator.nextInt();
		}
		return integerArray;
	}
}
