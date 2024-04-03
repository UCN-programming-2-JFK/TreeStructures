package equationcalculator.gui;


import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import equationcalculator.EquationNode;

public class EquationTreeVisualizer extends JFrame implements DocumentListener {

	private static final long serialVersionUID = 1L;
	private static JTree tree;
	private JTextField equationField;
	private JScrollPane scrollPane;
	final Font bigFont;
	GridBagConstraints c;
	private JPanel pane;

	public static void main(String[] argStrings) {

		EquationTreeVisualizer window = new EquationTreeVisualizer();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setSize(800, 600);
		window.setVisible(true);
	}

	public EquationTreeVisualizer() {

		// create back JPanel "pane"
		this.getRootPane().setLayout(new BorderLayout());
		c = new GridBagConstraints();
		pane = new JPanel(new GridBagLayout());
		pane.setBackground(Color.blue);
		getRootPane().add(pane);

		// create label
		c.weightx = c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		JLabel equationLabel = new JLabel();
		equationLabel.setText("Equation:");
		equationLabel.setOpaque(true);
		final Font currentFont = equationLabel.getFont();
		bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 20);
		equationLabel.setFont(bigFont);
		pane.add(equationLabel, c);

		// create textfield
		equationField = new JTextField();
		c.gridx = 1;
		c.gridwidth = 2;
		c.weightx = 4;
		equationField.setFont(bigFont);
		pane.add(equationField, c);
		equationField.getDocument().addDocumentListener(this);

		// create tree
		tree = new JTree(new DefaultMutableTreeNode("No equation loaded yet..."));
		tree.setFont(bigFont);
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 3;
		c.weighty = 20;
		c.fill = GridBagConstraints.BOTH;
		scrollPane = new JScrollPane(tree);
		pane.add(scrollPane, c);
		//tree.setBackground(Color.green);
	}

	private DefaultMutableTreeNode equationTreeToGuiTree(EquationNode equationNode) {
		DefaultMutableTreeNode guiNode = new DefaultMutableTreeNode(equationNode);
		if (equationNode.getLeft() != null) {
			guiNode.add(equationTreeToGuiTree(equationNode.getLeft()));
		}
		if (equationNode.getRight() != null) {
			guiNode.add(equationTreeToGuiTree(equationNode.getRight()));
		}
		return guiNode;
	}


	private void loadEquationAsNodeTree() {
		
		try {
			EquationNode node = new EquationNode(equationField.getText());
			DefaultMutableTreeNode rootTreeNode = equationTreeToGuiTree(node);
		
		// remove existing nodetree
		// from: https://softwaretestingboard.com/q2a/515/how-do-i-remove-root-node-from-jtree
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
		model.reload();
		model.setRoot(null);

		model = (DefaultTreeModel) tree.getModel();
		model.setRoot(rootTreeNode);
		JTreeUtil.setTreeExpandedState(tree, true);
		setTitle("Result: " + node.getValue());
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {loadEquationAsNodeTree();}
	@Override
	public void removeUpdate(DocumentEvent e) {loadEquationAsNodeTree();}
	@Override
	public void changedUpdate(DocumentEvent e) {loadEquationAsNodeTree();
	}
}