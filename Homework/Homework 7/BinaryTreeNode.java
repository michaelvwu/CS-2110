/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 7
 */


public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public int size(){
		int size = 0; //the size of the tree
		
		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
		BinaryTreeNode<T> newLeft = null;
		BinaryTreeNode<T> newRight = null;
		if (this.left != null) 
		{
			newLeft = this.left.deepCopy();
			copy.setLeft(newLeft);
		}
		if (this.right != null) 
		{
			newRight = this.right.deepCopy();
			copy.setRight(newRight);
		}
		return copy;		
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof BinaryTreeNode) 
		{
			BinaryTreeNode btn = (BinaryTreeNode) o;
			return (this.getLeft().equals(btn.getLeft()) && this.getRight().equals(btn.getRight())));  	
		}
		else 
		{
			return false;
		}
	}
	
	public int height()
	{
		//To do
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
		//To do
		
		if (this.root() != null)
        {
            inorder(this.getLeft());
            System.out.print(this.getRoot().getData() +" ");
            inorder(this.getRight());
        }
	}

}
