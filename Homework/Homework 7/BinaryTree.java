/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 7
 */

public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) 
	{
		if (o instanceof BinaryTree) 
		{
			BinaryTree bst = (BinaryTree) o;
			return bst.getRoot()== this.root;		
		}
		else 
		{
			return false;
		}
	}

	public BinaryTree<T> deepCopy() 
	{
		BinaryTree<T> copy = new BinaryTree<T>(this.root);
		BinaryTreeNode<T> newRoot = null;
		if (this.root != null) 
		{
			newRoot = this.root.deepCopy();
			copy.setRoot(newRoot);
		}
		return copy;	
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) 
	{
		//To do
	}
	
	public int size()
	{
		return BinaryTreeNode.size(root);
	}
	
	public int height()
	{
		return BinaryTreeNode.height(root);
	}
	
	public boolean full()
	{
		//To do
	}
	
	public void mirror()
	{
		//To do
	}
	
	public String inOrder()
	{
		
	}
}
