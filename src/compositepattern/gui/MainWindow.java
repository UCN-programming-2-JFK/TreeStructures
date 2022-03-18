package compositepattern.gui;


import javax.swing.JFrame;
import compositepattern.Department;
import compositepattern.Organization;
import compositepattern.OrganizationalUnit;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("Treeview of organization");
	}

	public static void main(String[] args) {
		OrganizationalUnitPanel treePanel = new OrganizationalUnitPanel();
		treePanel.addRoot(getOrganization());
		MainWindow window = new MainWindow();
		window.setSize(800, 600);
		window.add(treePanel);
		window.setVisible(true);
	}
	
	public static OrganizationalUnit getOrganization() {
		
		Organization funnyBusinessInc = new Organization("Funny Business inc.");
		funnyBusinessInc.getSubUnits().add(new Department("Human resources", 4));
		funnyBusinessInc.getSubUnits().add(new Department("Administration", 20));

		Organization noveltyItems = new Organization("Novelty Items");
		noveltyItems.getSubUnits().add(new Department("Research & development", 4));

		funnyBusinessInc.getSubUnits().add(noveltyItems);

		Organization partyTricksOrganizationalUnit = new Organization("Party tricks");
		partyTricksOrganizationalUnit.getSubUnits().add(new Department("Research & development", 12));
		partyTricksOrganizationalUnit.getSubUnits().add(new Department("Sales", 2));

		funnyBusinessInc.getSubUnits().add(partyTricksOrganizationalUnit);
		
		return funnyBusinessInc;
	}
}