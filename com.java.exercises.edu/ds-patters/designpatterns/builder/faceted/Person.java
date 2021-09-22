package designpatterns.builder.faceted;

public class Person {

	//General
	protected String name;

	//Address
	protected String streetAddress, postCode, city;
	
	//Employment
	protected String company, position;
	protected int anualIncome;
	@Override
	public String toString() {
		return "Person [name=" + name + ",\n streetAddress=" + streetAddress + ",\n postCode=" + postCode + ",\n city=" + city
				+ ",\n company=" + company + ",\n position=" + position + ",\n anualIncome=" + anualIncome + "]";
	}
	
}
