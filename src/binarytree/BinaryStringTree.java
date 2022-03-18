package binarytree;

public class BinaryStringTree {

		private BinaryStringNode root = null;
		
		public boolean isEmpty(){ return root == null;}
		public BinaryStringNode getRoot() {return root;}
		public void setRoot(BinaryStringNode root) {this.root = root;}
		
		public int size() {
			if(getRoot() == null) {return 0;}
			else {
				return getRoot().getNumberOfDescendants() +1;
			}
		}

		@Override public String toString() {
			if(getRoot() == null) {return "Tree is empty";}
			return "Tree has " + size() + " elements.";
		}
}