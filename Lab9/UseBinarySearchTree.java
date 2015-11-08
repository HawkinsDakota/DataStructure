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
				
		Iterator<String> itr = tree.iterator();
		
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}
