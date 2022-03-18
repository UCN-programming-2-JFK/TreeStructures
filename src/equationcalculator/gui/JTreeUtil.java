package equationcalculator.gui;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Collections;

//code from: https://www.logicbig.com/tutorials/java-swing/jtree-expand-collapse-all-nodes.html

public class JTreeUtil {
  public static void setTreeExpandedState(JTree tree, boolean expanded) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
      setNodeExpandedState(tree, node, expanded);
  }

  public static void setNodeExpandedState(JTree tree, DefaultMutableTreeNode node, boolean expanded) {
      
      for (TreeNode treeNode : Collections.list(node.children())) {
          setNodeExpandedState(tree, (DefaultMutableTreeNode)treeNode, expanded);
      }
      if (!expanded && node.isRoot()) {
          return;
      }
      TreePath path = new TreePath(node.getPath());
      if (expanded) {
          tree.expandPath(path);
      } else {
          tree.collapsePath(path);
      }
  }
}