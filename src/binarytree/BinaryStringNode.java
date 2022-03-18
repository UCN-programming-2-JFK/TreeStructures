package binarytree;

public class BinaryStringNode {

		private BinaryStringNode right = null;
		private BinaryStringNode left = null;
		private String data = null;
		
		public BinaryStringNode(String data) {this.data = data;}
		
		public String getData() { return data;}
		public BinaryStringNode getRight() {return right;}
		public BinaryStringNode getLeft() {return left;}
		public void setLeft(BinaryStringNode newLeftChild) {left = newLeftChild;}
		public void setRight(BinaryStringNode newRightChild) {right = newRightChild;}
		public boolean isLeaf() {return getLeft() == null && getRight()== null;}
		
		public int getNumberOfDescendants() {
			int sum = 0;
			if(getLeft() != null) {
				sum += 1;	//add 1 for the left node itself
				//add the number of descendants
				sum += getLeft().getNumberOfDescendants() ;
			}
			if(getRight() != null) {
				sum += 1;	//add 1 for the right node itself
				//add the number of descendants
				sum += getRight().getNumberOfDescendants();
			}
			return sum;
		}
		
		@Override public String toString() {
			return getData();
		}
}