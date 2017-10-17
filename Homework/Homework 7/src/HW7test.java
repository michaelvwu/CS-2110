import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/* Michael Wu
 * mvw5mf
 */

public class HW7test<T>
{
	@Test
	public void testNodeEquals()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "y");
		test2.setLeft(test3);
		assertTrue(test.equals(test2));
		
	}
	
	@Test
	public void testNodeEquals2()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "z");
		test2.setLeft(test3);
		
		assertFalse(test.equals(test2));
	}
	
	@Test
	public void testNodeHeight()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "z");
		test2.setLeft(test3);
		
		
		assertEquals(test.height(),2);
	}
	
	@Test
	public void testNodeHeight2()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "y");
		BinaryTreeNode<T> test4 = new BinaryTreeNode<T>((T) "z");
		test2.setLeft(test3);
		test3.setRight(test4);
		
		
		assertEquals(test2.height(),3);
	}
	
	@Test
	public void testNodeFull()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "y");
		BinaryTreeNode<T> test4 = new BinaryTreeNode<T>((T) "z");
		test2.setLeft(test3);
		test3.setRight(test4);
		
		assertEquals(test.full(), false);
	}
	
	@Test
	public void testNodeFull2()
	{
		BinaryTreeNode<T> test = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test1 = new BinaryTreeNode<T>((T) "y");
		test.setLeft(test1);
		BinaryTreeNode<T> test2 = new BinaryTreeNode<T>((T) "x");
		BinaryTreeNode<T> test3 = new BinaryTreeNode<T>((T) "y");
		BinaryTreeNode<T> test4 = new BinaryTreeNode<T>((T) "z");
		test2.setLeft(test3);
		test3.setRight(test4);
		
		assertEquals(test2.full(), false);
	}
	
	@Test
	public void testNodeMirror()
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Same");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		
		root1.mirror();
		assertEquals(root1.getLeft(), new BinaryTreeNode<String>("Right"));
		
	}
	
	@Test
	public void testNodeMirror2()
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Same");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		root1.getLeft().setRight(new BinaryTreeNode<String>("Bottom"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		
		root1.mirror();
		assertEquals(root1.getRight().getLeft(), new BinaryTreeNode<String>("Bottom"));
	}
	
	@Test
	public void nodeInOrderTest() 
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Root");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		assertEquals(root1.inOrder(), "(Left)(Root)(Right)");
	}
	
	@Test
	public void nodeInOrderTest2() 
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Root");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.getLeft().setRight(new BinaryTreeNode<String>("Bottom"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		assertEquals(root1.inOrder(), "(Left)(Bottom)(Root)(Right)");
	}
	
	
	
	@Test
	public void testTreeEquals()
	{
		BinaryTreeNode left = new BinaryTreeNode(50);
		BinaryTreeNode right = new BinaryTreeNode(10);
		BinaryTreeNode root1 = new BinaryTreeNode(25,left, right);
		BinaryTree tree1 = new BinaryTree(root1);
		
		BinaryTreeNode left3 = new BinaryTreeNode(100);
		BinaryTreeNode right3 = new BinaryTreeNode(45);
		BinaryTreeNode left2 = new BinaryTreeNode(50, left3, right3);
		BinaryTreeNode right2 = new BinaryTreeNode(10);
		BinaryTreeNode root2 = new BinaryTreeNode(25,left2, right2);
		
		BinaryTree tree2 = new BinaryTree(root2);
		
		assertFalse(tree1.equals(tree2));
	}
	
	@Test
	public void testTreeEquals2()
	{
		BinaryTreeNode left = new BinaryTreeNode(50);
		BinaryTreeNode right = new BinaryTreeNode(10);
		BinaryTreeNode root1 = new BinaryTreeNode(25,left, right);
		BinaryTree tree1 = new BinaryTree(root1);
		
		BinaryTreeNode left2 = new BinaryTreeNode(50);
		BinaryTreeNode right2 = new BinaryTreeNode(10);
		BinaryTreeNode root2 = new BinaryTreeNode(25,left2, right2);
		BinaryTree tree2 = new BinaryTree(root2);
		
		assertTrue(tree1.equals(tree2));
	}
	
	@Test
	public void treeDeepCopyTest1() 
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Same");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		
		BinaryTree<String> tree2 = tree1.deepCopy();
		
		//assertEquals(tree1, tree2);
	}
	
	@Test
	public void treeDeepCopyTest2() 
	{
		BinaryTreeNode<String> root1 = new BinaryTreeNode<String>("Same");
		root1.setLeft(new BinaryTreeNode<String>("Left"));
		root1.getLeft().setRight(new BinaryTreeNode<String>("Bottom"));
		root1.setRight(new BinaryTreeNode<String>("Right"));
		BinaryTree<String> tree1 = new BinaryTree<String>(root1);
		
		BinaryTree<String> tree2 = tree1.deepCopy();
		
		//assertEquals(tree1, tree1);
	}
	
	@Test
	public void testTreeCombine()
	{
		BinaryTreeNode left = new BinaryTreeNode(50);
		BinaryTreeNode right = new BinaryTreeNode(10);
		BinaryTreeNode root1 = new BinaryTreeNode(25,left, right);
		BinaryTree tree1 = new BinaryTree(root1);
		
		BinaryTreeNode left3 = new BinaryTreeNode(100);
		BinaryTreeNode right3 = new BinaryTreeNode(45);
		BinaryTreeNode left2 = new BinaryTreeNode(50, left3, right3);
		BinaryTreeNode right2 = new BinaryTreeNode(10);
		BinaryTreeNode root2 = new BinaryTreeNode(25,left2, right2);
		
		BinaryTree tree2 = new BinaryTree(root2);
		
		//assertEquals();
	}
	
	@Test
	public void testTreeCombine2()
	{
		BinaryTreeNode left1 = new BinaryTreeNode(50);
		BinaryTreeNode right = new BinaryTreeNode(10);
		BinaryTreeNode root1 = new BinaryTreeNode(25,left1, right);
		BinaryTree tree1 = new BinaryTree(root1);
		
		BinaryTreeNode left3 = new BinaryTreeNode(100);
		BinaryTreeNode right3 = new BinaryTreeNode(45);
		BinaryTreeNode left2 = new BinaryTreeNode(50, left3, right3);
		BinaryTreeNode right2 = new BinaryTreeNode(10);
		BinaryTreeNode root2 = new BinaryTreeNode(25,left2, right2);
		
		BinaryTree tree2 = new BinaryTree(root2);
		boolean left = false; 
		
		BinaryTree newCopy = tree1.combine(root2, tree2, left);
		
		//assertEquals();
	}
	

}
