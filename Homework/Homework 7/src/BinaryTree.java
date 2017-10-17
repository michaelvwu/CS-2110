import static org.junit.Assert.assertTrue;

/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 7
 */

public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	/**
	 * constructor
	 */
	public BinaryTree() {
		this(null);
	}

	/**
	 * constructor
	 */
	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	//getter
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	//setter
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * comparison method for binary tree node, comparing the right and left nodes/leaves to see if two trees are equal
	 */
	@Override
	public boolean equals(Object o) 
	{

		if (o instanceof BinaryTree)
		{
			BinaryTree<T> t = (BinaryTree<T>) o; 
			if (t.getRoot().getData() == this.root.getData())
			{
				if(t.getRoot().getLeft() == null && this.root.getLeft()== null)
				{
					if (t.getRoot().getRight() == null && this.root.getRight() == null)
					{
						return true;
					}
				}
				if (this.root.getRight() == null && (t.getRoot().getRight() == null))
				{
					return true; 
				}
				if((this.root.getLeft() == null) && (t.getRoot().getLeft() == null))
				{
					return true; 
				}

			}
			else
			{
				return false; 
			}
			return this.root.equals(t.getRoot()) && this.root.getRight().equals(t.getRoot().getRight()) && this.root.getLeft().equals(t.getRoot().getLeft());
		}
		else 
		{
			return false; 
		}
	}

	/**
	 * Deep copy is creating a new object and then copying the nonstatic fields of the current object to the new object. 
	 * @return, a new copy of the binary tree
	 */
	public BinaryTree<T> deepCopy() 
	{
		BinaryTree<T> copy = new BinaryTree<T>(this.root);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		if (this.root.getLeft() != null) 
		{
			newLeft = this.root.getLeft().deepCopy();
			copy.getRoot().setLeft(newLeft);
		}
		if (this.root.getRight() != null) 
		{
			newRight = this.root.getRight().deepCopy();
			copy.getRoot().setRight(newRight);
		}
		return copy;	
	}

	/**
	 * takes two trees and puts them together
	 * @param newRoot, root of a tree
	 * @param t, a binary tree
	 * @param left, boolean determines if the calling tree is the left child (true) or the right child (false)
	 * @return, a new tree that is combined from another
	 */
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) 
	{
		BinaryTree<T> ogTree = this.deepCopy();
		BinaryTree<T> treeCopy = t.deepCopy();
		BinaryTreeNode<T> combinationTreeRoot = newRoot.deepCopy();
		BinaryTree<T> combinationTree = new BinaryTree<T>();
		
		combinationTree.setRoot(combinationTreeRoot);
		if(left)
		{
			combinationTree.getRoot().setLeft(ogTree.getRoot());
			combinationTree.getRoot().setRight(treeCopy.getRoot());			
		}
		else
		{
			combinationTree.getRoot().setLeft(treeCopy.getRoot());
			combinationTree.getRoot().setRight(ogTree.getRoot());	
		}
		return combinationTree;
	}
	
	/**
	 * finds the total number of nodes in the tree
	 * @return, number of nodes in the tree to show size
	 */
	public int size()
	{
		if (root == null)
		{
			return 0;
		}
		return root.size();
	}
	
	/**
	 * Method to find the height of the tree
	 * The root of the tree is at height 1, the children of the root are at height 2, ect. 
	 * The total height of the tree is the maximum height of all nodes in the tree. 
	 * 
	 * @return, the height of the tree
	 */
	public int height()
	{
		int height = 0;
		if (root != null)
		{
			height= root.height(); 
		}
		return height;
	}
	
	/**
	 * method to check if the tree is full or empty
	 * @return, true if it is full, and false if it is empty
	 */
	public boolean full()
	{
		 return this.size() == (int) (Math.pow(2, this.height()) -1);
	}
	
	/**
	 * method to flip the tree
	 */
	public void mirror()
	{
		if (root == null || (root.getLeft() == null && root.getRight() == null))
		{
			
		}
		else
		{
			BinaryTreeNode<T> btn = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(btn);
			root.getLeft().mirror();
			root.getRight().mirror();
		}
	}
	
	/**
	 * method to print all the nodes in the tree with an inorder traversal
	 * @return, the result of an inorder traversal
	 */
	public String inOrder()
	{
		String order = "";
		if (root != null)
		{
			order = root.inOrder();
		}
		
		return order; 
	}

	
}
