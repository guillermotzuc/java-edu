package testcodes.patters.recursivegenerics;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

	public EmployeeBuilder workAs(String position) {
		person.position= position;
		return self();
	}

	@Override
	protected EmployeeBuilder self() {
	
		return this;
	}
	
	
}
