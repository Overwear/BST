package bst;

public class Node
{
	private int value;
	Node right;
	Node left;
	
	
	Node(int val)
	{
		value = val;
	}
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int val)
	{
		value = val;
	}
	
	public Node getRightNode()
	{
		return right;
	}
	
	public Node getLeftNode()
	{
		return left;
	}
	
	public void setRightNode(Node node)
	{
		right = node;
	}
	
	public void setLeftNode(Node node)
	{
		left = node;
	}

}


