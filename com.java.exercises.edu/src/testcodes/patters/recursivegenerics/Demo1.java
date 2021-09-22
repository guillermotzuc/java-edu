package testcodes.patters.recursivegenerics;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeBuilder builder = new EmployeeBuilder();
		builder.workAs("Programes")
		.withName("Pepito");
		
		System.out.println(builder.build());
	}

}
