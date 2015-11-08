/**
 * Demonstration of how to use the BinaryTree class
 */

import java.util.Iterator;

public class TestManiacal
{
	public static void main(String[] args) {

        // maniacal test
        BinaryTreeInterface<String> aTree = new BinaryTree<String>("A");
        BinaryTreeInterface<String> cTree = new BinaryTree<String>("C");
        BinaryTreeInterface<String> eTree = new BinaryTree<String>("E");
        BinaryTreeInterface<String> gTree = new BinaryTree<String>("G");
        BinaryTreeInterface<String> bTree = new BinaryTree<String>("B",aTree,cTree);
        BinaryTreeInterface<String> fTree = new BinaryTree<String>("F",eTree,gTree);
        BinaryTreeInterface<String> dTree = new BinaryTree<String>("D",bTree,fTree);

        java.util.Iterator<String> itr = dTree.getPostOrderIterator();

        System.out.println("Height = " + dTree.getHeight() + " Size = " + dTree.getSize() + " iterator:");

        while (itr.hasNext())
            System.out.println(itr.next());

        for (int i = 0; i < 7; i++) {
            System.out.println("delete right most " + dTree.removeRightMostData());
            itr = dTree.getPostOrderIterator();

            System.out.println("Height = " + dTree.getHeight() + " Size = " + dTree.getSize() + " iterator:");

            while (itr.hasNext())
                System.out.println(itr.next());
        }
	}
}
