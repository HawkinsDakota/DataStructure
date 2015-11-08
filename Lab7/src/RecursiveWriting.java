/**
 * Class with recursive methods for printing stuff
 * and finding a product of squares
 * @author Dakota Hawkins and Jack Anderson
 * @date March 4, 2015
 *
 */
public class RecursiveWriting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("hello");
		//printLine('*',5);
		//System.out.println("world");
		//printBlock('*', 5,3);
		//System.out.println(" ");
		//printTriangle(5);
		System.out.println(product(5));
	
	}
	/**
	 * Recursive method to print spaces
	 * @param num
	 */
	public static void indent (int num){
		if(num == 1){
			System.out.print(" ");
		}else{
			System.out.print(" ");
			indent(num-1);
		}
	}
	/**
	 * Recursive method that prints type n many times 
	 * on a line
	 * @param type
	 * @param num
	 */
	public static void printLine(char type, int num){
		if(num ==1){
			System.out.print(type);
		}else{
			System.out.print(type);
			printLine(type, num-1);
		}
	}
	/**
	 * Recursive method to print type num many times on a line
	 * for lines many lines.
	 * @param type
	 * @param num
	 * @param lines
	 */
	public static void printBlock(char type, int num, int lines){
		if(lines == 1){
			printLine(type, num);
		}else {
			printLine(type,num);
			System.out.println();
			printBlock(type, num, lines-1);
		}
	}
	/**
	 * Prints a triangle with longest point width
	 * @param width
	 */
	public static void printTriangle(int width){
		triangleHelper(width, true);
		triangleHelper(width, false);
	}
	/**
	 * helper method to recursively print triangle
	 * @param width
	 * @param forwards
	 */
	private static void triangleHelper(int width, boolean forwards){
		if(forwards){
			if(width==1){
				printLine('*',width);
				System.out.println();
			}else{
				triangleHelper(width-1,forwards);
				printLine('*', width);
				System.out.println();
			}
				
		}else if(!forwards){
			if(width==1){
				printLine('*',width);
				System.out.println();
			}else{
				printLine('*', width);
				System.out.println();
				triangleHelper(width-1,false);
				}
		}
	}
	/**
	 * Method to find the product of squares
	 * @param n
	 * @return
	 */
	public static int product (int n){
		if(n == 1){
			return 1;
		} else {
			return n*n*product(n-1);
		}
	}

}
