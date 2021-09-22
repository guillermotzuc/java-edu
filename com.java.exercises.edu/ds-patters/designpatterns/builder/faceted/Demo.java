package designpatterns.builder.faceted;

public class Demo {

	public static void main(String[] args) {
		
		PersonBuilder personBuilder = new PersonBuilder();
		Person person=personBuilder.setName("Pepe")
				.getAddress()
				.setAddress("Fracc. Las Americas")
				.setPostCode("97302")
				.getJob()
				.setCompany("Nice Company")
				.setPosition("Software engineer")
				.setAnualIncome(45000).build();
		
		System.out.println(person);

	}

}
