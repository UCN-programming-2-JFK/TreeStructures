package compositepattern.gui;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import compositepattern.*;

public class OrganizationalUnitPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTree organizationalTree = null;

	public void addRoot(OrganizationalUnit organization) {
		DefaultMutableTreeNode rootNode = organizationToGuiNodeTree(organization);
		this.setLayout(new BorderLayout());
		organizationalTree = new JTree(rootNode);
		this.add(organizationalTree);
	}

	public DefaultMutableTreeNode organizationToGuiNodeTree(OrganizationalUnit unit) {
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(unit);
		if (unit instanceof Organization) {
			for (OrganizationalUnit subUnit : ((Organization) unit).getSubUnits()) {
				DefaultMutableTreeNode subNode = organizationToGuiNodeTree(subUnit);
				newNode.add(subNode);
			}
		}
		return newNode;
	}
}