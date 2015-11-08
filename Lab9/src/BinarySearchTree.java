/**
 * Binary search tree implementation.
 * 
 * We do not allow duplicates.
 * 
 * @author Greg Gagne
 */
import java.util.Iterator;


public class BinarySearchTree <T extends Comparable<? super T>> implements SearchTreeInterface<T> 
{
	private BinaryTreeNode root;

	/**
	 * Private inner class for binary tree node
	 */
	private class BinaryTreeNode
	{
		private T data;
		private BinaryTreeNode leftChild;
		private BinaryTreeNode rightChild;

		private BinaryTreeNode(T data, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		// returns the data for a node
		private T getData() {
			return data;
		}

		// sets the data for a node
		private void setData(T data) {
			this.data = data;
		}

		// returns the left child of a node
		private BinaryTreeNode getLeftChild() {
			return leftChild;
		}

		// returns the right child of a node
		private BinaryTreeNode getRightChild() {
			return rightChild;
		}

		// sets the left child of a node
		private void  setLeftChild(BinaryTreeNode leftChild) {
			this.leftChild = leftChild;
		}

		// sets the right child of a node
		private void setRightChild(BinaryTreeNode rightChild) {
			this.rightChild = rightChild;
		}
	}

	/**
	 * Create an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		if(root == null){
			return false;
		}
		return true;
	}

	/**
	 * Solution that uses recursive helper method. 
	 */
	public T add(T item) {
		if (contains(item))
			return null;
		else {
			root = add(item, root);

			return item;
		}
	}

	/**
	 * private helper method for adding a node to the binary search tree
	 * @param item
	 * @param subtree
	 * @return the root of the tree
	 */
	private BinaryTreeNode add(T item, BinaryTreeNode subtree) {
		if (subtree == null) {
			// we have found the spot for the addition

			//  create the new node
			return new BinaryTreeNode(item, null, null);
		}

		int direction = item.compareTo(subtree.getData());

		if (direction < 0) {
			subtree.setLeftChild( add(item, subtree.getLeftChild()) );
		}
		else if (direction > 0) {
			subtree.setRightChild( add(item, subtree.getRightChild()) );
		}

		return subtree;
	}

	/**
	 * Non-recursive algorithm for addition
	 */
	/*public T add(T item) {
		if (contains(item))
			return null;

		//  create the new node
		BinaryTreeNode newNode = new BinaryTreeNode(item, null, null);

		// if the tree is empty, set the root to the new node
		if (isEmpty()) {
			root = newNode;
		}
		else {
			// treat it like an unsuccessful search
			BinaryTreeNode node = root;
			boolean keepLooking = true;

			while (keepLooking) {
				if (item.compareTo(node.getData()) < 0) {
					// go left
					if (node.getLeftChild() == null) {
						// we found the place for the insert
						node.setLeftChild(newNode);
						keepLooking = false;
					}
					else
						node = node.getLeftChild();
				}
				else if (item.compareTo(node.getData()) > 0) {
					// go right
					if (node.getRightChild() == null) {
						// we found the place for the insert
						node.setRightChild(newNode);
						keepLooking = false;
					}
					else
						node = node.getRightChild();
				}
			}
		}

		return item;
	}*/


	public boolean contains(T item) {				
		return contains(item, root);
	}
	private boolean contains(T item, BinaryTreeNode subtree){
		if(subtree == null){
			return false;
		}
		int direction = item.compareTo(subtree.getData());
		if (direction < 0){
			return contains(item, subtree.leftChild);
		}else if (direction > 0){
			return contains(item,subtree.rightChild);
		}
		return true;
	}
	public T remove(T item) {
		if (this.contains(item)) {
			return remove(item, root).getData();
		} else {
			return null;
		}
	}
	private BinaryTreeNode remove(T item, BinaryTreeNode subtree){
		if (subtree == null){
			return null;
		}
		else {
			if (item.compareTo(subtree.getData()) < 0){
				BinaryTreeNode left = remove(item, subtree.getLeftChild());
				subtree.setLeftChild(left);	
			}
			else if (item.compareTo(subtree.getData()) > 0){
				BinaryTreeNode right = remove(item, subtree.getRightChild());
				subtree.setRightChild(right);
			}
			else if (subtree.getLeftChild() != null && subtree.getRightChild() != null){
				BinaryTreeNode successor = LeftMost(subtree.getRightChild());
				subtree.setData(successor.getData());
				BinaryTreeNode right=remove(successor.getData(), subtree.getRightChild());
				subtree.setRightChild(right);
			}
			else {
				if (subtree.getLeftChild() != null){
					subtree = subtree.getLeftChild();
				}
				else {
					subtree = subtree.getRightChild();
				}

			}
		}
		return subtree;
	}

	public BinaryTreeNode LeftMost() {
		if (!isEmpty())
			return LeftMost(root);
		else 
			return null;
	}

	/**
	 * Private helper method to get the left most data in the tree.
	 * @param left
	 * @return T
	 */
	private BinaryTreeNode LeftMost(BinaryTreeNode left) {
		if (left.getLeftChild() == null)
			// left is the left-most child in the tree
			return left;
		else
			// continue going left
			return LeftMost(left.getLeftChild());
	}
	public Iterator<T> iterator() {
		return new InOrderIterator();

	}

	private class InOrderIterator implements Iterator<T> {
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private InOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Comparable[size()];
			next = 0;

			// now perform an inorder traversal
			inOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}
		private void inOrder(BinaryTreeNode node) {
			if (node != null) {
				inOrder(node.getLeftChild());
				elements[next++] = node.getData();
				inOrder(node.getRightChild());
			}
		}
		public boolean hasNext() {
			return (next < size());
		}

        public T next() {
			return elements[next++];
		}
        public void remove(){
        	//stub
        }
	}




	public int size() {
		return(size(root));
	}
	private int size(BinaryTreeNode node){
		if(node==null){
			return 0;
		}else{
			return size(node.leftChild) + size(node.rightChild) + 1;
		}
	}
}

