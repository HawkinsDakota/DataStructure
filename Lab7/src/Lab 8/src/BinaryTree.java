import java.util.Iterator;

/**
 * Binary tree implementation.
 * 
 * @author Greg Gagne
 *
 * @param <T>
 */

// This suppresses warnings we may get
@SuppressWarnings("unchecked")

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryTreeNode root;    // the root of the binary tree

	/**
	 * Inner class for binary tree node.
     * 
     * Each node of the binary tree is an instance of this class.
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
	 * Constructors
	 */
	public BinaryTree() {
		root = null;
	}

    /**
     * Create a binary tree with no left or right children.
     */
	public BinaryTree(T data) {
		root = new BinaryTreeNode(data, null, null);
	}

    /**
     * Create a binary tree with left and right children.
     */
	public BinaryTree(T data, BinaryTreeInterface<T> left, BinaryTreeInterface<T> right) {
		root = new BinaryTreeNode(data, null, null);


        /**
         * If left child is non-null, typecast it to a BinaryTree instance
         * and set the left child to the root of the left binary tree.
         */
		if (left != null) {
			BinaryTree<T> leftNode = (BinaryTree<T>)left;
			root.setLeftChild(leftNode.root);
		}

        /**
         * If right child is non-null, typecast it to a BinaryTree instance
         * and set the right child to the root of the right binary tree.
         */
		if (right != null) {
			BinaryTree<T> rightNode = (BinaryTree<T>)right;
			root.setRightChild(rightNode.root);
		}
	}

	/**
	 * Methods implemented from BinaryTreeInterface specification
	 */

	public boolean isEmpty() {
		return (root == null);
	}

	public T getRootData() {
		if (!isEmpty())
			return root.getData();
		else
			return null;
	}

	public int getHeight() {
        return getHeight(root);
	}
	
	private int getHeight(BinaryTreeNode node){
		if (node==null)
			return 0;
		else{
			return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()))+1;
		}
		
	}

	public int getSize() {
		return getSize(root);
	}
	
	private int getSize(BinaryTreeNode node){
		if (node==null)
			return 0;
		else
			return 1+getSize(node.getLeftChild())+getSize(node.getRightChild());
	}

	public T getLeftMostData() {
        if (!isEmpty())
            return getLeftMostData(root);
        else 
            return null;
	}

	/**
	 * Private helper method to get the left most data in the tree.
	 * @param left
	 * @return T
	 */
	private T getLeftMostData(BinaryTreeNode left) {
		if (left.getLeftChild() == null)
            // left is the left-most child in the tree
			return left.getData();
		else
            // continue going left
			return getLeftMostData(left.getLeftChild());
	}


	public T getRightMostData() {
	        if (!isEmpty())
	            return getRightMostData(root);
	        else 
	            return null;
		}

/**
 * Private helper method to get the left most data in the tree.
 * @param right
 * @return T
 */
private T getRightMostData(BinaryTreeNode right) {
	if (right.getRightChild() == null)
        // right is the right-most child in the tree
		return right.getData();
	else
        // continue going right
		return getRightMostData(right.getRightChild());
}


	public void printTree() {
		/**
		 * We start at the root and do an inorder traversal
		 */
		printTree(root);
	}

	/**
	 * Private helper method to print out the tree.
     * This prints out the tree as an inorder traversal.
	 * @param node 
	 */
	private void printTree(BinaryTreeNode node) {
		if (node != null) {
			printTree(node.getLeftChild());
			System.out.println(node.getData()); // i.e. "visit"
			printTree(node.getRightChild());
		}
	}

	public T removeLeftMostData() {
		if (isEmpty())
			return null;
		else if (root.getLeftChild() == null) {
            /**
             * Special case - the root node has no left child
             * so the root is the left-most data.
             */
			T data = root.getData();

            /**
             * set the root to the root's right child
             */
            root = root.getRightChild();

			return data;
		}
		else
            // call recursive helper method
			return removeLeftMostData(root);
	}

	/**
	 * Private helper method to remove the left most data.
	 * @param node
	 * @return
	 */
	private T removeLeftMostData(BinaryTreeNode node) {
		if ((node.getLeftChild()).getLeftChild() == null) {
            /**
             * node is the parent whose reference must be adjusted.
             *
             * node.getLeftChild() is a reference 
             * to the left-most child.
             */

            // retrieve the left most data
			T data = (node.getLeftChild()).getData();

            /**
             * We must adjust the left child of node so that
             * it now refers to the right child of the node
             * being deleted.
             */
            node.setLeftChild( (node.getLeftChild()).getRightChild() );
			

			return data;		
        }
		else
			return removeLeftMostData(node.getLeftChild());
	}

	
    public T removeRightMostData() {
    	if (isEmpty())
			return null;
		else if (root.getRightChild() == null) {
            /**
             * Special case - the root node has no left child
             * so the root is the left-most data.
             */
			T data = root.getData();

            /**
             * set the root to the root's right child
             */
            root = root.getLeftChild();

			return data;
		}
		else
            // call recursive helper method
			return removeRightMostData(root);
    }
    
    private T removeRightMostData(BinaryTreeNode node){
    	if ((node.getRightChild()).getRightChild() == null) {
            /**
             * node is the parent whose reference must be adjusted.
             *
             * node.getRightChild() is a reference 
             * to the right-most child.
             */

            // retrieve the left most data
			T data = (node.getRightChild()).getData();

            /**
             * We must adjust the right child of node so that
             * it now refers to the left child of the node
             * being deleted.
             */
            node.setRightChild( (node.getRightChild()).getLeftChild() );
			

			return data;		
        }
		else
			return removeRightMostData(node.getRightChild());
	}


	public Iterator<T> getPreOrderIterator() {
		return new PreOrderIterator();
	}

	public Iterator<T> getInOrderIterator() {
		return new InOrderIterator();
	}

	public Iterator<T> getPostOrderIterator() {
		return new PostOrderIterator();
	}

	/**
	 * The easiest way of handling this is to perform an inorder 
	 * traversal of the tree and deposit each element into an array.
	 * Use the array when performing the iteration.
	 */
	private class InOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		private InOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
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
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
	
	
	
	/**
	 * The easiest way of handling this is to perform an inorder 
	 * traversal of the tree and deposit each element into an array.
	 * Use the array when performing the iteration.
	 */
	private class PostOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		private PostOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an postorder traversal
			postOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void postOrder(BinaryTreeNode node) {
			if (node != null) {
				postOrder(node.getLeftChild());
				postOrder(node.getRightChild());
				elements[next++] = node.getData();
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
	
	
	
	/**
	 * The easiest way of handling this is to perform an inorder 
	 * traversal of the tree and deposit each element into an array.
	 * Use the array when performing the iteration.
	 */
	private class PreOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		private PreOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an preorder traversal
			preOrder(root);

            // reset next back to the beginning of the array
			next = 0;
		}

		private void preOrder(BinaryTreeNode node) {
			if (node != null) {
				elements[next++] = node.getData();
				preOrder(node.getLeftChild());
				preOrder(node.getRightChild());
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

        public T next() {
			return elements[next++];
		}
	}
}
