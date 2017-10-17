/*
 * Michael Wu
 * mvw5mf
 * 
 * Homework 7
 */


public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left; //left leaf
	private BinaryTreeNode<T> right; //right leaf
	private T data; // information stored on a leaf
	
	/**
	 * constructor
	 */
	public BinaryTreeNode(){
		this(null,null,null);
	}
	/**
	 * constructor
	 */
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	/**
	 * constructor
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	/**
	 * determines the size of the tree
	 * @return, the size of the tree
	 */
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

	// getters and setters
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
	
	/**
	 * Deep copy is creating a new object and then copying the nonstatic fields of the current object to the new object. 
	 * @return, a new copy of the binary tree
	 */
	public BinaryTreeNode<T> deepCopy()
	{
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
	
	
	/**
	 * comparison method for binary tree node, comparing the right and left nodes/leaves to see if two trees are equal
	 */
	@Override
	public boolean equals(Object o)
	{
		boolean retval = false; 
		if (o instanceof BinaryTreeNode) 
		{
			BinaryTreeNode<T> btn = (BinaryTreeNode<T>) o;
			if ((left == null && btn.getLeft() == null ) && (right == null && btn.getRight() == null ))
			{
				retval = this.data.equals(btn.getData()); 
			}
			
			else if ((left == null && btn.getLeft() != null ) || (left != null && btn.getLeft() == null ))
			{
				retval = false; 
			}
			else if ((right == null && btn.getRight() != null ) || (right != null && btn.getRight() == null ))
			{
				retval = false; 
			}
			else if((left != null && btn.getLeft() != null ) && (right == null && btn.getRight() == null ))
			{
				retval = this.data.equals(btn.getData()) && this.left.equals(btn.getLeft());
			}
			else if((left == null && btn.getLeft() == null ) && (right != null && btn.getRight() != null ))
			{
				retval = this.data.equals(btn.getData()) && this.right.equals(btn.getRight());
			}
			else 
			{
				retval = this.data.equals(btn.getData()) && this.left.equals(btn.getLeft()) && this.right.equals(btn.getRight());
			}
		}
		return retval;
		
//		if (o instanceof BinaryTreeNode)
//		{
//			BinaryTreeNode<T> t = (BinaryTreeNode<T>) o; 
//			if (t.getData() == this.data)
//			{
//				if(t.getLeft() == null && this.left== null)
//				{
//					if (t.getRight() == null && this.right == null)
//					{
//						return true;
//					}
//				}
//			}
//			else
//			{
//				return false; 
//			}
//			return this.left.equals(t.getLeft()) && this.right.equals(t.getRight());
//		}
//		else 
//		{
//			return false; 
//		}
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
		int LHeight = 0;
		int RHeight = 0;
		int height = 0;
		
		if (left != null)
		{
			LHeight = left.height();
		}
		if (right != null)
		{
			RHeight = right.height();
		}
		if (LHeight > RHeight)
		{
			height = 1 + LHeight; 
		}
		else
		{
			height = 1 + RHeight; 
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
		if (this == null || (this.left == null && this.right == null))
		{
			 
		}
		else if (this.left != null && this.right == null)
		{
			this.right = this.left;
			this.left = null;
			this.right.mirror();
		}
		else if (this.left == null && this.right != null)
		{
			this.left = this.right;
			this.right = null;
			this.left.mirror();
		}
		else 
		{
			BinaryTreeNode<T> b = this.left;
			this.left = this.right;
			this.right = b;
			this.left.mirror();
			this.right.mirror();
		}
	}
	
	/**
	 * method to print all the nodes in the tree with an inorder traversal
	 * @return, the result of an inorder traversal
	 */
	public String inOrder()
	{		
		String all = "";
	    
	    if (left != null)
	    {
	       all = left.inOrder();
	    }
	    all = all + "(" + data + ")";
	    
	    if (right != null)
	    {
	       all = all + right.inOrder();
	    }
	    
	    return all;
	
	}
}
