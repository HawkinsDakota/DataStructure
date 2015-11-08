/**
 * Demonstration of using binary search tree
 */

import java.util.Iterator;


public class UseBinarySearchTree {

	public static void main(String[] args) {
		SearchTreeInterface<String> tree = new BinarySearchTree<String>();
		
		System.out.println(tree.add("F"));
		System.out.println(tree.add("G"));
		System.out.println(tree.add("H"));
		System.out.println(tree.add("A"));
		System.out.println(tree.add("C"));
		System.out.println(tree.add("B"));
		System.out.println(tree.add("S"));
				
		System.out.println(tree.size());
		//System.out.println(tree.contains("F"));
		//System.out.println(tree.contains("Z"));
	
		Iterator<String> itr = tree.iterator();
		System.out.println(tree.contains("C"));
		System.out.println("This is where we remove.");
		System.out.println(tree.remove("C"));
		System.out.println(tree.contains("C"));
		System.out.println(tree.contains("Z"));
		Iterator<String> itr1 = tree.iterator();
		
		while (itr1.hasNext())
			System.out.println(itr1.next());
	}
}
