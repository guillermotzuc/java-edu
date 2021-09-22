package designpatterns.builder.faceted;

public class PersonJobBuilder extends PersonBuilder {

	public PersonJobBuilder(Person person) {
		this.person = person;
	}
	
	public PersonJobBuilder setCompany(String company) {
		this.person.company= company;
		return this;
	}
	
	public PersonJobBuilder setPosition(String position) {
		this.person.position= position;
		return this;
	}
	
	public PersonJobBuilder setAnualIncome(int anualIncome) {
		this.person.anualIncome= anualIncome;
		return this;
	}
}
