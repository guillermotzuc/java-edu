package designpatterns.builder.faceted;

public class PersonBuilder {

	protected Person person = new Person();
	
	public PersonBuilder setName(String name) {
		this.person.name = name;
		return this;
	}
	
	public PersonAddressBuilder getAddress() {
		return new PersonAddressBuilder(person);
	}
	
	public PersonJobBuilder getJob() {
		return new PersonJobBuilder(person);
	}
	
	public Person build() {
		return person;
	}
}
