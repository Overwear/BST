package bst;

public class Test 
{
	public static void main(String[] args)
	{
		Tree BST = new Tree();
		
		BST.Insert(10);
		BST.Insert(15);
		BST.Insert(6);
		BST.Insert(7);
		BST.Insert(22);
		BST.Insert(13);
		BST.Insert(1);

//		System.out.println(BST.getPredecessor(1));
		BST.print_Postorder();
		System.out.println("---------------------");
		BST.delete(22);
		BST.print_Postorder();

	}
}
