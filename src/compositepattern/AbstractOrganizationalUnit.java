package compositepattern;

public abstract class AbstractOrganizationalUnit implements OrganizationalUnit {

		private String name;

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return getName() + " " + getNumberOfEmployees() + " employees";
		}
}