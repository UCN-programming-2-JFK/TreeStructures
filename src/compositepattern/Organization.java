package compositepattern;

import java.util.*;

public class Organization extends AbstractOrganizationalUnit {

	private List<OrganizationalUnit> subUnits = new ArrayList<OrganizationalUnit>();
	
	public Organization (String name) {
		super.setName(name);
	}

	@Override
	public int getNumberOfEmployees() {
		int sum = 0;
		for(OrganizationalUnit subUnit : getSubUnits()) {
			sum += subUnit.getNumberOfEmployees();
		}
		return sum;
	}
	
	public List<OrganizationalUnit> getSubUnits() {
		return subUnits;
	}

	public String extendedToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The organization'" + getName() + "' has " + getNumberOfEmployees() + " employees.\n");
		builder.append("it has the following sub-units:\n");
		for(OrganizationalUnit unit : getSubUnits()) {
			builder.append(unit + "\n");
		}
		builder.append("\n");
		return builder.toString();
	}
}