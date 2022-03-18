import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeRootChangerTest extends JFrame {

	private static final long serialVersionUID = 1L;
private JTree tree;
	public static void main(String[] argStrings) {
		TreeRootChangerTest window = new TreeRootChangerTest();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.changeRootNode();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.createTreeAgain();
	}
	
	
	public TreeRootChangerTest() {		
		createTree();
	}


	private void createTree() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Test");
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode("Child 1");
		DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode("Child 2");
		rootNode.add(childNode);
		rootNode.add(childNode2);
		tree = new JTree (rootNode);
		getRootPane().setLayout(new BorderLayout());
		getRootPane().add(tree);
	}
	
	
	public  void changeRootNode() {
		
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        model.reload();
        model.setRoot(null); // This will remove your root.
		
	}
	
	private void createTreeAgain() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Second Test");
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode("Second Child 1");
		DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode("Second Child 2");
		rootNode.add(childNode);
		rootNode.add(childNode2);
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		model.setRoot(rootNode);
	}
}