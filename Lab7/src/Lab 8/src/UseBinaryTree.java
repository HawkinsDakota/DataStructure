/**
 * Demonstration of how to use the BinaryTree class
 */

import java.util.Iterator;

public class UseBinaryTree {

	public static void main(String[] args) {
		// represent each leaf as a one-node tree
		BinaryTreeInterface<String> dTree = new BinaryTree<String>("D");
		BinaryTreeInterface<String> gTree = new BinaryTree<String>("G");
		BinaryTreeInterface<String> lTree = new BinaryTree<String>("L");
		BinaryTreeInterface<String> tTree = new BinaryTree<String>("T");
		
		// now form larger trees
		BinaryTreeInterface<String> hTree = new BinaryTree<String>("H", gTree, lTree);
		BinaryTreeInterface<String> fTree = new BinaryTree<String>("F", dTree, hTree);
		BinaryTreeInterface<String> rTree = new BinaryTree<String>("R", null, tTree);
	
        // now create the root
		BinaryTreeInterface<String> mTree = new BinaryTree<String>("M", fTree, rTree);
        
        // call some methods	
		System.out.println("Root data = " + mTree.getRootData());
		System.out.println("Left most data = " + mTree.getLeftMostData());
		
		System.out.println("Size = " + mTree.getSize());
	
        // output the tree	
		System.out.println("Output the tree using printTree");
		mTree.printTree();
		
		System.out.println("Output the tree using inorder iterator");
		Iterator<String> itr = mTree.getInOrderIterator();
		
		while (itr.hasNext())
			System.out.println(itr.next());
		
        // remove leftmost data
		System.out.println("Removing " + mTree.removeLeftMostData());
		System.out.println("Left most data = " + mTree.getLeftMostData());
		System.out.println("Size = " + mTree.getSize());

		System.out.println("Output the tree using printTree");
		mTree.printTree();


        // maniacal test
        BinaryTreeInterface<String> aTree = new BinaryTree<String>("A");
        BinaryTreeInterface<String> cTree = new BinaryTree<String>("C");
        BinaryTreeInterface<String> eTree = new BinaryTree<String>("E");
        gTree = new BinaryTree<String>("G");
        BinaryTreeInterface<String> bTree = new BinaryTree<String>("B",aTree,cTree);
        fTree = new BinaryTree<String>("F",eTree,gTree);
        dTree = new BinaryTree<String>("D",bTree,fTree);

        itr = dTree.getPostOrderIterator();

        System.out.println("iterator");

        while (itr.hasNext())
            System.out.println(itr.next());

        for (int i = 0; i < 7; i++) {
            System.out.println("delete right most " + dTree.removeRightMostData());
            itr = dTree.getPostOrderIterator();

            System.out.println("iterator");

            while (itr.hasNext())
                System.out.println(itr.next());
        }
	}
}
