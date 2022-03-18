package compositepattern;


public class Department extends AbstractOrganizationalUnit {

	private int numberOfEmployees;

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Department(String name, int numberOfEmployees) {
		super.setName(name);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public String extendedToString() {
		return "Department '" + getName() + " (" + getNumberOfEmployees() + " employees)";
	}
}