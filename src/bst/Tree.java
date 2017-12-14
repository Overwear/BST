package bst;

public class Tree 
{
	Node current;
	Node root;
	Node parent;
	
	public void Insert(int value)
	{
		if(root == null)
		{
			root = new Node(value);
			current = root;
		}
		else
		{
			current = root;
			while(current != null)
			{
				if(value > current.getValue())
				{
					parent = current;
					current = current.right;
				}
				else if (value < current.getValue())
				{
					parent = current;
					current = current.left;
				}
			}
			Node new_node = new Node(value);
			if(value > parent.getValue())
			{
				parent.right = new_node;
			}
			else if (value < parent.getValue())
			{
				parent.left = new_node;
			}
		}
	}
	
	public boolean Search(int val)
	{
		if(root == null)
		{
			return false;
		}
		current = root;
		parent = null;
		boolean isfound = false;
		while(current != null)
		{
			if(val < current.getValue())
			{
				parent = current;
				current = current.left;
			}
			else if (val > current.getValue())
			{
				parent = current;
				current = current.right;
			}
			if(val == current.getValue())
			{
				current = null;
				isfound = true;
			}
		}
		return isfound;
	}
	
	public void print_Inorder()
	{
		inorder(root);
	}
	
	public void inorder(Node node)
	{
		if(node == null)
		{
			return;
		}
		inorder(node.left);
		System.out.println(node.getValue());
		inorder(node.right);
		
	}
	
	public void print_Preorder()
	{
		preorder(root);
	}
	
	public void preorder(Node node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.getValue());
		preorder(node.left);
		preorder(node.right);
	}
	
	public void print_Postorder()
	{
		postorder(root);
	}
	
	public void postorder(Node node)
	{
		if(node == null)
		{
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.getValue());
	}
	
	public Node getPredecessor(int val)
	{
		parent = null;
		current = root;
		while(current.getValue() != val)
		{
			if(current.getValue() > val)
			{
				current = current.left;
			}
			else if(current.getValue() < val)
			{
				current = current.right;
			}
		}
		current = current.left;
		while(current != null)
		{
			parent = current;
			current = current.right;
		}
		current = parent;
		return current;
	}
	
	public Node getSuccessor(int val)
	{
		parent = null;
		current = root;
		while(current.getValue() != val)
		{
			if(current.getValue() > val)
			{
				current = current.left;
			}
			else if(current.getValue() < val)
			{
				current = current.right;
			}
		}
		current = current.right;
		while(current != null)
		{
			parent = current;
			current = current.left;
		}
		current = parent;
		return current;
	}
	
	public Node getParentOf(int val)
	{
		current = root;
		parent = null;
		
		while(current.getValue() != val)
		{
			if(current.getValue() > val)
			{
				parent = current;
				current = current.left;
			}
			else
			{
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}
	public void delete(int value)
	{
		Node d_current = root;
		Node d_parent = null;
		Node replacement = null;
		Node temp_parent;
		while(d_current.getValue() != value)
		{
			if(d_current.getValue() > value)
			{
				d_parent = d_current;
				d_current = d_current.left;
			}
			else
			{
				d_parent = d_current;
				d_current = d_current.right;
			}
		}
		if(d_parent == null)
		{
			replacement = getPredecessor(d_current.getValue());
			temp_parent = getParentOf(replacement.getValue());
			if (replacement.getValue() > temp_parent.getValue())
			{
				parent.right = null;
			}
			else
			{
				parent.left = null;
			}
			replacement.left = d_current.left;
			replacement.right = d_current.right;
			d_current.left = null;
			d_current.right = null;
			d_current = replacement;
			root = d_current;
		}
		else if(d_current.left == null && d_current.right == null)
		{
			if(d_parent.getValue() > d_current.getValue())
			{
				d_parent.left = null;
			}
			else
			{
				d_parent.right = null;
			}
		}
		else
		{
			replacement = getPredecessor(d_current.getValue());
			temp_parent = getParentOf(replacement.getValue());
			if (replacement.getValue() > parent.getValue())
			{
				parent.right = null;
			}
			else
			{
				parent.left = null;
			}
			if(d_parent.getValue() > d_current.getValue())
			{
				replacement.left = d_current.left;
				replacement.right = d_current.right;
				d_current.left = null;
				d_current.right = null;
				d_parent.left = replacement;
			}
			else if(d_parent.getValue() < d_current.getValue())
			{
				replacement.left = d_current.left;
				replacement.right = d_current.right;
				d_current.left = null;
				d_current.right = null;
				d_parent.right = replacement;
			}
		}
	}
}
