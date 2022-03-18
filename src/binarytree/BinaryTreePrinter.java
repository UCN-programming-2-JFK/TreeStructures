package binarytree;

public class BinaryTreePrinter {
	
	private BinaryTreePrinter() {}
	
	public static void printTreeInOrder(BinaryStringTree tree) {
		if(tree.getRoot() == null) {System.out.println("Tree is empty");return;}
		printTreeNodeInOrder(tree.getRoot());
	}
	
	private static void printTreeNodeInOrder(BinaryStringNode node) {
		if(node.getLeft()!=null) {printTreeNodeInOrder(node.getLeft());}
		System.out.println(node);
		if(node.getRight()!=null) {printTreeNodeInOrder(node.getRight());}
	}

	public static void printTreePreOrder(BinaryStringTree tree) {
		if(tree.getRoot() == null) {System.out.println("Tree is empty");return;}
		printTreeNodePreOrder(tree.getRoot());
	}

	private static void printTreeNodePreOrder(BinaryStringNode node) {
		System.out.println(node);
		if(node.getLeft()!=null) {printTreeNodeInOrder(node.getLeft());}
		if(node.getRight()!=null) {printTreeNodeInOrder(node.getRight());}
	}
	
	public static void printTreePostOrder(BinaryStringTree tree) {
		if(tree.getRoot() == null) {System.out.println("Tree is empty");return;}
		printTreeNodePostOrder(tree.getRoot());
	}
	
	private static void printTreeNodePostOrder(BinaryStringNode node) {
		if(node.getLeft()!=null) {printTreeNodeInOrder(node.getLeft());}
		if(node.getRight()!=null) {printTreeNodeInOrder(node.getRight());}
		System.out.println(node);
	}
}